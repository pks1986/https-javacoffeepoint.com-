package com.src.practice;

public class ThirdMinimum {

    public static int findThirdMinimum(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Input array should have at least 3 elements");
        }

        Integer firstMin = null;
        Integer secondMin = null;
        Integer thirdMin = null;

        for (int num : nums) {
            if (firstMin == null || num < firstMin) {
                thirdMin = secondMin;
                secondMin = firstMin;
                firstMin = num;
            } else if ((secondMin == null || num < secondMin) && num != firstMin) {
                thirdMin = secondMin;
                secondMin = num;
            } else if ((thirdMin == null || num < thirdMin) && num != firstMin && num != secondMin) {
                thirdMin = num;
            }
        }

        if (thirdMin == null) {
            throw new IllegalArgumentException("Array contains only duplicates");
        }

        return thirdMin;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 1, 6, 1};

        int thirdMin = findThirdMinimum(nums);
        System.out.println("3rd minimum number: " + thirdMin);
    }
}