// Animal interface with makeSound method
interface Animal {
    void makeSound();
}

// Dog class implementing Animal interface
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

// Main class to test the implementation
public class Question3 {
    public static void main(String[] args) {
        // Using interface reference to call method from Dog
        Animal animal = new Dog();
        animal.makeSound();  // This will print "Bark"
    }
}