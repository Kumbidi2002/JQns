import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FileNotfound {

	    // Method to read the contents of a file and throw an exception if the file is not found
	    public static void readFile(String filePath) throws FileNotFoundException {
	        File file = new File(filePath);
	        Scanner scanner = new Scanner(file);

	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            System.out.println(line);
	        }

	        scanner.close();
	    }

	    public static void main(String[] args) {
	        // Define the path to the file
	        String filePath = "C:\\Users\\arya2\\Desktop\\RGNIYD\\algorithm.txt"; // Change this to your file path

	        try {
	            // Call the method to read the file
	            readFile(filePath);
	        } catch (FileNotFoundException e) {
	            System.err.println("FileNotFoundException caught: " + e.getMessage());
	        }
	    }
	}


