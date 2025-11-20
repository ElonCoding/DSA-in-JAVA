// Vehicle interface with default start method
interface Vehicle {
    default void start() {
        System.out.println("Vehicle is starting...");
    }
}

// Car class implementing Vehicle interface
class Car implements Vehicle {
    // Car can use the default start method or override it
}

// Main class to test the implementation
public class Question5 {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();  // Calling the default method from Vehicle interface
    }
}