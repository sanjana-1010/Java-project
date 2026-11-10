package Project;

import java.io.Serializable;

public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    private int patientId;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String problem;

    public Patient(int patientId, String name, int age,
                   String gender, String phone, String problem) {

        if (patientId <= 0) {
            throw new IllegalArgumentException("Patient ID must be positive.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Enter a valid age.");
        }

        if (phone == null || !phone.matches("[0-9]{10}")) {
            throw new IllegalArgumentException(
                "Phone number must contain exactly 10 digits.");
        }

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.problem = problem;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getProblem() {
        return problem;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Enter a valid age.");
        }
        this.age = age;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("[0-9]{10}")) {
            throw new IllegalArgumentException(
                "Phone number must contain exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public void displayPatient() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + phone);
        System.out.println("Problem: " + problem);
        System.out.println("--------------------------------");
    }
}