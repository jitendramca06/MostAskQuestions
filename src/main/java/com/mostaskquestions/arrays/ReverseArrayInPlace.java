package com.mostaskquestions.arrays;

/**
 * @author Jitendra Kumar : 24/8/18
 */
public class ReverseArrayInPlace {
    private static void reverse(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;

        for (int i = 0 ; i < numbers.length ; i++) {
            System.out.print(numbers[i] + "  ");
        }

        while (low < high) {
            int temp = numbers[low];
            numbers[low] = numbers[high];
            numbers[high] = temp;
            low++;
            high--;
        }

        System.out.println();
        for (int i = 0 ; i < numbers.length ; i++) {
            System.out.print(numbers[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 2};
        System.out.println("==========================");
        reverse(a);
        int[] b = {1, 3, 5, 4, 2, 7};
        System.out.println("==========================");
        reverse(b);
    }
}
