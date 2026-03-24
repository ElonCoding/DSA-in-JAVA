import java.util.Scanner;

public class SumOfNNumbersWhileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer N: ");
        int N = input.nextInt();
        input.close();

        int sum = 0;
        int i = 1;

        while (i <= N) {
            sum += i;
            i++;
        }

        System.out.println("The sum of the first " + N + " natural numbers is: " + sum);
    }
}