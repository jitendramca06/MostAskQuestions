package com.mostaskquestions.arrays;

public class TopTwoMaximum {
    private static void topTwo(int[] numbers) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max1) {
                max2 = max1;
                max1 = number;
            } else if (number > max2) {
                max2 = number;
            }
        }

        System.out.println(max1 + "," + max2);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 5, 4, 8, 7, 6};
        topTwo(numbers);
    }
}
