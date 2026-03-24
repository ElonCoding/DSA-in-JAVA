import java.util.HashSet;
import java.util.Set;

// Q1: Basic Interface Implementation
interface WordValidator {
    boolean validate(String word);
}

// Fixed version of Q1 - implements the interface method
class BasicWordValidator implements WordValidator {
    @Override
    public boolean validate(String word) {
        return word != null && word.length() >= 3;
    }
}

// Q2: Interface Variable (public static final)
interface DictionaryConstants {
    String DEFAULT_DICTIONARY = "Bhopal"; // implicitly public static final
    int MIN_WORD_LENGTH = 3;
}

// Q3: Two Interfaces with Same Abstract Method
interface SpellChecker {
    void checkWord(String word);
}

interface WordProcessor {
    void checkWord(String word);
}

class MultiPurposeChecker implements SpellChecker, WordProcessor {
    @Override
    public void checkWord(String word) {
        System.out.println("Checking word: " + word);
    }
}

// Q4: Two Interfaces with Same Default Method
interface EnglishValidator {
    default void validate() {
        System.out.println("English validation");
    }
}

interface SpanishValidator {
    default void validate() {
        System.out.println("Spanish validation");
    }
}

class MultiLanguageValidator implements EnglishValidator, SpanishValidator {
    @Override
    public void validate() {
        EnglishValidator.super.validate(); // Choose A implementation
        // or SpanishValidator.super.validate(); // Choose B implementation
        // or provide completely new implementation
    }
}

// Q5: Default Method Override
interface GameInterface {
    default void play() {
        System.out.println("A play");
    }
}

class SpellbeeGame implements GameInterface {
    @Override
    public void play() {
        System.out.println("B play - Spellbee game started!");
    }
}

// Q6: Static Method in Interface
interface GameUtils {
    static void run() {
        System.out.println("A run - Game utility running");
    }
}

class GameImpl implements GameUtils {
    static void run() {
        System.out.println("B run - Game implementation running");
    }
}

// Q7: Multiple Interfaces (No Ambiguity)
interface LetterValidator {
    void validateLetters(Set<Character> letters);
}

interface WordScorer {
    int calculateScore(String word);
}

class CompleteValidator implements LetterValidator, WordScorer {
    @Override
    public void validateLetters(Set<Character> letters) {
        System.out.println("Validating letters: " + letters);
    }
    
    @Override
    public int calculateScore(String word) {
        return word.length() * 10;
    }
}

// Q8: Default + Abstract Conflict
interface DefaultChecker {
    default void show() {
        System.out.println("A");
    }
}

interface AbstractChecker {
    void show(); // abstract method
}

class ConflictResolver implements DefaultChecker, AbstractChecker {
    @Override
    public void show() {
        System.out.println("C - Resolved conflict");
    }
}

// Q9: Private Method in Interface (Java 9+)
interface AdvancedValidator {
    private void helper(String message) {
        System.out.println("Helper: " + message);
    }
    
    default void validateComplex(String word) {
        helper("Starting validation");
        System.out.println("Validating: " + word);
        helper("Validation complete");
    }
    
    private static void staticHelper() {
        System.out.println("Static helper method");
    }
    
    static void performStaticValidation() {
        staticHelper();
        System.out.println("Static validation performed");
    }
}

class AdvancedWordValidator implements AdvancedValidator {
    // Inherits validateComplex method which uses private helper
}

// Integration with Spellbee functionality
interface SpellbeeValidator {
    boolean isValidWord(String word, char centralLetter, Set<Character> allowedLetters);
    
    default void showValidationResult(String word, boolean isValid) {
        if (isValid) {
            System.out.println("✓ '" + word + "' is a valid Spellbee word!");
        } else {
            System.out.println("✗ '" + word + "' is not a valid Spellbee word.");
        }
    }
    
    static Set<String> getSampleDictionary() {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("apple");
        dictionary.add("apply");
        dictionary.add("plea");
        dictionary.add("play");
        dictionary.add("lay");
        dictionary.add("pale");
        dictionary.add("leap");
        return dictionary;
    }
}

class EnhancedSpellbeeValidator implements SpellbeeValidator {
    private Set<String> dictionary;
    
