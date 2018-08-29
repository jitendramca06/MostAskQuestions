package com.mostaskquestions.arrays;

public class RemoveGivenElementFromArray {
    private static void removeElement(int[] numbers, int element) {
        for (int i = 0 ; i < numbers.length ; i++) {
            if (numbers[i] == element){
                numbers[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0 ; i < numbers.length ; i++) {
            if (numbers[i] != Integer.MAX_VALUE) System.out.println(numbers[i]);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,2,4,5,2,8,2,9,2};
        removeElement(numbers, 2);
    }
}
