import java.util.HashSet;
import java.util.Set;

// Constants interface for Q2 test
interface SpellbeeConstants {
    int MIN_WORD_LENGTH = 3;
    int MAX_WORD_LENGTH = 15;
    String GAME_NAME = "Spellbee Game";
}

// Utility interface for Q6 test
interface GameUtils {
    static Set<String> loadDefaultDictionary() {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("apple");
        dictionary.add("apply");
        dictionary.add("plea");
        dictionary.add("play");
        dictionary.add("lay");
        return dictionary;
    }
    
    static char getCentralLetterFromInput(String allowedLetters) {
        return allowedLetters.length() > 0 ? allowedLetters.charAt(0) : 'a';
    }
}

/**
 * Comprehensive test class demonstrating all Q1-Q9 interface concepts
 * with practical examples using Spellbee game functionality
 */
public class InterfaceConceptsTest {
    
    public static void main(String[] args) {
        System.out.println("🧪 Interface Concepts Test Suite\n");
        
        testQ1_BasicInterfaceImplementation();
        testQ2_InterfaceVariables();
        testQ3_SameAbstractMethod();
        testQ4_SameDefaultMethod();
        testQ5_DefaultMethodOverride();
        testQ6_StaticMethods();
        testQ7_MultipleInterfaces();
        testQ8_DefaultAbstractConflict();
        testQ9_PrivateMethods();
        
        System.out.println("\n✅ All interface concepts demonstrated successfully!");
    }
    
    // Q1: Basic Interface Implementation Test
    private static void testQ1_BasicInterfaceImplementation() {
        System.out.println("📋 Q1: Basic Interface Implementation");
        System.out.println("Testing word validation...");
        
        // This demonstrates the fixed version where class B implements interface A
        WordValidator validator = new BasicWordValidator();
        String[] testWords = {"hi", "hello", "a", ""};
        
        for (String word : testWords) {
            System.out.println("  Word '" + word + "' is valid: " + validator.validate(word));
        }
        System.out.println();
    }
    
    // Q2: Interface Variables Test
    private static void testQ2_InterfaceVariables() {
        System.out.println("📋 Q2: Interface Variables (public static final)");
        System.out.println("Constants from SpellbeeConstants:");
        System.out.println("  MIN_WORD_LENGTH: " + SpellbeeConstants.MIN_WORD_LENGTH);
        System.out.println("  MAX_WORD_LENGTH: " + SpellbeeConstants.MAX_WORD_LENGTH);
        System.out.println("  GAME_NAME: " + SpellbeeConstants.GAME_NAME);
        
        // Uncommenting this would cause compile error:
        // SpellbeeConstants.MIN_WORD_LENGTH = 5;
        System.out.println("  ✓ Constants cannot be modified (final)");
        System.out.println();
    }
    
    // Q3: Same Abstract Method Test
    private static void testQ3_SameAbstractMethod() {
        System.out.println("📋 Q3: Same Abstract Method in Multiple Interfaces");
        System.out.println("Testing multiple inheritance safety...");
        
        MultiPurposeChecker checker = new MultiPurposeChecker();
        checker.checkWord("spellbee");
        System.out.println("  ✓ Single implementation satisfies both interfaces");
        System.out.println();
    }
    
    // Q4: Same Default Method Test
    private static void testQ4_SameDefaultMethod() {
        System.out.println("📋 Q4: Same Default Method in Multiple Interfaces");
        System.out.println("Testing conflict resolution...");
        
        MultiLanguageValidator validator = new MultiLanguageValidator();
        validator.validate(); // Calls the resolved implementation
        System.out.println("  ✓ Conflict resolved by overriding in implementing class");
        System.out.println();
    }
    
    // Q5: Default Method Override Test
    private static void testQ5_DefaultMethodOverride() {
        System.out.println("📋 Q5: Default Method Override");
        System.out.println("Testing polymorphism with interface default methods...");
        
        GameInterface basicGame = new GameInterface() {}; // Anonymous class using default
        GameInterface spellbeeGame = new SpellbeeGame(); // Class that overrides default
        
        System.out.print("  Basic game: ");
        basicGame.startGame();
        
        System.out.print("  Spellbee game: ");
        spellbeeGame.startGame();
        System.out.println("  ✓ Overridden method in class takes precedence");
        System.out.println();
    }
    
    // Q6: Static Methods Test
    private static void testQ6_StaticMethods() {
        System.out.println("📋 Q6: Static Methods in Interfaces");
        System.out.println("Testing interface static methods...");
        
        // Interface static method
        System.out.println("  Loading default dictionary via interface static method:");
        Set<String> dictionary = GameUtils.loadDefaultDictionary();
        System.out.println("  Dictionary size: " + dictionary.size());
        String allWords = String.join(", ", dictionary);
        System.out.println("  Sample words: " + (allWords.length() > 30 ? allWords.substring(0, 30) + "..." : allWords));
        
        // Static method from implementing class (not inheritance)
        System.out.println("  ✓ Static methods are not inherited, must use interface/class name");
        System.out.println();
    }
    
