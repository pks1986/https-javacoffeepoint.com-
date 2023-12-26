package com.src.practice;

public class OptimalPath {

    public static int findOptimalPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException("Invalid grid");
        }

        int rows = grid.length;
        int cols = grid[0].length;

        // Create a 2D DP array to store the minimum cost
        int[][] dp = new int[rows][cols];

        // Initialize the first cell
        dp[0][0] = grid[0][0];

        // Initialize the first row
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Initialize the first column
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the DP array
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // The value in the bottom-right corner represents the minimum cost
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        int optimalPathCost = findOptimalPath(grid);
        System.out.println("Optimal Path Cost: " + optimalPathCost);
    }
}
