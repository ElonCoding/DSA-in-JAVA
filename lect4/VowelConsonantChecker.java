package lect4;
import java.util.Scanner;
public class VowelConsonantChecker {
    public static int countVowels(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int vowelCount = 0;
        String lowerCaseStr = str.toLowerCase();
        for (int i = 0; i < lowerCaseStr.length(); i++) {
            char ch = lowerCaseStr.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }
        return vowelCount;
    }

    public static int countConsonants(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int consonantCount = 0;
        String lowerCaseStr = str.toLowerCase();
        for (int i = 0; i < lowerCaseStr.length(); i++) {
            char ch = lowerCaseStr.charAt(i);
            if (ch >= 'a' && ch <= 'z' &&
                !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) {
                consonantCount++;
            }
        }
        return consonantCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to count vowels and consonants: ");
        String input = scanner.nextLine();

        int vowelCount = countVowels(input);
        int consonantCount = countConsonants(input);

        System.out.println("\"" + input + "\" contains " + vowelCount + " vowel(s).");
        System.out.println("\"" + input + "\" contains " + consonantCount + " consonant(s).");

        scanner.close();
    }
}