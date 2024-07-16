import java.util.Scanner;

public class Fraction {
    private int numerator;
    private int denominator;

    // Constructor
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // Simplify the fraction
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // Calculate the Greatest Common Divisor (GCD)
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Add two fractions
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Subtract two fractions
    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Multiply two fractions
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Divide two fractions
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero fraction");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Override toString() method for easy display
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Main method to test the Fraction class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the numerator and denominator for the first fraction:");
        int numerator1 = scanner.nextInt();
        int denominator1 = scanner.nextInt();

        System.out.println("Enter the numerator and denominator for the second fraction:");
        int numerator2 = scanner.nextInt();
        int denominator2 = scanner.nextInt();

        Fraction f1 = new Fraction(numerator1, denominator1);
        Fraction f2 = new Fraction(numerator2, denominator2);

        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);

        Fraction resultAdd = f1.add(f2);
        System.out.println("f1 + f2 = " + resultAdd);

        Fraction resultSubtract = f1.subtract(f2);
        System.out.println("f1 - f2 = " + resultSubtract);

        Fraction resultMultiply = f1.multiply(f2);
        System.out.println("f1 * f2 = " + resultMultiply);

        Fraction resultDivide = f1.divide(f2);
        System.out.println("f1 / f2 = " + resultDivide);
        
        scanner.close();
    }
}
