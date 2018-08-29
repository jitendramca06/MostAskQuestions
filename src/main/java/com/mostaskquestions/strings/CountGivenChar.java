package com.mostaskquestions.strings;

public class CountGivenChar {
    private static void count(String string) {
        int c = 0;
        for (int i = 0 ; i < string.length() ; i++) {
            switch (string.charAt(i)) {
                case 'a':
                    c++;
            }
        }
        System.out.println(c);
    }

     public static void main(String[] args) {
        String s = "andfkirnaaajkgjgjaa";
        count(s);
    }
}
