import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        input.close();

        System.out.print("Multiplication table of " + number + ": ");
        for (int i = 1; i <= 10; i++) {
            System.out.print((number * i) + " ");
        }
        System.out.println();
    }
}