package com.mostaskquestions.arrays;

/**
 * @author Jitendra Kumar : 24/8/18
 */
public class FindElementsOccurringNByKTimes {
    private static void findElement(int[] numbers, int k) {
        int count = numbers.length/k;
        int[] temp = new int[numbers.length];
        for (int i = 0 ; i < numbers.length ; i++)
            temp[i] = numbers[i];

        for (int i = 0 ; i < numbers.length ; i++) {
            int tempCount = 0;
            int j = 0;
            for (; j < numbers.length ; j++) {
                if (temp[j] == Integer.MIN_VALUE) continue;
                if (numbers[i] == numbers[j]) {
                    tempCount++;
                    temp[j] = Integer.MIN_VALUE;
                }
            }
            if (tempCount > count && j == numbers.length) {
                System.out.println("Number-" + numbers[i] + ", Count-" + tempCount);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {3, 1, 2, 2, 1, 2, 3, 3};
        findElement(numbers, 4);
    }
}
