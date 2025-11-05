import java.util.Scanner;

public class PositiveNegativeZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;
        System.out.print("Enter an integer: ");
        num = input.nextInt();

        if (num > 0) {
            System.out.println("Positive");
        } else if (num < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
        input.close();
    }
}