package com.mostaskquestions.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintSubArrayWithSumZero {
    private static void printSubArray(int[] numbers) {
        for (int i = 0 ; i < numbers.length ; i++) {
            int sum = 0;
            for (int j = i ; j < numbers.length ; j++) {
                sum = sum + numbers[j];
                if (sum == 0) {
                    System.out.println("[" + i + "," + j + "]");
                }
            }
        }
    }

    // Utility function to insert <key, value> into the Multimap
    private static<K,V> void insert(Map<K, List<V>> hashMap, K key, V value)
    {
        // if the key is seen for the first time, initialize the list
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }

        hashMap.get(key).add(value);
    }

    // Function to print all sub-arrays with 0 sum present
    // in the given array
    public static void printallSubarrays(int[] A)
    {
        // create an empty Multi-map to store ending index of all
        // sub-arrays having same sum
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // insert (0, -1) pair into the map to handle the case when
        // sub-array with 0 sum starts from index 0
        insert(hashMap, 0, -1);

        int sum = 0;

        // traverse the given array
        for (int i = 0; i < A.length; i++)
        {
            // sum of elements so far
            sum += A[i];

            // if sum is seen before, there exists at-least one
            // sub-array with 0 sum
            if (hashMap.containsKey(sum))
            {
                List<Integer> list = hashMap.get(sum);

                // find all sub-arrays with same sum
                for (Integer value: list) {
                    System.out.println("Subarray [" + (value + 1) + ".." +
                            i + "]");
                }
            }

            // insert (sum so far, current index) pair into the Multi-map
            insert(hashMap, sum, i);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {4, 2, -3, -1, 0, 4};
        printSubArray(numbers);
        int[] A = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

        printallSubarrays(A);
    }
}
