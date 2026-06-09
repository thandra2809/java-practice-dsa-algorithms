package org.research;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];  // created here
        return solve(n, memo);         // passed directly ✅
    }

    private static int solve(int n, int[] memo) {  // received here ✅
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memo[n] != 0) return memo[n];
        memo[n] = solve(n - 1, memo) + solve(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
//        System.out.println("n=1 : " + climbStairs(1));  // 1
//        System.out.println("n=2 : " + climbStairs(2));  // 2
//        System.out.println("n=3 : " + climbStairs(3));  // 3
//        System.out.println("n=4 : " + climbStairs(4));  // 5
        System.out.println("n=5 : " + climbStairs(5));  // 8
    }

}
