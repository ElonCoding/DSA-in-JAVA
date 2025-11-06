package lect4;

public class trim {

    public static String myTrim(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        int start = 0;
        while (start < str.length() && Character.isWhitespace(str.charAt(start))) {
            start++;
        }

        int end = str.length() - 1;
        while (end >= start && Character.isWhitespace(str.charAt(end))) {
            end--;
        }

        return str.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String originalStr = "   Hello Java World   ";

        // Using built-in trim()
        String builtInTrimmedStr = originalStr.trim();
        System.out.println("Original String: '" + originalStr + "'");
        System.out.println("Built-in trim(): '" + builtInTrimmedStr + "'");
        System.out.println("Length before trim: " + originalStr.length());
        System.out.println("Length after built-in trim: " + builtInTrimmedStr.length());
        System.out.println("\n");

        // Using custom myTrim() function
        String customTrimmedStr = myTrim(originalStr);
        System.out.println("Original String: '" + originalStr + "'");
        System.out.println("Custom myTrim(): '" + customTrimmedStr + "'");
        System.out.println("Length before trim: " + originalStr.length());
        System.out.println("Length after custom trim: " + customTrimmedStr.length());
    }
}
