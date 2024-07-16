import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Student class
public class Student {
    private int student_id;
    private String student_name;
    private List<Double> grades;

    // Constructor
    public Student(int student_id, String student_name) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.grades = new ArrayList<>();
    }

    // Getter for student_id
    public int getStudentId() {
        return student_id;
    }

    // Setter for student_id
    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    // Getter for student_name
    public String getStudentName() {
        return student_name;
    }

    // Setter for student_name
    public void setStudentName(String student_name) {
        this.student_name = student_name;
    }

    // Method to add a grade with validation
    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
        } else {
            grades.add(grade);
            System.out.println("Grade added: " + grade);
        }
    }

    // Method to display all grades
    public void displayGrades() {
        System.out.println("Grades for " + student_name + ": " + grades);
    }

    // Main method to test the Student class with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input student details
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        // Create Student object
        Student student = new Student(id, name);

        // Allow the user to modify the name if desired
        System.out.print("Do you want to change the student name? (yes/no): ");
        String response = scanner.nextLine();
        if ("yes".equalsIgnoreCase(response)) {
            System.out.print("Enter the new student name: ");
            String newName = scanner.nextLine();
            student.setStudentName(newName);
        }

        // Input the number of grades to be added
        System.out.print("How many grades do you want to add? ");
        int numberOfGrades = scanner.nextInt();

        // Input and add grades with validation
        for (int i = 0; i < numberOfGrades; i++) {
            double grade = -1;
            while (grade < 0 || grade > 100) {
                System.out.print("Enter grade #" + (i + 1) + ": ");
                grade = scanner.nextDouble();
                if (grade < 0 || grade > 100) {
                    System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
                } else {
                    student.addGrade(grade);
                }
            }
        }

        // Display all grades
        student.displayGrades();

        scanner.close();
    }
}
