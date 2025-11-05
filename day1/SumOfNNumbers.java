import java.util.Scanner;

public class SumOfNNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, sum = 0, i = 1;
        System.out.print("Enter a positive integer N: ");
        n = input.nextInt();

        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("Sum of first " + n + " natural numbers = " + sum);
        input.close();
    }
}