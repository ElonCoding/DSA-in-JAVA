package Sem4.day3;

public class subset {
     static void printSubset(String current, String str) {
        if (str.isEmpty()) {
            if (!current.isEmpty()) {
                System.out.println(current);
            }
            return;
        }
        
    char ch = str.charAt(0);
    printSubset(current + ch, str.substring(1)); // Include the current character
    printSubset(current, str.substring(1)); // Exclude the current character
    }
    public static void main(String[] args) {
        String str = "abc";
        printSubset("", str);
    }
}

