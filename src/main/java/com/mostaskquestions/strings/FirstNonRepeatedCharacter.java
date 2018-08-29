package com.mostaskquestions.strings;

public class FirstNonRepeatedCharacter {
    public static Character getFirstNonRepeatingCharacterLinearOptimized(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }

        int n = string.length();
        if (n == 1) {
            return string.charAt(0);
        }

        int[] charIdx = new int[256];

        for (int i = 0; i < 256; i++) {
            charIdx[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (charIdx[string.charAt(i)] == -1) {

                charIdx[string.charAt(i)] = i;
            } else {
                charIdx[string.charAt(i)] = -2;
            }
        }

        int minIdx = n;
        for (int i = 0; i < 256; i++) {
            if (charIdx[i] >= 0 &&
                    minIdx > charIdx[i]) {
                minIdx = charIdx[i];
            }
        }
        return (minIdx >= 0 && minIdx < n) ? string.charAt(minIdx) : null;
    }

    public static Character getFirstNonRepeatingCharacterLinear(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }

        int n = string.length();
        if (n == 1) {
            return string.charAt(0);
        }

        int[] charCounts = new int[256];

        for (int i = 0; i < 256; i++) {
            charCounts[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            charCounts[string.charAt(i)]++;
        }

        for (int i = 0; i < n; i++) {
            if (charCounts[string.charAt(i)] == 1) {
                return string.charAt(i);
            }
        }
        return null;
    }

    public static Character getFirstNonRepeatingCharacterNaive(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }

        int n = string.length();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j && string.charAt(i) == string.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return string.charAt(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String string = "ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB";
        System.out.println("Output: " + getFirstNonRepeatingCharacterLinearOptimized(string));
    }
}
