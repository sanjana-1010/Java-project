package Project;

import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class HospitalService {

    private HashMap<Integer, Patient> patients = new HashMap<>();
    private HashMap<Integer, Doctor> doctors = new HashMap<>();
    private HashMap<Integer, Appointment> appointments = new HashMap<>();

    private int nextAppointmentId = 1001;

    private final String PATIENT_FILE = "patients.dat";
    private final String DOCTOR_FILE = "doctors.dat";
    private final String APPOINTMENT_FILE = "appointments.dat";

    private String[] slots = {
        "09:00", "10:00", "11:00", "12:00",
        "14:00", "15:00", "16:00"
    };

    public HospitalService() {
        loadData();
    }

    // SAVE DATA

    private void saveData() {
        saveFile(PATIENT_FILE, patients);
        saveFile(DOCTOR_FILE, doctors);
        saveFile(APPOINTMENT_FILE, appointments);
    }

    private void saveFile(String fileName, Object data) {

        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(data);

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // LOAD DATA

    @SuppressWarnings("unchecked")
    private void loadData() {

        patients = (HashMap<Integer, Patient>) loadFile(PATIENT_FILE);
        doctors = (HashMap<Integer, Doctor>) loadFile(DOCTOR_FILE);
        appointments = (HashMap<Integer, Appointment>) loadFile(APPOINTMENT_FILE);

        for (Integer id : appointments.keySet()) {
            if (id >= nextAppointmentId) {
                nextAppointmentId = id + 1;
            }
        }

        reconnectAppointmentReferences();

        System.out.println("Hospital data loaded successfully.");
    }

    private Object loadFile(String fileName) {

        File file = new File(fileName);

        if (!file.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream(file))) {

            return ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading " + fileName + ": " + e.getMessage());
            return new HashMap<>();
        }
    }

    private void reconnectAppointmentReferences() {

        for (Appointment a : appointments.values()) {

            Patient p = patients.get(a.getPatient().getPatientId());
            Doctor d = doctors.get(a.getDoctor().getDoctorId());

            if (p != null) {
                a.setPatient(p);
            }

            if (d != null) {
                a.setDoctor(d);
            }
        }
    }

    // REGISTER PATIENT

    public void registerPatient(Patient patient) {

        if (patients.containsKey(patient.getPatientId())) {
            System.out.println("Patient ID already exists!");
            return;
        }

        patients.put(patient.getPatientId(), patient);
        saveData();

        System.out.println("Patient registered successfully!");
    }

    // ADD DOCTOR

    public void addDoctor(Doctor doctor) {

        if (doctors.containsKey(doctor.getDoctorId())) {
            System.out.println("Doctor ID already exists!");
            return;
        }

        doctors.put(doctor.getDoctorId(), doctor);
        saveData();

        System.out.println("Doctor added successfully!");
    }

    // DISPLAY ALL PATIENTS

    public void displayPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        ArrayList<Patient> list = new ArrayList<>(patients.values());

        list.sort(Comparator.comparing(
            Patient::getName, String.CASE_INSENSITIVE_ORDER));

        for (Patient p : list) {
            p.displayPatient();
        }
    }

    // DISPLAY ALL DOCTORS

    public void displayDoctors() {

        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        for (Doctor d : doctors.values()) {
            d.displayDoctor();
        }
    }

    // SEARCH PATIENT BY ID

    public void searchPatient(int id) {

        Patient p = patients.get(id);

        if (p == null) {
            System.out.println("Patient not found!");
        } else {
            p.displayPatient();
        }
    }

    // SEARCH DOCTOR BY ID

    public void searchDoctor(int id) {

        Doctor d = doctors.get(id);

        if (d == null) {
            System.out.println("Doctor not found!");
        } else {
            d.displayDoctor();
        }
    }

    // VIEW AVAILABLE SLOTS

    public void viewAvailableSlots(int doctorId, LocalDate date) {

        if (!doctors.containsKey(doctorId)) {
            System.out.println("Doctor not found!");
            return;
        }

        if (date.isBefore(LocalDate.now())) {
            System.out.println("Cannot view slots for a past date.");
            return;
        }

        System.out.println("Available slots for " + date + ":");

        boolean available = false;

        for (String slot : slots) {

            LocalTime time = LocalTime.parse(slot);

            if (date.equals(LocalDate.now()) &&
                !time.isAfter(LocalTime.now())) {
                continue;
            }

            boolean booked = false;

            for (Appointment a : appointments.values()) {

                if (a.getDoctor().getDoctorId() == doctorId &&
                    a.getDate().equals(date) &&
                    a.getTime().equals(time) &&
                    a.getStatus().equals("BOOKED")) {

                    booked = true;
                    break;
                }
            }

            if (!booked) {
                System.out.println(time);
                available = true;
            }
        }

        if (!available) {
            System.out.println("No available slots.");
        }
    }

    // BOOK APPOINTMENT

    public void bookAppointment(int patientId, int doctorId,
                                LocalDate date, LocalTime time)
                                throws AppointmentException {

        if (!patients.containsKey(patientId)) {
            throw new AppointmentException("Patient not found!");
        }

        if (!doctors.containsKey(doctorId)) {
            throw new AppointmentException("Doctor not found!");
        }

        if (date.isBefore(LocalDate.now())) {
            throw new AppointmentException("Cannot book a past date!");
        }

        if (date.equals(LocalDate.now()) &&
            !time.isAfter(LocalTime.now())) {
            throw new AppointmentException("Please select a future time!");
        }

        if (!Arrays.asList(slots).contains(time.toString())) {
            throw new AppointmentException("Invalid appointment slot!");
        }

        for (Appointment a : appointments.values()) {

            if (a.getDoctor().getDoctorId() == doctorId &&
                a.getDate().equals(date) &&
                a.getTime().equals(time) &&
                a.getStatus().equals("BOOKED")) {

                throw new AppointmentException(
                    "This time slot is already booked!");
            }
        }

        Appointment appointment = new Appointment(
            nextAppointmentId++,
            patients.get(patientId),
            doctors.get(doctorId),
            date,
            time
        );

        appointments.put(appointment.getAppointmentId(), appointment);

        saveData();

        System.out.println("Appointment booked successfully!");
        appointment.displayAppointment();
    }

    // CANCEL APPOINTMENT

    public void cancelAppointment(int appointmentId) {

        Appointment a = appointments.get(appointmentId);

        if (a == null) {
            System.out.println("Appointment not found!");
            return;
        }

        if (a.getStatus().equals("CANCELLED")) {
            System.out.println("Appointment is already cancelled!");
            return;
        }

        a.cancelAppointment();
        saveData();

        System.out.println("Appointment cancelled successfully!");
    }

    // DISPLAY ALL APPOINTMENTS

    public void displayAllAppointments() {

        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        ArrayList<Appointment> list =
            new ArrayList<>(appointments.values());

        list.sort(Comparator.comparing(Appointment::getDate)
            .thenComparing(Appointment::getTime));

        for (Appointment a : list) {
            a.displayAppointment();
        }
    }

    // VIEW DOCTOR SCHEDULE

    public void viewDoctorSchedule(int doctorId) {

        if (!doctors.containsKey(doctorId)) {
            System.out.println("Doctor not found!");
            return;
        }

        boolean found = false;

        ArrayList<Appointment> list =
            new ArrayList<>(appointments.values());

        list.sort(Comparator.comparing(Appointment::getDate)
            .thenComparing(Appointment::getTime));

        for (Appointment a : list) {

            if (a.getDoctor().getDoctorId() == doctorId &&
                a.getStatus().equals("BOOKED")) {

                a.displayAppointment();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments for this doctor.");
        }
    }

    // VIEW PATIENT HISTORY

    public void viewPatientHistory(int patientId) {

        if (!patients.containsKey(patientId)) {
            System.out.println("Patient not found!");
            return;
        }

        boolean found = false;

        for (Appointment a : appointments.values()) {

            if (a.getPatient().getPatientId() == patientId) {
                a.displayAppointment();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointment history found.");
        }
    }

    // UPDATE PATIENT

    public void updatePatient(int id, String name, int age,
                              String phone, String problem) {

        Patient p = patients.get(id);

        if (p == null) {
            System.out.println("Patient not found!");
            return;
        }

        try {
            p.setName(name);
            p.setAge(age);
            p.setPhone(phone);
            p.setProblem(problem);

            saveData();
            System.out.println("Patient details updated successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Update Error: " + e.getMessage());
        }
    }

    // UPDATE DOCTOR

    public void updateDoctor(int id, String name,
                             String specialization, double fee) {

        Doctor d = doctors.get(id);

        if (d == null) {
            System.out.println("Doctor not found!");
            return;
        }

        try {
            d.setName(name);
            d.setSpecialization(specialization);
            d.setConsultationFee(fee);

            saveData();
            System.out.println("Doctor details updated successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Update Error: " + e.getMessage());
        }
    }

    // REMOVE PATIENT

    public void removePatient(int id) {

        if (!patients.containsKey(id)) {
            System.out.println("Patient not found!");
            return;
        }

        for (Appointment a : appointments.values()) {

            if (a.getPatient().getPatientId() == id) {
                System.out.println(
                    "Cannot remove patient. Appointment history exists!");
                return;
            }
        }

        patients.remove(id);
        saveData();

        System.out.println("Patient removed successfully!");
    }

    // REMOVE DOCTOR

    public void removeDoctor(int id) {

        if (!doctors.containsKey(id)) {
            System.out.println("Doctor not found!");
            return;
        }

        for (Appointment a : appointments.values()) {

            if (a.getDoctor().getDoctorId() == id) {
                System.out.println(
                    "Cannot remove doctor. Appointment history exists!");
                return;
            }
        }

        doctors.remove(id);
        saveData();

        System.out.println("Doctor removed successfully!");
    }

    // SEARCH PATIENT BY NAME

    public void searchPatientByName(String name) {

        boolean found = false;

        for (Patient p : patients.values()) {

            if (p.getName().equalsIgnoreCase(name.trim())) {
                p.displayPatient();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Patient not found!");
        }
    }

    // SEARCH DOCTOR BY SPECIALIZATION

    public void searchDoctorBySpecialization(String specialization) {

        boolean found = false;

        for (Doctor d : doctors.values()) {

            if (d.getSpecialization().equalsIgnoreCase(specialization.trim())) {
                d.displayDoctor();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No doctor found for this specialization!");
        }
    }

    // DISPLAY TOTAL STATISTICS

    public void displayStatistics() {

        int booked = 0;
        int cancelled = 0;

        for (Appointment a : appointments.values()) {

            if (a.getStatus().equals("BOOKED")) {
                booked++;
            } else if (a.getStatus().equals("CANCELLED")) {
                cancelled++;
            }
        }

        System.out.println("\n========== HOSPITAL STATISTICS ==========");
        System.out.println("Total Patients        : " + patients.size());
        System.out.println("Total Doctors         : " + doctors.size());
        System.out.println("Total Appointments    : " + appointments.size());
        System.out.println("Booked Appointments   : " + booked);
        System.out.println("Cancelled Appointments: " + cancelled);
        System.out.println("==========================================");
    }

    // GENERATE HOSPITAL REPORT

    public void generateHospitalReport() {

        System.out.println("\n========== HOSPITAL REPORT ==========");

        displayStatistics();

        System.out.println("\n----------- DOCTOR DETAILS -----------");
        displayDoctors();

        System.out.println("\n----------- PATIENT DETAILS ----------");
        displayPatients();

        System.out.println("\n---------- APPOINTMENT DETAILS -------");
        displayAllAppointments();
    }

    // GENERATE INDIVIDUAL PATIENT REPORT

    public String generatePatientReport(int id) {

        Patient p = patients.get(id);

        if (p == null) {
            System.out.println("Patient not found!");
            return null;
        }

        StringBuilder report = new StringBuilder();

        report.append("========================================\n");
        report.append("             PATIENT REPORT             \n");
        report.append("========================================\n");

        report.append("Patient ID      : ").append(p.getPatientId()).append("\n");
        report.append("Patient Name    : ").append(p.getName()).append("\n");
        report.append("Age             : ").append(p.getAge()).append("\n");
        report.append("Gender          : ").append(p.getGender()).append("\n");
        report.append("Phone Number    : ").append(p.getPhone()).append("\n");
        report.append("Medical Problem : ").append(p.getProblem()).append("\n");

        report.append("\n--------- APPOINTMENT HISTORY ---------\n");

        boolean found = false;

        ArrayList<Appointment> list =
            new ArrayList<>(appointments.values());

        list.sort(Comparator.comparing(Appointment::getDate)
            .thenComparing(Appointment::getTime));

        for (Appointment a : list) {

            if (a.getPatient().getPatientId() == id) {

                report.append("Appointment ID : ")
                    .append(a.getAppointmentId()).append("\n");

                report.append("Doctor Name    : ")
                    .append(a.getDoctor().getName()).append("\n");

                report.append("Date           : ")
                    .append(a.getDate()).append("\n");

                report.append("Time           : ")
                    .append(a.getTime()).append("\n");

                report.append("Status         : ")
                    .append(a.getStatus()).append("\n");

                report.append("----------------------------------------\n");

                found = true;
            }
        }

        if (!found) {
            report.append("No appointment history found.\n");
        }

        report.append("========================================\n");

        return report.toString();
    }

    // GENERATE ALL PATIENT REPORTS

    public void generateAllPatientsReport() {

        if (patients.isEmpty()) {
            System.out.println("No patients registered!");
            return;
        }

        for (Patient p : patients.values()) {
            System.out.println(generatePatientReport(p.getPatientId()));
        }
    }

    // SAVE PATIENT REPORT TO FILE

    public void savePatientReportToFile(int id) {

        String report = generatePatientReport(id);

        if (report == null) {
            return;
        }

        String fileName = "PatientReport_" + id + ".txt";

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(fileName))) {

            writer.print(report);

            System.out.println("Patient report saved successfully!");
            System.out.println("File name: " + fileName);

        } catch (IOException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }

    // RECOMMEND DOCTORS BASED ON PATIENT PROBLEM

    public void recommendDoctorsForProblem(String problem) {

        if (problem == null || problem.trim().isEmpty()) {
            System.out.println("Please enter a valid problem.");
            return;
        }

        String p = problem.toLowerCase().trim();
        String specialization = "";

        if (p.contains("heart") || p.contains("cardiac")) {
            specialization = "cardiologist";
        }
        else if (p.contains("skin") || p.contains("rash")) {
            specialization = "dermatologist";
        }
        else if (p.contains("fever") || p.contains("cold") ||
                 p.contains("general")) {
            specialization = "general physician";
        }
        else if (p.contains("brain") || p.contains("migraine") ||
                 p.contains("headache")) {
            specialization = "neurologist";
        }
        else if (p.contains("bone") || p.contains("joint") ||
                 p.contains("back pain")) {
            specialization = "orthopedic";
        }
        else if (p.contains("eye") || p.contains("vision")) {
            specialization = "ophthalmologist";
        }
        else if (p.contains("teeth") || p.contains("tooth") ||
                 p.contains("dental")) {
            specialization = "dentist";
        }
        else if (p.contains("ear") || p.contains("nose") ||
                 p.contains("throat")) {
            specialization = "ent";
        }

        if (specialization.isEmpty()) {
            System.out.println("No automatic specialization match found.");
            System.out.println(
                "Please consult a qualified medical professional.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("          RECOMMENDED DOCTORS");
        System.out.println("========================================");
        System.out.println("Patient Problem: " + problem);
        System.out.println("Recommended Specialization: " + specialization);
        System.out.println("----------------------------------------");

        boolean found = false;

        for (Doctor d : doctors.values()) {

            if (d.getSpecialization().toLowerCase()
                    .contains(specialization)) {

                d.displayDoctor();
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                "No doctor available for this specialization.");
        }

        System.out.println("========================================");
    }
}