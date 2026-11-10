package Project;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;
    private String status;

    public Appointment(int appointmentId, Patient patient,
                       Doctor doctor, LocalDate date, LocalTime time) {

        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = "BOOKED";
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void cancelAppointment() {
        status = "CANCELLED";
    }

    public void displayAppointment() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient: " + patient.getName());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Status: " + status);
        System.out.println("--------------------------------");
    }
}