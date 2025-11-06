package lect4;

import java.util.Scanner;

public class VowelChecker {

    public static boolean containsVowel(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        String lowerCaseStr = str.toLowerCase();
        for (int i = 0; i < lowerCaseStr.length(); i++) {
            char ch = lowerCaseStr.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check for vowels: ");
        String input = scanner.nextLine();

        if (containsVowel(input)) {
            System.out.println("\"" + input + "\" contains at least one vowel.");
        } else {
            System.out.println("\"" + input + "\" does not contain any vowels.");
        }

        scanner.close();
    }
}