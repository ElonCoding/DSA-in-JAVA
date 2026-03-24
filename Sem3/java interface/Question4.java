// Shape interface with area method
interface Shape {
    double area();
}

// Circle class implementing Shape interface
class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Main class to test the implementation
public class Question4 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);  // Creating circle with radius 5
        double area = circle.area();  // Calculating area
        System.out.println("Area of circle with radius 5: " + area);
    }
}