import java.util.Scanner;

public class Harmonicseries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of terms for Harmonic Series
        System.out.print("Enter the number of terms for the Harmonic Series: ");
        int n = scanner.nextInt();

        // Generate and calculate Harmonic Series
        double harmonicSum = 0.0;
        StringBuilder harmonicSeries = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            harmonicSum += 1.0 / i;
            if (i > 1) {
                harmonicSeries.append(" + ");
            }
            harmonicSeries.append("1/").append(i);
        }

        // Output Harmonic Series and Sum
        System.out.println("Harmonic Series: " + harmonicSeries.toString() + " = " + harmonicSum);
        
        scanner.close();
    }
}
