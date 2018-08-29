package com.mostaskquestions.arrays;

public class SmallestLargest {
    private static void smallestLargest(int [] numbers) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int i = 0 ; i < numbers.length ; i++) {
            if (numbers[i] < smallest)
                smallest = numbers[i];
            if (numbers[i] > largest)
                largest = numbers[i];
        }
        System.out.println(smallest);
        System.out.println(largest);
    }

    public static void main(String[] args) {
        int[] numbers = {12, -10, 3, 1, 90, 73, 500};
        smallestLargest(numbers);
    }
}
