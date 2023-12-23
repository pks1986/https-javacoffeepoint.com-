package com.src.practice;

import java.util.HashMap;
import java.util.Map;

/* Time Complexity:

The program iterates through each entry in the input array exactly once.
Inside the loop, it performs operations like finding the index of the space character, substring extraction, and HashMap operations.
The operations inside the loop take constant time for each entry.
Therefore, the overall time complexity is O(n), where n is the length of the input array.

Space Complexity:

The space complexity is determined by the space used for the ipCount HashMap.
In the worst case, where all IP addresses are distinct, the HashMap could contain n entries (n being the number of entries in the input array).
Thus, the space complexity is O(n).
In summary:

Time Complexity: O(n)
Space Complexity: O(n) */

public class IpUsage {
    public static void main(String[] args) {
        String[] input = {
                "10.0.0.1 flipkart",
                "10.0.0.2 Google",
                "10.0.0.1 amazon"
        };

        // Find the most used IP
        String mostUsedIp = findMostUsedIp(input);

        System.out.println("Most Used IP: " + mostUsedIp);
    }

    private static String findMostUsedIp(String[] input) {
        Map<String, Integer> ipCount = new HashMap<>();

        String mostUsedIp = null;
        int maxCount = 0;

        for (String entry : input) {
            int index = entry.indexOf(' ');
            if (index != -1) {
                String ip = entry.substring(0, index);
                ipCount.put(ip, ipCount.getOrDefault(ip, 0) + 1);

                if (ipCount.get(ip) > maxCount) {
                    mostUsedIp = ip;
                    maxCount = ipCount.get(ip);
                }
            }
        }

        return mostUsedIp;
    }
}
