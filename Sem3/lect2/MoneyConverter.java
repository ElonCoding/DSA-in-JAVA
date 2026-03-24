import java.util.Scanner;

public class MoneyConverter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        double inr, result;
        final double USD_RATE = 0.012; // Example rate: 1 INR = 0.012 USD
        final double PAK_RATE = 3.0;   // Example rate: 1 INR = 3 PKR

        System.out.println("Money Converter");
        System.out.println("1. INR to USD");
        System.out.println("2. INR to PAK");
        System.out.print("Enter your choice (1 or 2): ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter amount in INR: ");
                inr = input.nextDouble();
                result = inr * USD_RATE;
                System.out.printf("INR %.2f = USD %.2f\n", inr, result);
                break;
            case 2:
                System.out.print("Enter amount in INR: ");
                inr = input.nextDouble();
                result = inr * PAK_RATE;
                System.out.printf("INR %.2f = PAK %.2f\n", inr, result);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        input.close();
    }
}