import java.util.Scanner;

public class VowelConsonant {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ch;
        System.out.print("Enter a character: ");
        ch = input.next().charAt(0);

        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                System.out.println(ch + " is a vowel.");
                break;
            default:
                System.out.println(ch + " is a consonant.");
        }
        input.close();
    }
}