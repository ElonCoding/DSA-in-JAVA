import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double num1, num2, result;
        char op;

        System.out.print("Enter first number: ");
        num1 = input.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        op = input.next().charAt(0);

        System.out.print("Enter second number: ");
        num2 = input.nextDouble();

        switch(op) {
            case '+':
                result = num1 + num2;
                System.out.printf("Result: %.2f\n", result);
                break;
            case '-':
                result = num1 - num2;
                System.out.printf("Result: %.2f\n", result);
                break;
            case '*':
                result = num1 * num2;
                System.out.printf("Result: %.2f\n", result);
                break;
            case '/':
                if(num2 != 0)
                    result = num1 / num2;
                else {
                    System.out.println("Error: Division by zero!");
                    input.close();
                    return;
                }
                System.out.printf("Result: %.2f\n", result);
                break;
            default:
                System.out.println("Invalid operator!");
        }

        input.close();
    }
}