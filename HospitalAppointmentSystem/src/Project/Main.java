package Project;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static HospitalService service = new HospitalService();

    // READ INTEGER

    public static int readInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // READ DOUBLE

    public static double readDouble(String message) {

        while (true) {
            try {
                System.out.print(message);

                double value = Double.parseDouble(sc.nextLine().trim());

                if (!Double.isFinite(value)) {
                    System.out.println("Enter a valid amount.");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }

    // READ PHONE NUMBER

    public static String readPhone(String message) {

        while (true) {

            System.out.print(message);
            String phone = sc.nextLine().trim();

            if (phone.matches("[0-9]{10}")) {
                return phone;
            } else {
                System.out.println(
                    "Invalid phone number! Please enter exactly 10 digits.");
            }
        }
    }

    // READ DATE

    public static LocalDate readDate() {

        while (true) {
            try {
                System.out.print("Enter date (YYYY-MM-DD): ");
                return LocalDate.parse(sc.nextLine().trim());

            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Try again.");
            }
        }
    }

    // READ TIME

    public static LocalTime readTime() {

        while (true) {
            try {
                System.out.print("Enter time (HH:MM): ");
                return LocalTime.parse(sc.nextLine().trim());

            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Try again.");
            }
        }
    }

    // REGISTER PATIENT

    public static void registerPatient() {

        try {
            int id = readInt("Enter Patient ID: ");

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            int age = readInt("Enter Age: ");

            System.out.print("Enter Gender: ");
            String gender = sc.nextLine();

            String phone = readPhone(
                "Enter Phone Number (10 digits): ");

            System.out.print("Enter Problem: ");
            String problem = sc.nextLine();

            Patient p = new Patient(
                id, name, age, gender, phone, problem);

            service.registerPatient(p);

            // RECOMMEND DOCTORS AUTOMATICALLY

            service.recommendDoctorsForProblem(problem);

        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }

    // ADD DOCTOR

    public static void addDoctor() {

        try {
            int id = readInt("Enter Doctor ID: ");

            System.out.print("Enter Doctor Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Specialization: ");
            String specialization = sc.nextLine();

            double fee = readDouble("Enter Consultation Fee: ");

            Doctor d = new Doctor(
                id, name, specialization, fee);

            service.addDoctor(d);

        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }

    // BOOK APPOINTMENT

    public static void bookAppointment() {

        try {
            int patientId = readInt("Enter Patient ID: ");
            int doctorId = readInt("Enter Doctor ID: ");

            LocalDate date = readDate();
            LocalTime time = readTime();

            service.bookAppointment(
                patientId, doctorId, date, time);

        } catch (AppointmentException e) {
            System.out.println("Booking Exception: " + e.getMessage());
        }
    }

    // MAIN METHOD

    public static void main(String[] args) {

        int choice;

        System.out.println("======================================");
        System.out.println("          MEDICARE PRO SYSTEM");
        System.out.println("======================================");

        do {

            System.out.println("\n1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. View Available Slots");
            System.out.println("6. View Doctor Schedule");
            System.out.println("7. View Patient History");
            System.out.println("8. Display All Patients");
            System.out.println("9. Display All Doctors");
            System.out.println("10. Search Patient By ID");
            System.out.println("11. Search Doctor By ID");
            System.out.println("12. Display All Appointments");

            System.out.println("13. Update Patient Details");
            System.out.println("14. Update Doctor Details");
            System.out.println("15. Remove Patient");
            System.out.println("16. Remove Doctor");
            System.out.println("17. Search Patient By Name");
            System.out.println("18. Search Doctor By Specialization");
            System.out.println("19. Display Total Statistics");
            System.out.println("20. Generate Hospital Report");
            System.out.println("21. Generate Individual Patient Report");
            System.out.println("22. Generate All Patients Report");
            System.out.println("23. Save Patient Report To File");
            System.out.println("24. Find Doctors Based On Patient Problem");

            System.out.println("--------------------------------------");
            System.out.println("25. Exit");
            System.out.println("======================================");
            System.out.println("Please select an option to continue");
            System.out.println("======================================");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    addDoctor();
                    break;

                case 3:
                    bookAppointment();
                    break;

                case 4:
                    int appointmentId =
                        readInt("Enter Appointment ID: ");

                    service.cancelAppointment(appointmentId);
                    break;

                case 5:
                    int doctorId =
                        readInt("Enter Doctor ID: ");

                    LocalDate date = readDate();

                    service.viewAvailableSlots(doctorId, date);
                    break;

                case 6:
                    int dId = readInt("Enter Doctor ID: ");
                    service.viewDoctorSchedule(dId);
                    break;

                case 7:
                    int pId = readInt("Enter Patient ID: ");
                    service.viewPatientHistory(pId);
                    break;

                case 8:
                    service.displayPatients();
                    break;

                case 9:
                    service.displayDoctors();
                    break;

                case 10:
                    int searchPatientId =
                        readInt("Enter Patient ID: ");

                    service.searchPatient(searchPatientId);
                    break;

                case 11:
                    int searchDoctorId =
                        readInt("Enter Doctor ID: ");

                    service.searchDoctor(searchDoctorId);
                    break;

                case 12:
                    service.displayAllAppointments();
                    break;

                case 25:
                    System.out.println(
                        "Thank you for using MediCare Pro!");
                    break;

                case 13:
                    int updatePatientId =
                        readInt("Enter Patient ID: ");

                    System.out.print("Enter New Name: ");
                    String newPatientName = sc.nextLine();

                    int newAge = readInt("Enter New Age: ");

                    String newPhone = readPhone(
                        "Enter New Phone Number (10 digits): ");

                    System.out.print("Enter New Medical Problem: ");
                    String newProblem = sc.nextLine();

                    service.updatePatient(
                        updatePatientId,
                        newPatientName,
                        newAge,
                        newPhone,
                        newProblem
                    );
                    break;

                case 14:
                    int updateDoctorId =
                        readInt("Enter Doctor ID: ");

                    System.out.print("Enter New Doctor Name: ");
                    String newDoctorName = sc.nextLine();

                    System.out.print("Enter New Specialization: ");
                    String newSpecialization = sc.nextLine();

                    double newFee =
                        readDouble("Enter New Consultation Fee: ");

                    service.updateDoctor(
                        updateDoctorId,
                        newDoctorName,
                        newSpecialization,
                        newFee
                    );
                    break;

                case 15:
                    int removePatientId =
                        readInt("Enter Patient ID: ");

                    service.removePatient(removePatientId);
                    break;

                case 16:
                    int removeDoctorId =
                        readInt("Enter Doctor ID: ");

                    service.removeDoctor(removeDoctorId);
                    break;

                case 17:
                    System.out.print("Enter Patient Name: ");
                    String patientName = sc.nextLine();

                    service.searchPatientByName(patientName);
                    break;

                case 18:
                    System.out.print("Enter Specialization: ");
                    String specialization = sc.nextLine();

                    service.searchDoctorBySpecialization(
                        specialization);
                    break;

                case 19:
                    service.displayStatistics();
                    break;

                case 20:
                    service.generateHospitalReport();
                    break;

                case 21:
                    int reportPatientId =
                        readInt("Enter Patient ID: ");

                    String report =
                        service.generatePatientReport(reportPatientId);

                    if (report != null) {
                        System.out.println(report);
                    }
                    break;

                case 22:
                    service.generateAllPatientsReport();
                    break;

                case 23:
                    int saveReportId =
                        readInt("Enter Patient ID: ");

                    service.savePatientReportToFile(saveReportId);
                    break;

                case 24:
                    System.out.print("Enter Patient Problem: ");
                    String patientProblem = sc.nextLine();

                    service.recommendDoctorsForProblem(patientProblem);
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please try again.");
            }

        } while (choice != 13);

        sc.close();
    }
}