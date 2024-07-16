import java.util.Scanner;

public class CheckVowelsExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            checkForVowels(input);
            System.out.println("String contains vowels.");
        } catch (NoVowelsException e) {
            System.err.println("NoVowelsException caught: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner to release resources
        }
    }

    public static void checkForVowels(String str) throws NoVowelsException {
        boolean foundVowel = false;

        // Check each character in the string for vowels
        for (char c : str.toCharArray()) {
            if (isVowel(c)) {
                foundVowel = true;
                break;
            }
        }

        // If no vowel found, throw custom exception
        if (!foundVowel) {
            throw new NoVowelsException("String does not contain any vowels: " + str);
        }
    }

    // Method to check if a character is a vowel
    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;  // Check if character is in the list of vowels
    }

    // Custom exception class for no vowels condition
    static class NoVowelsException extends Exception {
        public NoVowelsException(String message) {
            super(message);
        }
    }
}
