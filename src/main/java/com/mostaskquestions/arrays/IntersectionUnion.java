package com.mostaskquestions.arrays;

public class IntersectionUnion {
    private static void intersection(int[] a, int[] b) {
        MyQuickSort.sort(a);
        MyQuickSort.sort(b);

        int firstArray = 0;
        int secondArray = 0;

        while (firstArray < a.length && secondArray < b.length) {
            if (a[firstArray] < b[secondArray]) {
                firstArray++;
            } else if (a[firstArray] > b[secondArray]) {
                secondArray++;
            } else {
                System.out.println(a[firstArray]);
                firstArray++;
                secondArray++;
            }
        }
    }

    private static void union(int[] a, int[] b) {
        MyQuickSort.sort(a);
        MyQuickSort.sort(b);

        int firstArray = 0;
        int secondArray = 0;
        int[] result = new int[a.length+b.length];
        int j = 0;

        while (firstArray < a.length && secondArray < b.length) {
            if (a[firstArray] < b[secondArray]) {
                result[j++] = a[firstArray];
                firstArray++;
            } else if (a[firstArray] > b[secondArray]) {
                result[j++] = b[secondArray];
                secondArray++;
            } else {
                result[j++] = b[secondArray];
                firstArray++;
                secondArray++;
            }
        }
        while (secondArray < b.length) {
            result[j++] = b[secondArray++];
        }

        while (firstArray < a.length) {
            result[j++] = a[firstArray];
            firstArray++;
        }

        for (int i = 0 ; i < j ; i++)
            System.out.println(result[i]);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {5, 6, 7, 8, 9};
        intersection(a, b);
        union(a, b);
    }
}
