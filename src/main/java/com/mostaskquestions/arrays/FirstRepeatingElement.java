package com.mostaskquestions.arrays;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingElement {
    private static void fistRepeatingE(int[] a) {
        int index = 0;
        int firstElement = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < a.length ; i++) {
            if (set.contains(a[i])) {
                firstElement = a[i];
                index = i;
                break;
            } else {
                set.add(a[i]);
            }
        }

        System.out.println("index-" + index + "=" + firstElement);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,1, 2, 4};
        fistRepeatingE(a);
    }
}