    public EnhancedSpellbeeValidator() {
        this.dictionary = SpellbeeValidator.getSampleDictionary();
    }
    
    @Override
    public boolean isValidWord(String word, char centralLetter, Set<Character> allowedLetters) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        
        String lowerWord = word.toLowerCase();
        
        // Check if word is in dictionary
        if (!dictionary.contains(lowerWord)) {
            return false;
        }
        
        // Check if word contains central letter
        if (lowerWord.indexOf(Character.toLowerCase(centralLetter)) == -1) {
            return false;
        }
        
        // Check if word only uses allowed letters
        for (char c : lowerWord.toCharArray()) {
            if (!allowedLetters.contains(c)) {
                return false;
            }
        }
        
        return true;
    }
}

public class InterfaceExamples {
    public static void main(String[] args) {
        System.out.println("=== Interface Examples Demo ===\n");
        
        // Q1: Basic Interface Implementation
        System.out.println("Q1: Basic Interface Implementation");
        WordValidator validator = new BasicWordValidator();
        System.out.println("Is 'hello' valid? " + validator.validate("hello"));
        System.out.println();
        
        // Q2: Interface Variable
        System.out.println("Q2: Interface Variable (public static final)");
        System.out.println("Default dictionary: " + DictionaryConstants.DEFAULT_DICTIONARY);
        System.out.println("Min word length: " + DictionaryConstants.MIN_WORD_LENGTH);
        // DictionaryConstants.DEFAULT_DICTIONARY = "Indore"; // This would cause compile error
        System.out.println();
        
        // Q3: Same Abstract Method
        System.out.println("Q3: Two Interfaces with Same Abstract Method");
        MultiPurposeChecker checker = new MultiPurposeChecker();
        checker.checkWord("test");
        System.out.println();
        
        // Q4: Same Default Method
        System.out.println("Q4: Two Interfaces with Same Default Method");
        MultiLanguageValidator multiValidator = new MultiLanguageValidator();
        multiValidator.validate();
        System.out.println();
        
        // Q5: Default Method Override
        System.out.println("Q5: Default Method Override");
        GameInterface game = new SpellbeeGame();
        game.play();
        System.out.println();
        
        // Q6: Static Method
        System.out.println("Q6: Static Method in Interface");
        GameUtils.run(); // Interface static method
        GameImpl.run();  // Class static method
        System.out.println();
        
        // Q7: Multiple Interfaces
        System.out.println("Q7: Multiple Interfaces (No Ambiguity)");
        CompleteValidator completeValidator = new CompleteValidator();
        Set<Character> letters = new HashSet<>();
        letters.add('a'); letters.add('p'); letters.add('l'); letters.add('e');
        completeValidator.validateLetters(letters);
        System.out.println("Score for 'apple': " + completeValidator.calculateScore("apple"));
        System.out.println();
        
        // Q8: Default + Abstract Conflict
        System.out.println("Q8: Default + Abstract Conflict Resolution");
        ConflictResolver resolver = new ConflictResolver();
        resolver.show();
        System.out.println();
        
        // Q9: Private Method in Interface
        System.out.println("Q9: Private Method in Interface (Java 9+)");
        AdvancedWordValidator advancedValidator = new AdvancedWordValidator();
        advancedValidator.validateComplex("hello");
        AdvancedValidator.performStaticValidation();
        System.out.println();
        
        // Integration with Spellbee functionality
        System.out.println("=== Spellbee Integration Demo ===");
        EnhancedSpellbeeValidator spellbeeValidator = new EnhancedSpellbeeValidator();
        
        Set<Character> allowedLetters = new HashSet<>();
        String inputLetters = "aplley";
        for (char c : inputLetters.toCharArray()) {
            allowedLetters.add(c);
        }
        char centralLetter = 'p';
        
        String[] testWords = {"apple", "apply", "plea", "play", "lay", "pale", "leap", "invalid"};
        
        for (String word : testWords) {
            boolean isValid = spellbeeValidator.isValidWord(word, centralLetter, allowedLetters);
            spellbeeValidator.showValidationResult(word, isValid);
        }
        
        System.out.println("\n=== Demo Complete ===");
    }
}