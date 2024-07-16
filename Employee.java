import java.util.Scanner;

public class Employee {
    private String name;
    private String employeeID;
    private double salary;

    // Constructor
    public Employee(String name, String employeeID, double salary) {
        this.name = name;
        this.employeeID = employeeID;
        this.salary = salary;
    }

    // Method to calculate the yearly salary
    public double calculateYearlySalary() {
        return salary * 12;
    }

    // Method to give a raise to the employee
    public void giveRaise(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Percentage cannot be negative");
        }
        salary += salary * (percentage / 100);
    }

    // Method to display employee information
    public void displayEmployeeInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Monthly Salary: $" + salary);
        System.out.println("Yearly Salary: $" + calculateYearlySalary());
    }

    // Main method to test the Employee class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        System.out.print("Enter employee monthly salary: ");
        double salary = scanner.nextDouble();

        Employee emp = new Employee(name, employeeID, salary);
        emp.displayEmployeeInfo();

        System.out.print("\nEnter raise percentage: ");
        double percentage = scanner.nextDouble();
        
        emp.giveRaise(percentage);
        System.out.println("\nAfter raise:");
        emp.displayEmployeeInfo();

        scanner.close();
    }
}
