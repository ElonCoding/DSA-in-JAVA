import java.util.Scanner;

public class MultipleOf3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        input.close();

        if (number % 3 == 0) {
            System.out.println(number + " is a multiple of 3.");
        } else {
            System.out.println(number + " is not a multiple of 3.");
        }
    }
}