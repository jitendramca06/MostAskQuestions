package com.mostaskquestions.strings;

import java.util.regex.Pattern;

public class ContainsOnlyDigits {
    public static boolean containsOnlyNumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String args[]) {

        // Regular expression in Java to check if String is number or not
        Pattern pattern = Pattern.compile(".*[^0-9].*");
        //Pattern pattern = Pattern.compile(".*\\D.*");
        String [] inputs = {"123", "-123" , "123.12", "abcd123"};

        for(String input: inputs){
            System.out.println( "does " + input + " is number : "
                    + !pattern.matcher(input).matches());
        }

        // Regular expression in java to check if String is 6 digit number or not
        String [] numbers = {"123", "1234" , "123.12", "abcd123", "123456"};
        Pattern digitPattern = Pattern.compile("\\d{6}");
        //Pattern digitPattern = Pattern.compile("\\d\\d\\d\\d\\d\\d");


        for(String number: numbers){
            System.out.println( "does " + number + " is 6 digit number : "
                    + digitPattern.matcher(number).matches());
        }

        System.out.println(containsOnlyNumbers("12"));
    }
}
