package Project;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static StudentService service = new StudentService();

    static StudentFileService fileService =
            new StudentFileService();

    public static int readInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine().trim());
                return value;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer!");
            }
        }
    }

    public static double readDouble(String message) {

        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(sc.nextLine().trim());
                return value;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    public static void addStudent() {

        try {

            int id = readInt("Enter Student ID: ");

            // Check duplicate ID immediately
            if (service.isStudentIdExists(id)) {
                throw new DuplicateStudentException(
                    "Student ID " + id + " already exists!"
                );
            }

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter Email: ");
            String email = sc.nextLine().trim();

            double marks = readDouble("Enter Marks: ");

            int attendance = readInt("Enter Attendance: ");

            System.out.println("\nSelect Student Status:");
            System.out.println("1. ACTIVE");
            System.out.println("2. INACTIVE");
            System.out.println("3. COMPLETED");

            int choice = readInt("Enter your choice: ");

            StudentStatus status;

            switch (choice) {
                case 1:
                    status = StudentStatus.ACTIVE;
                    break;
                case 2:
                    status = StudentStatus.INACTIVE;
                    break;
                case 3:
                    status = StudentStatus.COMPLETED;
                    break;
                default:
                    System.out.println("Invalid status choice!");
                    return;
            }

            int courseId = readInt("Enter Course ID: ");

            System.out.print("Enter Course Name: ");
            String courseName = sc.nextLine().trim();

            int duration = readInt("Enter Course Duration in months: ");

            Course course = new Course(courseId, courseName, duration);

            Student student = new Student(
                id, name, email, marks,
                attendance, status, course
            );

            service.addStudent(student);

            fileService.saveStudents(service.getAllStudents());

        } catch (DuplicateStudentException e) {

            System.out.println("Exception: " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        service.loadStudents(fileService.loadStudents());

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("       SMART CAMPUS SYSTEM");
            System.out.println("==================================");

            System.out.println("1. Admin Dashboard");
            System.out.println("2. Add Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Search Student By ID");
            System.out.println("5. Search Student By Name");
            System.out.println("6. Update Student Marks");
            System.out.println("7. Update Attendance");
            System.out.println("8. Calculate Grade");
            System.out.println("9. Remove Student");
            System.out.println("10. Display Class Topper");
            System.out.println("11. Top Three Performers");
            System.out.println("12. Attendance Alert Report");
            System.out.println("13. Course-wise Report");
            System.out.println("14. Performance Analysis");
            System.out.println("15. Update Student Status");
            System.out.println("16. Save Student Records");
            System.out.println("17. Generate Student Report Card");
            System.out.println("18. Exit");

            System.out.println("==================================");

            choice = readInt("Enter Your Choice: ");

            switch (choice) {

                case 1:
                    service.displayDashboard();
                    break;

                case 2:
                    addStudent();
                    break;

                case 3:
                    service.displayAllStudents();
                    break;

                case 4: {
                    int id = readInt("Enter Student ID: ");
                    service.searchById(id);
                    break;
                }

                case 5: {
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                    } else {
                        service.searchByName(name, sc);
                    }
                    break;
                }

                case 6: {
                    int id = readInt("Enter Student ID: ");
                    double marks = readDouble("Enter New Marks: ");

                    try {
                        service.updateMarks(id, marks);
                        fileService.saveStudents(service.getAllStudents());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                    break;
                }

                case 7: {
                    int id = readInt("Enter Student ID: ");
                    int attendance =
                            readInt("Enter New Attendance: ");

                    try {
                        service.updateAttendance(id, attendance);
                        fileService.saveStudents(service.getAllStudents());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                    break;
                }

                case 8: {
                    int id = readInt("Enter Student ID: ");
                    service.calculateGrade(id);
                    break;
                }

                case 9: {
                    int id = readInt("Enter Student ID to Remove: ");

                    if (service.removeStudent(id)) {
                        fileService.saveStudents(service.getAllStudents());
                    }
                    break;
                }

                case 10:
                    service.displayTopper();
                    break;

                case 11:
                    service.displayTopThree();
                    break;

                case 12:
                    service.attendanceReport();
                    break;

                case 13:
                    service.courseReport();
                    break;

                case 14:
                    service.performanceAnalysis();
                    break;

                case 15: {
                    int id = readInt("Enter Student ID: ");

                    System.out.println("1. ACTIVE");
                    System.out.println("2. INACTIVE");
                    System.out.println("3. COMPLETED");

                    int statusChoice =
                            readInt("Enter New Status: ");

                    StudentStatus status;

                    switch (statusChoice) {
                        case 1:
                            status = StudentStatus.ACTIVE;
                            break;

                        case 2:
                            status = StudentStatus.INACTIVE;
                            break;

                        case 3:
                            status = StudentStatus.COMPLETED;
                            break;

                        default:
                            System.out.println("Invalid status choice!");
                            break;
                    }

                    if (statusChoice >= 1 && statusChoice <= 3) {
                        status = StudentStatus.values()[statusChoice - 1];
                        service.updateStatus(id, status);
                        fileService.saveStudents(service.getAllStudents());
                    }
                    break;
                }

                case 16:
                    fileService.saveStudents(service.getAllStudents());
                    break;

                case 17: {
                    int id = readInt("Enter Student ID: ");

                    String report = service.generateReportCard(id);

                    if (report == null) {
                        System.out.println("Student not found!");
                    } else {
                        System.out.println("\n" + report);
                        fileService.saveReportCard(id, report);
                    }
                    break;
                }

                case 18:
                    fileService.saveStudents(service.getAllStudents());
                    System.out.println("Thank you for using Smart Campus!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 18);

        sc.close();
    }
}