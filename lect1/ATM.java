import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double balance = 10000.0; // Initial balance
        int choice;
        double amount;

        while (true) {
            System.out.println("\nATM MENU");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("\nYour Current Balance: Rs. %.2f\n", balance);
                    break;
                case 2:
                    System.out.print("\nEnter amount to deposit: ");
                    amount = input.nextDouble();
                    if (amount > 0) {
                        balance += amount;
                        System.out.println("Amount Deposited Successfully!\n");
                    } else {
                        System.out.println("Invalid deposit amount!\n");
                    }
                    break;
                case 3:
                    System.out.print("\nEnter amount to withdraw: ");
                    amount = input.nextDouble();
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        System.out.println("Please collect your cash.\n");
                    } else if (amount > balance) {
                        System.out.println("Insufficient Balance!\n");
                    } else {
                        System.out.println("Invalid withdrawal amount!\n");
                    }
                    break;
                case 4:
                    System.out.println("\nThank you for using ATM. Goodbye!\n");
                    input.close();
                    return;
                default:
                    System.out.println("\nInvalid choice! Please try again.\n");
            }
        }
    }
}