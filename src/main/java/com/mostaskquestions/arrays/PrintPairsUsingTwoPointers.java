package com.mostaskquestions.arrays;

public class PrintPairsUsingTwoPointers {
    private static void printPairs(int[] numbers, int k) {
        MyQuickSort.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == k) {
                System.out.println(numbers[left] + "=" + numbers[right]);
                left++;
                right--;
            } else if (sum > k) {
                right--;
            } else if (sum < k) {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        // O(N) with additional space and O(NLogN)
        int[] numbers = {-2, 1, 4, 5, 7, 10, 14};
        printPairs(numbers, 12);
        int[] a = {-10, -15, 10, 2, 100, 3, 32, 32, 20};
        printPairs(a, 30);
    }
}
