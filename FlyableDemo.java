// Interface Flyable with a method fly_obj()
interface Flyable {
    void fly_obj();
}

// Class Spacecraft implementing Flyable interface
class Spacecraft implements Flyable {
    @Override
    public void fly_obj() {
        System.out.println("Spacecraft: Launching into space.");
    }
}

// Class Airplane implementing Flyable interface
class Airplane implements Flyable {
    @Override
    public void fly_obj() {
        System.out.println("Airplane: Taking off from the runway.");
    }
}

// Class Helicopter implementing Flyable interface
class Helicopter implements Flyable {
    @Override
    public void fly_obj() {
        System.out.println("Helicopter: Lifting off vertically.");
    }
}

// Main class to demonstrate the Flyable interface and its implementations
public class FlyableDemo {
    public static void main(String[] args) {
        // Create instances of Spacecraft, Airplane, and Helicopter
        Flyable spacecraft = new Spacecraft();
        Flyable airplane = new Airplane();
        Flyable helicopter = new Helicopter();

        // Demonstrate the fly_obj method for each instance
        System.out.println("=== Spacecraft ===");
        spacecraft.fly_obj();

        System.out.println("\n=== Airplane ===");
        airplane.fly_obj();

        System.out.println("\n=== Helicopter ===");
        helicopter.fly_obj();
    }
}
