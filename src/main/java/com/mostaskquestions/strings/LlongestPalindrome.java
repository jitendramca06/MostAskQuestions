package com.mostaskquestions.strings;

public class LlongestPalindrome {
    private static String intermediateP(String source, int left, int right) {
        if (left > right) return null;
        while (left >= 0  && right < source.length() && source.charAt(left) == source.charAt(right)) {
            left--;
            right++;
        }
        return source.substring(left+1, right);
    }

    private static String longestP(String source) {
        String longest = source.substring(0, 1);
        for (int i = 0 ; i < source.length() ; i++) {
            //For ODD section-121
            String p = intermediateP(source, i, i);
            if (p.length() > longest.length()) {
                longest = p;
            }
            //For EVEN section-1221
            p = intermediateP(source, i, i+1);
            if (p.length() > longest.length()) {
                longest = p;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestP("ZXYPABCDCBAKL"));
    }
}
