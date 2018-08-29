package com.mostaskquestions.strings;

public class DuplicateChars {
    private static void duplicate(String string) {
        if (string == null) {
            System.out.println("Not a valid string");
        }

        if (string.length() == 1) System.out.println("No duplicate char");

        if (string.length() == 2 && string.charAt(0) == string.charAt(1)) {
            System.out.println("Duplicate - " + string.charAt(0));
        }

        int[] indexes = new int[256];
        for (int i = 0 ; i < 256 ; i++) {
            indexes[i] = -1;
        }

        for (int i = 0 ; i < string.length() ; i++) {
            if (indexes[string.charAt(i)] == -1) {
                indexes[string.charAt(i)] = i;
            } else {
                System.out.println(string.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        String s = "AABCD";
        duplicate(s);
        s = "AABCDC";
        duplicate(s);
        s = "AABCDCPWDSP";
        duplicate(s);
    }
}
