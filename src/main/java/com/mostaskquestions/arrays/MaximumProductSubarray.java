package com.mostaskquestions.arrays;

public class MaximumProductSubarray {
    private static void maxProduct(int[] numbers) {
        int minVal = numbers[0];
        int maxval = numbers[0];
        int maxProduct = numbers[0];

        for (int i = 1; i < numbers.length ; i++) {
            // When multiplied by -ve number,
            // maxVal becomes minVal
            // and minVal becomes maxVal
            if (numbers[i] < 0) {
                int temp = maxval;
                maxval = minVal;
                minVal = temp;
            }

            // maxVal and minVal stores the
            // product of subarray ending at arr[i].
            maxval = Math.max(numbers[i], maxval*numbers[i]);
            minVal = Math.min(numbers[i], minVal * numbers[i]);

            // Max Product of array.
            maxProduct = Math.max(maxProduct, maxval);
        }

        System.out.println(maxProduct);
    }

    public static void main(String[] args) {
        int[] numbers = { -1, -3, -10, 0, 60 };
        maxProduct(numbers);
    }
}
