import java.util.Scanner;

public class ifelse {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Marks: ");
        int num1 = input.nextInt();
        if (num1 > 90) {
            System.out.println("Very Good");
        } else if (num1 > 80) {
            System.out.println("Good");
        } else if (num1 > 70) {
            System.out.println("Average");
        } else if (num1 > 60) {
            System.out.println("below Average");
        } else if (num1 > 50) {
            System.out.println("bad");
        } else if (num1 > 40) {
            System.out.println("Fail");
        } else if (num1 > 30) {
            System.out.println("You are out of the exam");
        } else if (num1 > 20) {
            System.out.println("Restart the course");
        } else {
            System.out.println("Contact the administration");

        }
    }
}