import java.util.Scanner;

public class GreatestOfTwo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1, num2;
        System.out.print("Enter the first number: ");
        num1 = input.nextInt();
        System.out.print("Enter the second number: ");
        num2 = input.nextInt();

        if (num1 > num2) {
            System.out.println("The greatest number is: " + num1);
        } else {
            System.out.println("The greatest number is: " + num2);
        }
        input.close();
    }
}