package com.mostaskquestions.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jitendra Kumar : 24/8/18
 */
public class MatchPattern {
    private static void matchPattern(int[] a, int[] b, int minLength) {
        for (int i = 0 ; i < a.length ; i++) {
            int startIndex = i;
            int secondArrayIndex = 0;
            while (secondArrayIndex < b.length && startIndex < a.length) {
                if (a[startIndex] == b[secondArrayIndex]) {
                    secondArrayIndex = startMatching(a, startIndex, b, secondArrayIndex, minLength);
                } else {
                    secondArrayIndex++;
                }
            }
        }
    }

    private static int startMatching(int[] a, int aIndex, int[] b, int bIndex, int minLength) {
        List<Integer> result = new ArrayList<>();
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] == b[bIndex]) {
                result.add(a[aIndex]);
                aIndex++;
                bIndex++;
            } else {
                break;
            }
        }
        if (result.size() >= minLength) System.out.println(result.toString());
        return bIndex;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 10, 13, 15, 17, 33, 36, 40};
        int[] b = {13, 2, 3, 10, 21, 15, 17, 33, 36, 51, 55, 2, 3, 10};
        matchPattern(a, b, 2);
    }
}
