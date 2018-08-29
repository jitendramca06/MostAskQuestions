package com.mostaskquestions.strings;

public class ContainsIndexOfUse {
    private static void containsImpl(String source, String target) {
        char[] sChars = source.toCharArray();
        char[] tChars = target.toCharArray();
        int tLength = 0;
        int sLength = 0;
        boolean found = false;
        while (sLength < sChars.length) {
            while (tLength < tChars.length) {
                if (sChars[sLength] == tChars[tLength]) {
                    sLength++;
                    tLength++;
                    if (tLength == tChars.length) {
                        found = true;
                        break;
                    }
                } else {
                    tLength = 0;
                    sLength++;
                    break;
                }
            }
            if (found) break;
        }

        if (found) {
            System.out.println("String found at index -" + (sLength - tChars.length));
        }
        System.out.println(source.substring((sLength - tChars.length), (sLength - tChars.length) + tChars.length));
    }

    public static void main(String[] args) {
        String name = "Java is a programming language.";
        containsImpl(name, "language");
    }
}
