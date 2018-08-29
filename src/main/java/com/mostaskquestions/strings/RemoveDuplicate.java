package com.mostaskquestions.strings;

public class RemoveDuplicate {
    private static void removeDupl1(String string) {
        if (string == null)
            System.out.println("Invalid String");
        if (string.length() == 1)
            System.out.println("Not duplicate is found");
        String result = "";
        char[] chars = string.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            if (result.indexOf(chars[i]) == -1)
                result = result+ chars[i];
        }
        System.out.println(result);
    }

    private static void removeDupl(String string) {
        if (string == null)
            System.out.println("Invalid String");
        if (string.length() == 1)
            System.out.println("Not duplicate is found");

        StringBuilder stringBuilder = new StringBuilder();
        int[] indexes = new int[256];
        for (int i = 0 ; i < 256 ; i++)
            indexes[i] = -1;
        for (int i = 0 ; i < string.length() ; i++) {
            if (indexes[string.charAt(i)] == -1) {
                indexes[string.charAt(i)] = i;
                stringBuilder.append(string.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());

    }

    public static void main(String[] args) {
        removeDupl("AABBCCDEF");
        removeDupl1("AABBCCDEFAAAFFF");
    }
}
