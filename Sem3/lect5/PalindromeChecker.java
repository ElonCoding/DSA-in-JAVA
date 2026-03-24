package lect5;
public class PalindromeChecker {
    public static void main(String[] args) {
        String str = "racecar";
        StringBuilder rev = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            rev.append(str.charAt(i));
        }
        System.out.println(str.equals(rev.toString())); // Output: true
    }
}