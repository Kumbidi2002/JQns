import java.util.Scanner;

public class QuadraticSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read coefficients from the user
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        // Calculate the discriminant
        double discriminant = b * b - 4 * a * c;

        // Check the discriminant to determine the nature of the roots
        if (discriminant > 0) {
            // Two real and distinct roots
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("The roots are %.2f and %.2f%n", root1, root2);
        } else if (discriminant == 0) {
            // One real root (repeated root)
            double root = -b / (2 * a);
            System.out.printf("The root is %.2f%n", root);
        } else {
            // Discriminant is negative, no real roots
            System.out.println("There are no real solutions.");
        }

        scanner.close();
    }
}
