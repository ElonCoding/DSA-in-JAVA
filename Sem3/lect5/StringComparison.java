package lect5;
public class StringComparison {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "java";
        System.out.println(s1.equals(s2));           // false
        System.out.println(s1.equalsIgnoreCase(s2)); // true
        System.out.println(s1.compareTo(s2));        // Negative value
    }
}