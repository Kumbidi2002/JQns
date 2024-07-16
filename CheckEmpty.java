import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileExample {

    public static void main(String[] args) {
        String filename = "C:\\Users\\arya2\\Desktop\\RGNIYD\\algorithm.txt";

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            if (!scanner.hasNextLine()) {
                throw new Exception("Empty file");
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Not Empty:"+line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}