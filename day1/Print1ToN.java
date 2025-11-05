import java.util.Scanner;

public class Print1ToN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Enter the value of N: ");
        n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        input.close();
    }
}