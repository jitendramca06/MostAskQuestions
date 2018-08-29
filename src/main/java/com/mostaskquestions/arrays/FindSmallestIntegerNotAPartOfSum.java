package com.mostaskquestions.arrays;

public class FindSmallestIntegerNotAPartOfSum {
    // Returns the smallest number that cannot be represented as sum
    // of subset of elements from set represented by sorted array arr[0..n-1]

    // Traverse the array and increment 'res' if arr[i] is
    // smaller than or equal to 'res'.
    private static void notPartOfSum(int[] numbers) {
        MyQuickSort.sort(numbers);
        int result = 1;
        for (int i = 0 ; i < numbers.length && result >= numbers[i] ; i++) {
            result = result + numbers[i];
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 8, 20};
        notPartOfSum(numbers);
    }
}
