package com.mostaskquestions.arrays;

/**
 * @author Jitendra Kumar : 24/8/18
 */
public class JavaContainsMethods {
    private static boolean contains(String[] strings, int i) {
        for (int j = 0 ; j < strings.length ; j++) {
            if (i != j && strings[j].equals(strings[i])) return true;
        }
        return false;
    }

    private static void checkDuplicate(String[] strings) {
        for (int i = 0 ; i < strings.length ; i++) {
            if (contains(strings, i)) System.out.println("String - " + strings[i] + " is repeated.");
        }
    }

    public static void main(String[] args) {
        String[] strings = {"A", "B", "A", "C", "E", "F", "E"};
        checkDuplicate(strings);
    }
}
