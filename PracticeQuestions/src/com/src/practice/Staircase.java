package com.src.practice;

//StairClimber.java

public class Staircase {

    public static int countWays(int n) {
        // Base cases
        if (n <= 1) {
            return 1;
        }

        // Initializing an array to store the number of ways to reach each stair
        int[] ways = new int[n + 1];

        // There is one way to reach the first stair
        ways[0] = 1;
        ways[1] = 1;

        // Calculating the number of ways for each stair
        for (int i = 2; i <= n; ++i) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n];
    }

    public static void main(String[] args) {
        // Example usage
        int n1 = 5;
        System.out.println("Ways to reach " + n1 + " stairs: " + countWays(n1));

        int n2 = 2;
        System.out.println("Ways to reach " + n2 + " stairs: " + countWays(n2));
    }
}
