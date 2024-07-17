import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckFileEmpty {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\arya2\\Desktop\\RGNIYD\\hi.txt";  // Corrected file path

        try {
            checkFileNotEmpty(fileName);
            System.out.println("File is not empty. Proceed with further processing.");
        } catch (FileEmptyException e) {
            System.err.println("Exception caught: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException caught: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void checkFileNotEmpty(String fileName) throws FileNotFoundException, IOException, FileEmptyException {
        // Open the file for reading using BufferedReader
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        
        // Read the first character to check if the file is empty
        int character = reader.read();
        reader.close();

        // Throw exception if the file is empty
        if (character == -1) {
            throw new FileEmptyException("File is empty: " + fileName);
        }
    }

    // Custom exception class for file empty condition
    static class FileEmptyException extends Exception {
        public FileEmptyException(String message) {
            super(message);
        }
    }
}
