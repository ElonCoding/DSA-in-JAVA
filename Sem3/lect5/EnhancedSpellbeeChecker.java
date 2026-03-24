import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Interface demonstrating Q1-Q9 concepts applied to Spellbee functionality
interface SpellbeeConstants {
    // Q2: Interface variables are public static final
    int MIN_WORD_LENGTH = 3;
    int MAX_WORD_LENGTH = 15;
    String GAME_NAME = "Spellbee Game";
}

// Q3 & Q7: Multiple interfaces with different purposes
interface WordValidator {
    boolean validate(String word, char centralLetter, Set<Character> allowedLetters);
}

interface ScoreCalculator {
    int calculateScore(String word);
}

interface GameStats {
    void showStats();
}

// Q4 & Q8: Interface with default methods that might conflict
interface BasicGameRules {
    default boolean isValidLength(String word) {
        return word.length() >= SpellbeeConstants.MIN_WORD_LENGTH && 
               word.length() <= SpellbeeConstants.MAX_WORD_LENGTH;
    }
    
    default void showGameInfo() {
        System.out.println("Playing " + SpellbeeConstants.GAME_NAME);
    }
}

interface AdvancedGameRules {
    default boolean isValidLength(String word) {
        return word.length() >= 4; // Different minimum length
    }
    
    default void showGameInfo() {
        System.out.println("Advanced game mode");
    }
}

// Q5: Default method override demonstration
interface GameInterface {
    default void startGame() {
        System.out.println("Game started with basic rules");
    }
    
    default void endGame() {
        System.out.println("Game ended");
    }
}

// Q6: Static methods in interface
interface GameUtils {
    static Set<String> loadDefaultDictionary() {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("apple");
        dictionary.add("apply");
        dictionary.add("plea");
        dictionary.add("play");
        dictionary.add("lay");
        dictionary.add("pale");
        dictionary.add("leap");
        dictionary.add("peal");
        dictionary.add("yelp");
        dictionary.add("palely");
        return dictionary;
    }
    
    static char getCentralLetterFromInput(String allowedLetters) {
        return allowedLetters.length() > 0 ? allowedLetters.charAt(0) : 'a';
    }
}

// Q9: Private methods in interface (Java 9+)
interface ValidationHelper {
    default boolean containsOnlyLetters(String word) {
        return word.matches("[a-zA-Z]+");
    }
    
    default boolean hasValidCharacters(String word, Set<Character> allowedLetters) {
        for (char c : word.toLowerCase().toCharArray()) {
            if (!allowedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }
    
    default boolean performBasicValidation(String word, Set<Character> allowedLetters) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        
        if (!containsOnlyLetters(word)) {
            return false;
        }
        
        return hasValidCharacters(word, allowedLetters);
    }
}

// Main implementation class demonstrating all interface concepts
class EnhancedSpellbeeGame implements 
    WordValidator, ScoreCalculator, GameStats, 
    BasicGameRules, AdvancedGameRules, GameInterface, ValidationHelper {
    
    private Set<String> dictionary;
    private Set<String> foundWords;
    private int totalScore;
    private char centralLetter;
    private Set<Character> allowedLetters;
    
    public EnhancedSpellbeeGame() {
        this.dictionary = GameUtils.loadDefaultDictionary();
        this.foundWords = new HashSet<>();
        this.totalScore = 0;
    }
    
    // Q4 & Q8: Resolving default method conflicts
    @Override
    public boolean isValidLength(String word) {
        // Resolving conflict between BasicGameRules and AdvancedGameRules
        return BasicGameRules.super.isValidLength(word); // Choose basic rules
    }
    
    @Override
    public void showGameInfo() {
        // Resolving conflict between interfaces
        BasicGameRules.super.showGameInfo();
        System.out.println("Using enhanced validation rules");
    }
    
    // Q5: Override default methods from GameInterface
    @Override
    public void startGame() {
        System.out.println("🐝 Welcome to Enhanced Spellbee Game! 🐝");
        showGameInfo();
    }
    
    @Override
    public void endGame() {
        System.out.println("\n🏁 Game Over! 🏁");
        showStats();
        GameInterface.super.endGame();
    }
    
    // Implementation of WordValidator (Q1, Q3, Q7)
    @Override
    public boolean validate(String word, char centralLetter, Set<Character> allowedLetters) {
        this.centralLetter = centralLetter;
        this.allowedLetters = allowedLetters;
        
        String lowerWord = word.toLowerCase();
        
        // Use private method from ValidationHelper (Q9)
        if (!performBasicValidation(word, allowedLetters)) {
            return false;
        }
        
        // Check length using resolved default method
        if (!isValidLength(word)) {
            return false;
        }
        
        // Check if word is in dictionary
        if (!dictionary.contains(lowerWord)) {
            return false;
        }
        
        // Check if word contains central letter
        if (lowerWord.indexOf(Character.toLowerCase(centralLetter)) == -1) {
            return false;
        }
        
        return true;
    }
    
    // Implementation of ScoreCalculator (Q7)
    @Override
    public int calculateScore(String word) {
        int baseScore = word.length() * 10;
        
        // Bonus for using all letters
        Set<Character> wordLetters = new HashSet<>();
        for (char c : word.toLowerCase().toCharArray()) {
            wordLetters.add(c);
        }
        
        if (wordLetters.containsAll(allowedLetters)) {
            baseScore += 50; // Pangram bonus
        }
        
        // Bonus for using central letter multiple times
        long centralLetterCount = word.toLowerCase().chars()
            .filter(c -> c == Character.toLowerCase(centralLetter))
            .count();
        
        if (centralLetterCount > 1) {
            baseScore += (centralLetterCount - 1) * 5;
        }
        
        return baseScore;
    }
    
    // Implementation of GameStats (Q7)
    @Override
    public void showStats() {
        System.out.println("\n📊 Game Statistics:");
        System.out.println("Words found: " + foundWords.size());
        System.out.println("Total score: " + totalScore);
        System.out.println("Average score per word: " + 
            (foundWords.isEmpty() ? 0 : totalScore / foundWords.size()));
        
        if (!foundWords.isEmpty()) {
            System.out.println("Words found: " + String.join(", ", foundWords));
        }
    }
    
    public void processWord(String word) {
        if (validate(word, centralLetter, allowedLetters)) {
            if (!foundWords.contains(word.toLowerCase())) {
                foundWords.add(word.toLowerCase());
                int score = calculateScore(word);
                totalScore += score;
                System.out.println("✅ '" + word + "' is valid! Score: +" + score);
            } else {
                System.out.println("⚠️  Word already found!");
            }
        } else {
            System.out.println("❌ '" + word + "' is not valid");
        }
    }
    
    public Set<String> getFoundWords() {
        return new HashSet<>(foundWords);
    }
    
    public int getTotalScore() {
        return totalScore;
    }
}

public class EnhancedSpellbeeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnhancedSpellbeeGame game = new EnhancedSpellbeeGame();
        
