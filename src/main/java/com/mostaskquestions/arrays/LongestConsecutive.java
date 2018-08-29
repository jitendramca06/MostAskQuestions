package com.mostaskquestions.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jitendra Kumar : 24/8/18
 */
public class LongestConsecutive {
    public static int longestConsecutive(int[] num) {
        // if array is empty, return 0
        if (num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int e : num)
            set.add(e);

        for (int e : num) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(count, max);
        }

        return max;
    }

    public static void main(String[] args) {
        /**
         * Your algorithm should run in O(n) complexity.
         */
        int[] a = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(a));
    }
}
