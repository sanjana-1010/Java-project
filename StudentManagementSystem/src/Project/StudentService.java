package Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentService {

    private HashMap<Integer, Student> students;

    public StudentService() {
        students = new HashMap<Integer, Student>();
    }
    
    public boolean isStudentIdExists(int id) {
        return students.containsKey(id);
    }

    public void addStudent(Student student)
            throws DuplicateStudentException {

        if (students.containsKey(student.getId())) {
            throw new DuplicateStudentException(
                "Student ID " + student.getId() + " already exists!"
            );
        }

        students.put(student.getId(), student);
        System.out.println("Student added successfully!");
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        ArrayList<Student> list =
                new ArrayList<Student>(students.values());

        Collections.sort(list, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        });

        System.out.println("\nID\tName\t\tMarks\tAttendance");
        System.out.println("-----------------------------------------------");

        for (Student s : list) {
            System.out.println(s.getId() + "\t" +
                    s.getName() + "\t\t" +
                    s.getMarks() + "\t" +
                    s.getAttendance() + "%");
        }
    }

    public void searchById(int id) {

        Student s = students.get(id);

        if (s == null) {
            System.out.println("Student not found!");
        } else {
            s.displayStudent();
        }
    }

    public void searchByName(String name, Scanner sc) {

        ArrayList<Student> matchedStudents =
                new ArrayList<Student>();

        for (Student s : students.values()) {
            if (s.getName().equalsIgnoreCase(name)) {
                matchedStudents.add(s);
            }
        }

        if (matchedStudents.isEmpty()) {
            System.out.println("Student not found.");
            return;
        }

        if (matchedStudents.size() == 1) {

            System.out.println("\nStudent Found!");
            matchedStudents.get(0).displayStudent();

        } else {

            System.out.println(
                "\nMultiple students found with the same name."
            );

            System.out.println("\nID\tName");

            for (Student s : matchedStudents) {
                System.out.println(s.getId() + "\t" + s.getName());
            }

            System.out.print("\nEnter Student ID: ");
            int id = sc.nextInt();

            Student selected = null;

            for (Student s : matchedStudents) {
                if (s.getId() == id) {
                    selected = s;
                    break;
                }
            }

            if (selected != null) {
                System.out.println("\nSelected Student Details:");
                selected.displayStudent();
            } else {
                System.out.println(
                    "Invalid Student ID for this name."
                );
            }
        }
    }

    public void updateMarks(int id, double marks) {

        Student s = students.get(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        s.setMarks(marks);
        System.out.println("Marks updated successfully!");
    }

    public void updateAttendance(int id, int attendance) {

        Student s = students.get(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        s.setAttendance(attendance);
        System.out.println("Attendance updated successfully!");
    }

    public void calculateGrade(int id) {

        Student s = students.get(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Student Name: " + s.getName());
        System.out.println("Marks: " + s.getMarks());
        System.out.println("Grade: " + s.calculateGrade());
        System.out.println("Remark: " + s.getPerformanceRemark());
    }

    public boolean removeStudent(int id) {

        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Student removed successfully!");
            return true;
        }

        System.out.println("Student not found!");
        return false;
    }

    public void displayTopper() {

        Student topper = null;

        for (Student s : students.values()) {
            if (topper == null ||
                    s.getMarks() > topper.getMarks()) {
                topper = s;
            }
        }

        if (topper == null) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nClass Topper:");
            topper.displayStudent();
        }
    }

    public void displayTopThree() {

        ArrayList<Student> list =
                new ArrayList<Student>(students.values());

        if (list.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        Collections.sort(list, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getMarks(), s1.getMarks());
            }
        });

        System.out.println("\nTop Three Performers:");

        for (int i = 0; i < Math.min(3, list.size()); i++) {
            Student s = list.get(i);

            System.out.println("\nRank: " + (i + 1));
            System.out.println("ID: " + s.getId());
            System.out.println("Name: " + s.getName());
            System.out.println("Marks: " + s.getMarks());
        }
    }

    public void attendanceReport() {

        boolean found = false;

        System.out.println("\nStudents with attendance below 75%:");

        for (Student s : students.values()) {

            if (!s.isAttendanceEligible()) {
                System.out.println(
                    s.getId() + " - " + s.getName() +
                    " - " + s.getAttendance() + "%"
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No attendance alerts.");
        }
    }

    public void courseReport() {

        HashMap<String, Integer> courseCounts =
                new HashMap<String, Integer>();

        for (Student s : students.values()) {

            if (s.getCourse() != null) {

                String courseName = s.getCourse().getCourseName();

                if (courseCounts.containsKey(courseName)) {
                    courseCounts.put(
                        courseName,
                        courseCounts.get(courseName) + 1
                    );
                } else {
                    courseCounts.put(courseName, 1);
                }
            }
        }

        System.out.println("\nCourse-wise Student Report:");

        for (Map.Entry<String, Integer> entry :
                courseCounts.entrySet()) {

            System.out.println(
                entry.getKey() + " : " + entry.getValue() + " students"
            );
        }
    }

    public void performanceAnalysis() {

        int excellent = 0;
        int good = 0;
        int average = 0;
        int poor = 0;

        for (Student s : students.values()) {

            double marks = s.getMarks();

            if (marks >= 90) {
                excellent++;
            } else if (marks >= 70) {
                good++;
            } else if (marks >= 40) {
                average++;
            } else {
                poor++;
            }
        }

        System.out.println("\nPerformance Analysis");
        System.out.println("Excellent: " + excellent);
        System.out.println("Good: " + good);
        System.out.println("Average: " + average);
        System.out.println("Poor: " + poor);
    }

    public void updateStatus(int id, StudentStatus status) {

        Student s = students.get(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        s.setStatus(status);
        System.out.println("Student status updated successfully!");
    }

    public void displayDashboard() {

        int active = 0;
        int inactive = 0;
        int completed = 0;
        int alerts = 0;

        for (Student s : students.values()) {

            if (s.getStatus() == StudentStatus.ACTIVE) {
                active++;
            } else if (s.getStatus() == StudentStatus.INACTIVE) {
                inactive++;
            } else if (s.getStatus() == StudentStatus.COMPLETED) {
                completed++;
            }

            if (!s.isAttendanceEligible()) {
                alerts++;
            }
        }

        System.out.println("\n===== ADMIN DASHBOARD =====");
        System.out.println("Total Students: " + students.size());
        System.out.println("Active Students: " + active);
        System.out.println("Inactive Students: " + inactive);
        System.out.println("Completed Students: " + completed);
        System.out.println("Attendance Alerts: " + alerts);
    }

    public String generateReportCard(int id) {

        Student s = students.get(id);

        if (s == null) {
            return null;
        }

        StringBuilder report = new StringBuilder();

        report.append("========== STUDENT REPORT CARD ==========\n");
        report.append("Student ID: ").append(s.getId()).append("\n");
        report.append("Student Name: ").append(s.getName()).append("\n");
        report.append("Email: ").append(s.getEmail()).append("\n");
        report.append("Status: ").append(s.getStatus()).append("\n");

        if (s.getCourse() != null) {
            report.append("Course ID: ")
                    .append(s.getCourse().getCourseId()).append("\n");
            report.append("Course Name: ")
                    .append(s.getCourse().getCourseName()).append("\n");
            report.append("Course Duration: ")
                    .append(s.getCourse().getDuration())
                    .append(" months\n");
        }

        report.append("Marks: ").append(s.getMarks()).append("/100\n");
        report.append("Grade: ").append(s.calculateGrade()).append("\n");
        report.append("Performance: ")
                .append(s.getPerformanceRemark()).append("\n");
        report.append("Attendance: ")
                .append(s.getAttendance()).append("%\n");

        report.append("Attendance Eligibility: ")
                .append(s.isAttendanceEligible()
                        ? "Eligible" : "Not Eligible")
                .append("\n");

        report.append("=========================================\n");

        return report.toString();
    }

    public HashMap<Integer, Student> getAllStudents() {
        return students;
    }

    public void loadStudents(HashMap<Integer, Student> loadedStudents) {
        students = loadedStudents;
    }
}