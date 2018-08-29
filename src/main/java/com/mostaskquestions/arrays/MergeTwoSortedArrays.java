package com.mostaskquestions.arrays;

public class MergeTwoSortedArrays {
    private static void merge(int[] a, int[] b) {
        int first  = 0;
        int second = 0;
        int[] result = new int[a.length+b.length];
        int index = 0;
        while (first < a.length && second < b.length) {
            if (a[first] <= b[second]) {
                result[index++] = a[first++];
            } else {
                result[index++] = b[second++];
            }
        }

        while (first < a.length) {
            result[index++] = a[first++];
        }

        while (second < b.length) {
            result[index++] = b[second++];
        }

        for (int i = 0 ; i < result.length ; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int[] b = {2, 7, 8, 9};
        merge(a, b);
    }
}
