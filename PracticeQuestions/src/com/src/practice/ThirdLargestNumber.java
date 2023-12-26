package com.src.practice;

public class ThirdLargestNumber {

    public static int findThirdLargest(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Array should have at least three elements");
        }

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > firstLargest) {
                thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num != firstLargest) {
                thirdLargest = secondLargest;
                secondLargest = num;
            } else if (num > thirdLargest && num != firstLargest && num != secondLargest) {
                thirdLargest = num;
            }
        }

        return thirdLargest;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 10, 1, 7, 3};

        int thirdLargest = findThirdLargest(nums);
        System.out.println("Third Largest Number: " + thirdLargest);
    }
}

