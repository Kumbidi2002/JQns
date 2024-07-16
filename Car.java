import java.util.Scanner;
public class Car {
    private String make;
    private String model;
    private int year;
    private boolean isRunning;

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.isRunning = false; // Car is initially off
    }

    // Method to start the car
    public void startCar() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("The car has started.");
        } else {
            System.out.println("The car is already running.");
        }
    }

    // Method to stop the car
    public void stopCar() {
        if (isRunning) {
            isRunning = false;
            System.out.println("The car has stopped.");
        } else {
            System.out.println("The car is already off.");
        }
    }

    // Method to display car information
    public void displayCarInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Status: " + (isRunning ? "Running" : "Off"));
    }

    // Main method to test the Car class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter car make: ");
        String make = scanner.nextLine();

        System.out.print("Enter car model: ");
        String model = scanner.nextLine();

        System.out.print("Enter car year: ");
        int year = scanner.nextInt();

        Car car = new Car(make, model, year);
        car.displayCarInfo();

        System.out.println("\nStarting the car...");
        car.startCar();
        car.displayCarInfo();

        System.out.println("\nStopping the car...");
        car.stopCar();
        car.displayCarInfo();

        scanner.close();
    }
}