        System.out.println("=== Enhanced Spellbee Checker with Interface Concepts ===\n");
        
        // Start game using interface default method (Q5)
        game.startGame();
        
        // Get allowed letters from user
        System.out.print("Enter the 6-7 allowed letters (e.g., aplley): ");
        String allowedLettersInput = scanner.nextLine().toLowerCase();
        
        if (allowedLettersInput.isEmpty() || allowedLettersInput.length() < 6) {
            System.out.println("Using default letters: aplley");
            allowedLettersInput = "aplley";
        }
        
        Set<Character> allowedLetters = new HashSet<>();
        for (char c : allowedLettersInput.toCharArray()) {
            allowedLetters.add(c);
        }
        
        // Get central letter from user
        System.out.print("Enter the central letter: ");
        String centralLetterInput = scanner.nextLine();
        char centralLetter = centralLetterInput.isEmpty() ? 
            GameUtils.getCentralLetterFromInput(allowedLettersInput) : 
            centralLetterInput.toLowerCase().charAt(0);
        
        System.out.println("\n🎯 Game Rules:");
        System.out.println("- Words must contain the central letter: '" + centralLetter + "'");
        System.out.println("- Words can only use these letters: " + allowedLetters);
        System.out.println("- Minimum word length: " + SpellbeeConstants.MIN_WORD_LENGTH);
        System.out.println("- Type 'quit' to exit, 'stats' to see statistics");
        System.out.println("- Type 'hint' to see available words starting with a letter");
        
        // Game loop
        while (true) {
            System.out.print("\nEnter word: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            
            if (input.equalsIgnoreCase("stats")) {
                game.showStats();
                continue;
            }
            
            if (input.equalsIgnoreCase("hint")) {
                System.out.print("Show words starting with letter: ");
                String hintLetter = scanner.nextLine().toLowerCase();
                showHint(game, hintLetter, centralLetter, allowedLetters);
                continue;
            }
            
            if (!input.isEmpty()) {
                game.processWord(input);
            }
        }
        
        // End game using interface method (Q5)
        game.endGame();
        scanner.close();
    }
    
    private static void showHint(EnhancedSpellbeeGame game, String hintLetter, char centralLetter, Set<Character> allowedLetters) {
        if (hintLetter.isEmpty() || hintLetter.length() != 1) {
            System.out.println("Please enter a single letter");
            return;
        }
        
        char hintChar = hintLetter.charAt(0);
        Set<String> dictionary = GameUtils.loadDefaultDictionary();
        Set<String> hintWords = new HashSet<>();
        
        for (String word : dictionary) {
            if (word.startsWith(String.valueOf(hintChar)) && 
                game.validate(word, centralLetter, allowedLetters)) {
                hintWords.add(word);
            }
        }
        
        if (hintWords.isEmpty()) {
            System.out.println("No valid words found starting with '" + hintChar + "'");
        } else {
            System.out.println("Valid words starting with '" + hintChar + "': " + 
                String.join(", ", hintWords));
        }
    }
}