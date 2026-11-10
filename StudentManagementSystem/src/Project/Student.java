package Project;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String email;
    private double marks;
    private int attendance;
    private StudentStatus status;
    private Course course;

    public Student(int id, String name, String email,
            double marks, int attendance,
            StudentStatus status, Course course) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.marks = marks;
        this.attendance = attendance;
        this.status = status;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getMarks() {
        return marks;
    }

    public int getAttendance() {
        return attendance;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public Course getCourse() {
        return course;
    }

    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException(
                    "Marks must be between 0 and 100!");
        }

        this.marks = marks;
    }

    public void setAttendance(int attendance) {
        if (attendance < 0 || attendance > 100) {
            throw new IllegalArgumentException(
                    "Attendance must be between 0 and 100!");
        }

        this.attendance = attendance;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public String calculateGrade() {

        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 40)
            return "D";
        else
            return "F";
    }

    public String getPerformanceRemark() {

        if (marks >= 90)
            return "Outstanding";
        else if (marks >= 80)
            return "Excellent";
        else if (marks >= 70)
            return "Very Good";
        else if (marks >= 60)
            return "Good";
        else if (marks >= 40)
            return "Needs Improvement";
        else
            return "Academic Support Required";
    }

    public boolean isAttendanceEligible() {
        return attendance >= 75;
    }

    public void displayStudent() {

        System.out.println("\n========== STUDENT PROFILE ==========");

        System.out.println("Student ID      : " + id);
        System.out.println("Student Name    : " + name);
        System.out.println("Email           : " + email);
        System.out.println("Marks           : " + marks);
        System.out.println("Grade           : " + calculateGrade());
        System.out.println("Performance     : " + getPerformanceRemark());
        System.out.println("Attendance      : " + attendance + "%");
        System.out.println("Attendance Check: " +
                (isAttendanceEligible() ? "Eligible" : "Warning"));
        System.out.println("Student Status  : " + status);

        course.displayCourse();

        System.out.println("======================================");
    }
}