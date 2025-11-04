import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int n1 = 0, n2 = 1, nextTerm, i, n;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        n = input.nextInt();
        System.out.println("Fibonacci Series: ");
        for (i = 1; i <= n; ++i) {
            System.out.println(n1);
            nextTerm = n1 + n2;
            n1 = n2;
            n2 = nextTerm;
        }
        input.close();
    }
}