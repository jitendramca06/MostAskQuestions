package com.mostaskquestions.arrays;

public class KthSmallestLargest {
    private static void kthSmallest(int[] numbers, int k) {
        MyQuickSort.sort(numbers);
        System.out.println(numbers[k - 1]);
    }

    private static void kLargest(int[] numbers, int k) {
        MyQuickSort.sort(numbers);
        System.out.println(numbers[numbers.length - k]);
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,4,2,8,5,6};
        kLargest(numbers, 2);
        kthSmallest(numbers, 3);
    }
}
