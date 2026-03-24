import java.util.Scanner;

public class PasswordChecker {
    private static final String PASSWORD = "secret123";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();

        if (enteredPassword.equals(PASSWORD)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }

        input.close();
    }
}