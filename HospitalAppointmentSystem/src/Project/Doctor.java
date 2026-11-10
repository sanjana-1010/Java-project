package Project;

import java.io.Serializable;

public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    private int doctorId;
    private String name;
    private String specialization;
    private double consultationFee;

    public Doctor(int doctorId, String name,
                  String specialization, double consultationFee) {

        if (doctorId <= 0)
            throw new IllegalArgumentException("Doctor ID must be positive.");

        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Doctor name cannot be empty.");

        if (specialization == null || specialization.trim().isEmpty())
            throw new IllegalArgumentException("Specialization cannot be empty.");

        if (!Double.isFinite(consultationFee) || consultationFee < 0)
            throw new IllegalArgumentException("Invalid consultation fee.");

        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty.");
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty())
            throw new IllegalArgumentException("Specialization cannot be empty.");
        this.specialization = specialization;
    }

    public void setConsultationFee(double fee) {
        if (!Double.isFinite(fee) || fee < 0)
            throw new IllegalArgumentException("Invalid consultation fee.");
        this.consultationFee = fee;
    }

    public void displayDoctor() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Consultation Fee: " + consultationFee);
        System.out.println("--------------------------------");
    }
}