package com.src.practice;

public class SecondLargestNumber {

    public static int findSecondLargest(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array should have at least two elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Array contains duplicate values");
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 10, 1, 7};

        int secondLargest = findSecondLargest(nums);
        System.out.println("Second Largest Number: " + secondLargest);
    }
}

