import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SpellbeeChecker {
    // Hardcoded dictionary for initial use
    private static final Set<String> DICTIONARY = new HashSet<>();

    // Load hardcoded valid words into dictionary (extendable for file loading later)
    private static void loadDictionary() {
        DICTIONARY.add("apple");
        DICTIONARY.add("apply");
        DICTIONARY.add("plea");
        DICTIONARY.add("play");
        DICTIONARY.add("lay");
    }

    // Initialize dictionary on class load
    static {
        loadDictionary();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Spellbee Checker!");

        // Get allowed letters from user
        System.out.print("Enter the 6 allowed letters (e.g., aplley): ");
        String allowedLettersInput = scanner.nextLine().toLowerCase();
        Set<Character> allowedLetters = new HashSet<>();
        for (char c : allowedLettersInput.toCharArray()) {
            allowedLetters.add(c);
        }

        // Get central letter from user
        System.out.print("Enter the central letter: ");
        char centralLetter = scanner.nextLine().toLowerCase().charAt(0);

        System.out.println("Enter words to check (type 'quit' to exit):");

        while (true) {
            System.out.print("Word: ");
            String word = scanner.nextLine();

            if (word.equalsIgnoreCase("quit")) {
                break;
            }

            if (isValidWord(word, centralLetter, allowedLetters)) {
                System.out.println("\"" + word + "\" is a valid Spellbee word!");
            } else {
                System.out.println("\"" + word + "\" is not a valid Spellbee word.");
            }
        }

        scanner.close();
        System.out.println("Thank you for playing!");
    }

    // Checks if a word is valid based on Spellbee rules
    private static boolean isValidWord(String word, char centralLetter, Set<Character> allowedLetters) {
        // 1. Word must be in the dictionary
        if (!DICTIONARY.contains(word.toLowerCase())) {
            return false;
        }

        // 2. Word must contain the central letter
        if (word.toLowerCase().indexOf(Character.toLowerCase(centralLetter)) == -1) {
            return false;
        }

        // 3. Word must only use allowed letters
        for (char c : word.toLowerCase().toCharArray()) {
            if (!allowedLetters.contains(c)) {
                return false;
            }
        }

        return true;
    }
}