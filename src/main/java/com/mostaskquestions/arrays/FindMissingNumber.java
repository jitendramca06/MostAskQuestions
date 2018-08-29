package com.mostaskquestions.arrays;

public class FindMissingNumber {
    private static int missingN(int [] numbers, int totalCount) {
        int expectedSum = (totalCount * (totalCount + 1))/2;
        int actualSum = 0;
        for (int i = 0 ; i < numbers.length ; i++){
            actualSum = actualSum + numbers[i];
        }
        return (expectedSum - actualSum);
    }

    public static void main(String[] args) {
        int[] na = {1,2,3,4,6};
        System.out.println(missingN(na, 6));
        int[] a = {1,2,3,4,5,6,7,8,9,10,12};
        System.out.println(missingN(a, 12));
    }
}
