package Sem4.day3;
//how many ways are ther to climb a stair of n steps if you can climb either 1 or 2 steps at a time?
public class climb_stair {
    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0; // No ways to climb negative or zero steps
        }
        if (n == 1) {
            return 1; // Only one way to climb one step
        }
        if (n == 2) {
            return 2; // Two ways to climb two steps: (1+1) or (2)
        }
        System.out.println("Calculating ways to climb " + n + " steps...");
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
