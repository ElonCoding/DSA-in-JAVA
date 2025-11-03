import java.util.Scanner;

public class CompareNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1, num2;

        System.out.print("Enter first number: ");
        num1 = input.nextInt();

        System.out.print("Enter second number: ");
        num2 = input.nextInt();

        if (num1 > num2) {
            System.out.println(num1 + " is larger.");
        } else if (num2 > num1) {
            System.out.println(num2 + " is larger.");
        } else {
            System.out.println("Both numbers are equal.");
        }

        input.close();
    }
}