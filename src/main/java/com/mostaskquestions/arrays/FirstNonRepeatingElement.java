package com.mostaskquestions.arrays;

public class FirstNonRepeatingElement {
    private static void nonRepeatingElement(int[] numbers) {
        for (int i = 0 ; i < numbers.length ; i++ ) {
            int j;
            for (j = 0 ; j < numbers.length ; j++) {
                if (numbers[i] == numbers[j])
                    break;
            }
            if (j == numbers.length) {
                System.out.println(numbers[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,2,3,4,1,5};
        nonRepeatingElement(numbers);
    }
}
