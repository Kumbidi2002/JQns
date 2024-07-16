import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Custom exception class for positive number condition
class PositiveNumberException extends Exception {
    public PositiveNumberException(String message) {
        super(message);
    }
}

public class PositiveNumberCheck {

    // Method to read numbers from a file and throw an exception if any number is positive
    public static void checkNumbers(String filePath) throws FileNotFoundException, PositiveNumberException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number > 0) {
                    scanner.close();
                    throw new PositiveNumberException("Found a positive number: " + number);
                }
            } else {
                // Skip non-integer tokens
                scanner.next();
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        // Define the path to the file
        String filePath = "C:\\Users\\arya2\\Desktop\\RGNIYD\\algorithm.txt"; // Change this to your file path

        try {
            // Call the method to check numbers in the file
            checkNumbers(filePath);
            System.out.println("No positive numbers found in the file.");
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException caught: " + e.getMessage());
        } catch (PositiveNumberException e) {
            System.err.println("PositiveNumberException caught: " + e.getMessage());
        }
    }
}
