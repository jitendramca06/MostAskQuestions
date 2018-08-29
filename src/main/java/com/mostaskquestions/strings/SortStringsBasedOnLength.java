package com.mostaskquestions.strings;

import java.util.Arrays;

public class SortStringsBasedOnLength {
    private static void sortStrings(String []source) {
        for(int y = source.length-2 ; y >0; y--){
            for(int x = 0 ; x<=y ; x++){
                if(source[x].length() > source[x+1].length()){
                    String temp = source[x];
                    source[x]=source[x+1];
                    source[x+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(source));
    }

    public static void main(String[] args) {
        String[] s = {"Name", "Hi", "Hello", "aa"};
        sortStrings(s);
    }
}
