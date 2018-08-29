package com.mostaskquestions.strings;

public class Interleaving {

    // Function to check if String X and Y are interleaving of
    // String S or not
    public static boolean interleaved(String X, String Y, String S)
    {
        // return true if we have reached end of all Strings
        if (X.length() == 0 && Y.length() == 0 && S.length() == 0) {
            return true;
        }

        // return false if we have reached the end of String S
        // but String X or Y are not empty
        if (S.length() == 0) {
            return false;
        }

        // if String X is not empty and its first character matches with
        // first character of S, recurse for remaining subString
        if (X.length() != 0 && S.charAt(0) == X.charAt(0)) {
            return interleaved(X.substring(1), Y, S.substring(1));
        }

        // if String Y is not empty and its first character matches with
        // first character of S, recurse for remaining subString
        if (Y.length() != 0 && S.charAt(0) == Y.charAt(0)) {
            return interleaved(X, Y.substring(1), S.substring(1));
        }

        return false;
    }

    public static void main(String[] args)
    {
        String X = "ABC";
        String Y = "DEF";
        String S = "ADEBFC";

        if (interleaved(X, Y, S)) {
            System.out.print("Given String is interleaving of X and Y");
        } else {
            System.out.print("Given String is not an interleaving of X and Y");
        }
    }
}
