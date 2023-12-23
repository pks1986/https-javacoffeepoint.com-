package com.src.practice;

import java.util.LinkedHashMap;
import java.util.Map;

//The time complexity is O(n), where n is the length of the input string
//The space complexity is O(k), where k is the number of distinct characters in the string.

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String input = "programming";

        // Find the first non-repeating character
        char firstNonRepeatingChar = findFirstNonRepeatingCharacter(input);

        System.out.println("First Non-Repeating Character: " + firstNonRepeatingChar);
    }

    private static char findFirstNonRepeatingCharacter(String input) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        // Count occurrences of each character
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Find the first non-repeating character
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // Return a default character if no non-repeating character is found
        return '\0';
    }
}

