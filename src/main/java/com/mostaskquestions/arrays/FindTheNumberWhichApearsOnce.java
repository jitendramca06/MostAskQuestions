package com.mostaskquestions.arrays;

public class FindTheNumberWhichApearsOnce {
    private static void find(int[] numbers) {
        int res = numbers[0];
        for (int i = 1; i < numbers.length ; i++) {
            res = res ^ numbers[i];
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,2,3,2,3,4};
        find(numbers);
    }
}
