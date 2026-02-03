import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Console-based Student Management System.
 * Provides menu-driven CRUD operations for Student records.
 */
public class  StudentManagementSystem {
    // In-memory storage for students
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewStudent(sc);
                    break;
                case 3:
                    updateStudent(sc);
                    break;
                case 4:
                    deleteStudent(sc);
                    break;
                case 5:
                    viewAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Method to add a student
    private static void addStudent(Scanner sc) {
        System.out.print("Enter ID, Name, Age: ");
        int id = sc.nextInt();
        String name = sc.next();
        int age = sc.nextInt();
        students.add(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }

    // Method to view a student by ID
    private static void viewStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        Student s = students.stream()
                            .filter(st -> st.getId() == id)
                            .findFirst()
                            .orElse(null);
        System.out.println(s != null ? s : "Student not found.");
    }

    // Method to update student details
    private static void updateStudent(Scanner sc) {
        System.out.print("Enter ID, New Name, New Age: ");
        int id = sc.nextInt();
        String name = sc.next();
        int age = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, new Student(id, name, age));
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Method to delete a student
    private static void deleteStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        boolean removed = students.removeIf(st -> st.getId() == id);
        System.out.println(removed ? "Student deleted successfully!" : "Student not found.");
    }

    // Method to view all students
    private static void viewAllStudents() {
        System.out.println("\n--- All Students ---");
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            students.forEach(System.out::println);
        }
    }
}