    // Q7: Multiple Interfaces Test
    private static void testQ7_MultipleInterfaces() {
        System.out.println("📋 Q7: Multiple Interfaces (No Ambiguity)");
        System.out.println("Testing multiple interface implementation...");
        
        CompleteValidator validator = new CompleteValidator();
        Set<Character> letters = new HashSet<>();
        letters.add('a'); letters.add('p'); letters.add('l'); letters.add('e');
        
        validator.validateLetters(letters);
        int score = validator.calculateScore("apple");
        System.out.println("  Score for 'apple': " + score);
        System.out.println("  ✓ Multiple interfaces with different methods work fine");
        System.out.println();
    }
    
    // Q8: Default + Abstract Conflict Test
    private static void testQ8_DefaultAbstractConflict() {
        System.out.println("📋 Q8: Default + Abstract Method Conflict");
        System.out.println("Testing conflict between default and abstract methods...");
        
        ConflictResolver resolver = new ConflictResolver();
        resolver.show(); // Must be implemented by class
        System.out.println("  ✓ Class must implement abstract method even if default exists");
        System.out.println();
    }
    
    // Q9: Private Methods Test
    private static void testQ9_PrivateMethods() {
        System.out.println("📋 Q9: Private Methods in Interface (Java 9+)");
        System.out.println("Testing private helper methods...");
        
        AdvancedWordValidator validator = new AdvancedWordValidator();
        validator.validateComplex("spellbee");
        
        System.out.println("  Testing static private helper:");
        AdvancedValidator.performStaticValidation();
        System.out.println("  ✓ Private methods help organize interface code");
        System.out.println();
    }
}

// Supporting classes for tests

// Q1: Basic interface and implementation
interface WordValidator {
    boolean validate(String word);
}

class BasicWordValidator implements WordValidator {
    @Override
    public boolean validate(String word) {
        return word != null && word.length() >= 3;
    }
}

// Q2: Constants interface (already defined in EnhancedSpellbeeChecker)

// Q3: Multiple interfaces with same method
interface SpellChecker {
    void checkWord(String word);
}

interface WordProcessor {
    void checkWord(String word);
}

class MultiPurposeChecker implements SpellChecker, WordProcessor {
    @Override
    public void checkWord(String word) {
        System.out.println("  Checking word: " + word);
    }
}

// Q4: Interfaces with conflicting default methods
interface EnglishValidator {
    default void validate() {
        System.out.println("  English validation rules");
    }
}

interface SpanishValidator {
    default void validate() {
        System.out.println("  Spanish validation rules");
    }
}

class MultiLanguageValidator implements EnglishValidator, SpanishValidator {
    @Override
    public void validate() {
        System.out.println("  Resolving conflict - using English rules:");
        EnglishValidator.super.validate();
    }
}

// Q5: Game interface with default methods
interface GameInterface {
    default void startGame() {
        System.out.println("  Starting game with basic rules");
    }
}

class SpellbeeGame implements GameInterface {
    @Override
    public void startGame() {
        System.out.println("  Starting Spellbee game with special rules!");
    }
}

// Q6: Utility interface with static methods (already defined)

// Q7: Multiple interfaces with different methods
interface LetterValidator {
    void validateLetters(Set<Character> letters);
}

interface ScoreCalculator {
    int calculateScore(String word);
}

class CompleteValidator implements LetterValidator, ScoreCalculator {
    @Override
    public void validateLetters(Set<Character> letters) {
        System.out.println("  Validating letters: " + letters);
    }
    
    @Override
    public int calculateScore(String word) {
        return word.length() * 10;
    }
}

// Q8: Interface with conflicting default and abstract methods
interface DefaultChecker {
    default void show() {
        System.out.println("Default implementation");
    }
}

interface AbstractChecker {
    void show(); // abstract method
}

class ConflictResolver implements DefaultChecker, AbstractChecker {
    @Override
    public void show() {
        System.out.println("  Class must implement this method");
    }
}

// Q9: Interface with private methods
interface AdvancedValidator {
    private void helper(String message) {
        System.out.println("  Private helper: " + message);
    }
    
    default void validateComplex(String word) {
        helper("Starting complex validation");
        System.out.println("  Validating complex word: " + word);
        helper("Complex validation complete");
    }
    
    private static void staticHelper() {
        System.out.println("  Private static helper method");
    }
    
    static void performStaticValidation() {
        staticHelper();
        System.out.println("  Performing static validation");
    }
}

class AdvancedWordValidator implements AdvancedValidator {
    // Inherits validateComplex method which uses private helper
}