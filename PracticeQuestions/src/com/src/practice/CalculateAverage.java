package com.src.practice;

import java.util.HashMap;
import java.util.Map;

/* Time Complexity:

The program iterates through each entry in the scores array exactly once.
Inside the loop, it performs operations like parsing integers, HashMap operations, and array operations, all of which take constant time for each entry.
The second loop iterates through the entries in the studentData HashMap, which contains at most the number of unique students. The number of unique students is bounded by the number of entries in the scores array.
Therefore, the overall time complexity is O(n), where n is the total number of entries in the scores array.

Space Complexity:

The space complexity is determined by the space used for the studentData HashMap.
In the worst case, where all students are distinct, the HashMap could contain n entries (n being the number of entries in the scores array).
The averages array has space complexity O(n) as well, where n is the number of entries in the scores array.
In summary:

Time Complexity: O(n)
Space Complexity: O(n) */

public class CalculateAverage {
    public static void main(String[] args) {
        String[][] scores = {{"Bob", "85"}, {"Mark", "100"}, {"Charles", "63"}, {"Mark", "34"}};

        // Calculate the average scores of each student
        double[] averages = calculateAverages(scores);

        // Find the best average
        double bestAverage = findBestAverage(averages);

        System.out.println("Average scores of students:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i][0] + ": " + averages[i]);
        }

        System.out.println("\nBest Average: " + bestAverage);
    }

    private static double[] calculateAverages(String[][] scores) {
        Map<String, int[]> studentData = new HashMap<>();

        // Calculate sum and count for each student
        for (String[] score : scores) {
            String student = score[0];
            int value = Integer.parseInt(score[1]);

            studentData.putIfAbsent(student, new int[]{0, 0});
            int[] data = studentData.get(student);
            data[0] += value;  // sum
            data[1] += 1;      // count
        }

        // Calculate average for each student
        double[] averages = new double[scores.length];
        int i = 0;
        for (Map.Entry<String, int[]> entry : studentData.entrySet()) {
            int sum = entry.getValue()[0];
            int count = entry.getValue()[1];
            averages[i++] = (double) sum / count;
        }

        return averages;
    }

    private static double findBestAverage(double[] averages) {
        double bestAverage = Double.MIN_VALUE;

        // Find the overall best average
        for (double average : averages) {
            if (average > bestAverage) {
                bestAverage = average;
            }
        }

        return bestAverage;
    }
}