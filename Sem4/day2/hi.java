package Sem4.day2;
public class hi {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = new String("Hi");
        System.out.println(str1);
        System.out.println(str2);
    System.out.println(str1.length());
    System.out.println(str2.length());
    System.out.println(str1.charAt(0));
    System.out.println(str1 + " " + str2);
    System.out.println(str1.charAt(2));
    String rev = "";
    for (int i = str1.length() - 1; i >= 0; i--) {
        rev += str1.charAt(i);
    }
    System.out.println(rev);
}}