package Oops;

import java.util.Scanner;

class Patient {

    private int patientId;
    private String patientName;
    private int age;
    private String disease;
    private String doctorName;
    private double billAmount;

    public void setPatientId(int patientId) {
        if (patientId > 0) {
            this.patientId = patientId;
        } else {
            System.out.println("Invalid Patient ID!");
        }
    }

    public void setPatientName(String patientName) {
        if (!patientName.isEmpty()) {
            this.patientName = patientName;
        } else {
            System.out.println("Name cannot be empty!");
        }
    }

    public void setAge(int age) {
        if (age > 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid Age!");
        }
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setBillAmount(double billAmount) {
        if (billAmount >= 0) {
            this.billAmount = billAmount;
        } else {
            System.out.println("Invalid Bill Amount!");
        }
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void displayDetails() {
        System.out.println("\n----- PATIENT DETAILS -----");
        System.out.println("Patient ID   : " + getPatientId());
        System.out.println("Patient Name : " + getPatientName());
        System.out.println("Age          : " + getAge());
        System.out.println("Disease      : " + getDisease());
        System.out.println("Doctor Name  : " + getDoctorName());
        System.out.println("Bill Amount  : " + getBillAmount());
    }
}

public class HospitalEncapsulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Patient p = new Patient();

        int choice;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Display Patient Details");
            System.out.println("3. Update Patient Details");
            System.out.println("4. Assign Doctor");
            System.out.println("5. Calculate Hospital Bill");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    p.setPatientId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    p.setPatientName(sc.nextLine());

                    System.out.print("Enter Age: ");
                    p.setAge(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Disease: ");
                    p.setDisease(sc.nextLine());

                    System.out.println("Patient Registered Successfully!");
                    break;

                case 2:
                    p.displayDetails();
                    break;

                case 3:
                    System.out.print("Enter New Patient Name: ");
                    p.setPatientName(sc.nextLine());

                    System.out.print("Enter New Age: ");
                    p.setAge(sc.nextInt());
                    sc.nextLine();

                    System.out.println("Patient Details Updated!");
                    break;

                case 4:
                    System.out.print("Enter Doctor Name: ");
                    p.setDoctorName(sc.nextLine());

                    System.out.println("Doctor Assigned Successfully!");
                    break;

                case 5:
                    System.out.print("Enter Hospital Bill Amount: ");
                    double amount = sc.nextDouble();

                    p.setBillAmount(amount);

                    System.out.println("Hospital Bill: Rs. "
                            + p.getBillAmount());
                    break;

                case 6:
                    System.out.println("Thank You! Visit Again.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}