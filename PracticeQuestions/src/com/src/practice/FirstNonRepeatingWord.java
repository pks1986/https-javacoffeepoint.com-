package com.src.practice;

import java.util.HashMap;
import java.util.Map;

//The time complexity is O(n), where n is the length of the input string, 
//the space complexity is O(k), where k is the number of distinct words.

public class FirstNonRepeatingWord {
    public static void main(String[] args) {
        String input = "My Wife is my love";

        // Find the first non-repeating word
        String firstNonRepeatingWord = findFirstNonRepeatingWord(input);

        System.out.println("First Non-Repeating Word: " + firstNonRepeatingWord);
    }

    private static String findFirstNonRepeatingWord(String input) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Split the input string into words
        String[] words = input.split("\\s+");

        // Count occurrences of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Find the first non-repeating word
        for (String word : words) {
            if (wordCount.get(word) == 1) {
                return word;
            }
        }

        // Return a default value if no non-repeating word is found
        return "";
    }
}

