package com.mostaskquestions.arrays;

public class FindCommonElements {
    private static void common(int[] a, int[] b, int[] c) {
        MyQuickSort.sort(a);
        MyQuickSort.sort(b);
        MyQuickSort.sort(c);
        int first = 0;
        int second = 0;
        int third = 0;
        while (first < a.length && second < b.length && third < c.length) {
            if (a[first] == b[second] && b[second] == c[third]) {
                System.out.println(a[first]);
                first++;
                second++;
                third++;
            } else if (a[first] < b[second]) {
                first++;
            } else if (b[second] < c[third]) {
                second++;
            } else {
                third++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {1, 3, 2};
        int[] c = {2, 3, 4, 5, 6};
        common(a, b, c);
    }
}
