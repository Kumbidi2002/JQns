import java.util.Scanner;

public class OddNumberExceptionExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
            checkEvenNumber(number);
            System.out.println(number + " is even. No exception thrown.");
        } catch (OddNumberException e) {
            System.err.println("OddNumberException caught: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception caught: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner to release resources
        }
    }

    public static void checkEvenNumber(int number) throws OddNumberException {
        if (number % 2 != 0) {
            throw new OddNumberException("Number is odd: " + number);
        }
    }

    // Custom exception class for odd number condition
    static class OddNumberException extends Exception {
        public OddNumberException(String message) {
            super(message);
        }
    }
}
