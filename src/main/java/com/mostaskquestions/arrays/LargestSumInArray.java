package com.mostaskquestions.arrays;

public class LargestSumInArray {
    private static void largestSum(int[] numbers) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int startIndex = 0;
        int endIndex = 0;
        int s = 0;

        for (int i = 0 ; i < numbers.length ; i++) {
            maxEndingHere = maxEndingHere + numbers[i];
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                startIndex = s;
                endIndex = i;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                s = i +1;
            }
        }

        System.out.println(maxSoFar);
        for (int i = startIndex ; i <= endIndex ; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static void main(String[] args) {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        largestSum(a);
    }
}
