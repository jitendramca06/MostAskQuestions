package com.mostaskquestions.strings;

public class MostOccuranceOfChar {
    private static String mostOccuranceOfChar(String source) {
        char[] array = source.toCharArray();
        int maxCount = 1;
        char maxChar = array[0];

        for (int i = 0, j = 0; i < source.length() - 1; i = j) {
            int count = 1;
            while (++j < source.length() && array[i] == array[j]) {
                count++;
            }

            if (count > maxCount) {
                maxCount = count;
                maxChar = array[i];
            }
        }
        return (maxChar + " = " + maxCount);
    }
    public static void main(String[] args) {
        String str1=mostOccuranceOfChar("instanceofjava");
        System.out.println(str1);

        String str2=mostOccuranceOfChar("aaaabbbccc");
        System.out.println(str2);

        String str3=mostOccuranceOfChar("ssssiiinnn");
        System.out.println(str3);

        String str4=mostOccuranceOfChar("jaaaavvvvvvvvaaaaaaaaaa");
        System.out.println(str4);
    }
}
