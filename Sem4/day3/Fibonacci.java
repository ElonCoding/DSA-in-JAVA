package Sem4.day3;

public class Fibonacci {
    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int n = 10;

    public static void main(String[] args) {
        System.out.println(fib(n));
    }
}
