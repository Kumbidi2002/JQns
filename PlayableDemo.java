// Interface Playable with a method play()
interface Playable {
    void play();
}

// Class Football implementing Playable interface
class Football implements Playable {
    @Override
    public void play() {
        System.out.println("Playing football: Kick the ball into the goal.");
    }
}

// Class Volleyball implementing Playable interface
class Volleyball implements Playable {
    @Override
    public void play() {
        System.out.println("Playing volleyball: Hit the ball over the net.");
    }
}

// Class Basketball implementing Playable interface
class Basketball implements Playable {
    @Override
    public void play() {
        System.out.println("Playing basketball: Shoot the ball into the hoop.");
    }
}

// Main class to demonstrate the Playable interface and its implementations
public class PlayableDemo {
    public static void main(String[] args) {
        // Create instances of Football, Volleyball, and Basketball
        Playable football = new Football();
        Playable volleyball = new Volleyball();
        Playable basketball = new Basketball();

        // Demonstrate the play method for each instance
        System.out.println("=== Football ===");
        football.play();

        System.out.println("\n=== Volleyball ===");
        volleyball.play();

        System.out.println("\n=== Basketball ===");
        basketball.play();
    }
}
