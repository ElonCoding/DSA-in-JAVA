// Interface A with display method
interface A {
    void display();
}

// Interface B with display method
interface B {
    void display();
}

// Demo class implementing both interfaces
class Demo implements A, B {
    @Override
    public void display() {
        System.out.println("Demo class implementing display method from both interfaces A and B");
    }
}

// Main class to test the implementation
public class Question2 {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.display();  // Calling display method
    }
}