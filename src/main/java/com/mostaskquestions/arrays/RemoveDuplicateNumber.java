package com.mostaskquestions.arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example,
 * Given input array A = [1,1,2],
 *
 * Your function should return length = 2, and A is now [1,2].
 *
 * When you see a questions which asked you do to sorting or task in place, it means you cannot use additional array or buffer,
 * but using couple of variables is fine.
 */
public class RemoveDuplicateNumber {
    private static void removeDuplicate(int[] numbers) {
        MyQuickSort.sort(numbers);
        int pre = numbers[0];
        for (int i = 1 ; i < numbers.length ; i++) {
            if (numbers[i] == pre) {
                numbers[i] = 0;
            } else {
                pre = numbers[i];
            }
        }
        for (int i = 0 ; i < numbers.length ; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {7,1,3,2,6,4,8,5,7,7,8};
        removeDuplicate(numbers);
    }
}
