package Sem4.day3;

public class fibo {
static void fib(String s, int n) {
    if (n == 0) {
        System.err.println(s);
        return;
    }
    fib(s+"0", n-1);
    fib(s+"1", n-1);
}
        public static void main(String[] args) {
            int n = 3;
            fib("", n);
        }

    }

