package com.src.practice;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static Character firstUniqueCharacter(String s) {
        // Create a HashMap to store the count of each character
        Map<Character, Integer> charCount = new HashMap<>();

        // Use a single loop to populate the HashMap and find the first unique character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Use another loop to check the count and return the first unique character
        for (char c : s.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }

        // If no unique character is found, return null
        return null;
    }

    public static void main(String[] args) {
        String inputString = "abacabad";
        Character result = firstUniqueCharacter(inputString);
        System.out.println(result);
    }
}

