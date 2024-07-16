package application;

import java.util.Scanner;
import Models.Citizen;
import exceptions.NonEligibleException;

public class CitizenTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter country: ");
            String country = scanner.nextLine();

            System.out.print("Enter sex: ");
            String sex = scanner.nextLine();

            System.out.print("Enter marital status: ");
            String maritalStatus = scanner.nextLine();

            System.out.print("Enter annual income: ");
            double annualIncome = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter economy status: ");
            String economyStatus = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();

            // Create Citizen object
            Citizen citizen = new Citizen(name, id, country, sex, maritalStatus, annualIncome, economyStatus, age);

            // Display Citizen information
            System.out.println("\nCitizen Information:");
            System.out.println(citizen);
        } catch (NonEligibleException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
