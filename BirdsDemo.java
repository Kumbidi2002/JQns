// Abstract class Bird
abstract class Bird {
    // Abstract method fly (to be implemented by subclasses)
    public abstract void fly();

    // Abstract method makeSound (to be implemented by subclasses)
    public abstract void makeSound();
}

// Concrete subclass Eagle extending Bird
class Eagle extends Bird {
    // Implementation of fly method for Eagle
    @Override
    public void fly() {
        System.out.println("Eagle: Flying high in the sky.");
    }

    // Implementation of makeSound method for Eagle
    @Override
    public void makeSound() {
        System.out.println("Eagle: Screech! Screech!");
    }
}

// Concrete subclass Hawk extending Bird
class Hawk extends Bird {
    // Implementation of fly method for Hawk
    @Override
    public void fly() {
        System.out.println("Hawk: Soaring through the air.");
    }

    // Implementation of makeSound method for Hawk
    @Override
    public void makeSound() {
        System.out.println("Hawk: Caw! Caw!");
    }
}

// Main class to demonstrate the Bird, Eagle, and Hawk classes
public class BirdsDemo {
    public static void main(String[] args) {
        // Create instances of Eagle and Hawk
        Eagle eagle = new Eagle();
        Hawk hawk = new Hawk();

        // Demonstrate Eagle's methods
        System.out.println("=== Eagle ===");
        eagle.fly();
        eagle.makeSound();

        // Demonstrate Hawk's methods
        System.out.println("\n=== Hawk ===");
        hawk.fly();
        hawk.makeSound();
    }
}
