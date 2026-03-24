// Interface for walking capability
interface Walkable {
    void walk();
}

// Interface for running capability
interface Runnable {
    void run();
}

// Human class implementing both interfaces
class Human implements Walkable, Runnable {
    @Override
    public void walk() {
        System.out.println("Human is walking");
    }
    
    @Override
    public void run() {
        System.out.println("Human is running");
    }
}

// Main class to test the implementation
public class Question1 {
    public static void main(String[] args) {
        Human human = new Human();
        human.walk();  // Calling walk method
        human.run();   // Calling run method
    }
}