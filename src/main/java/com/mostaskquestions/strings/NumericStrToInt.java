package com.mostaskquestions.strings;

public class NumericStrToInt {

    private static void strintToInt(String string) {
        int value = Integer.valueOf(string);
        System.out.println(value);
        int val = Integer.parseInt(string);
        System.out.println(val);
    }

    public static void main(String[] args) {
        strintToInt("12342");
    }
}
