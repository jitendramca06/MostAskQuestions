package com.mostaskquestions.arrays;

public class RemoveDuplicate {
    private static void removeDuplicate(int[] numbers) {
        MyQuickSort.sort(numbers);
        int j = 0;
        for (int i = 0 ; i < numbers.length - 1 ; i++) {
            if (numbers[i] != numbers[i + 1]) {
                numbers[j++] = numbers[i];
            }
        }
        numbers[j++] = numbers[numbers.length -1];
        for (int i = 0 ; i < j ; i++)
            System.out.println(numbers[i]);
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,2,2,3,3,3,4,5,6, 6};
        removeDuplicate(numbers);
    }
}
