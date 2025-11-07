import java.util.Scanner;

public class CharToAscii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = scanner.nextLine().charAt(0);
        int ascii = (int) ch;
        System.out.println("ASCII value of '" + ch + "' is: " + ascii);
    }
}
