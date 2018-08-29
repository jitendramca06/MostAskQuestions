package com.mostaskquestions.strings;

public class ReplaceAllSpacesInURL {
    public void replace(String s1, int length) {
        char[] chars = s1.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        int newLength = length + 2 * spaceCount;
        char [] charsNew = new char [newLength];
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                charsNew[newLength - 1] = '0';
                charsNew[newLength - 2] = '2';
                charsNew[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                charsNew[newLength - 1] = chars[i];
                newLength = newLength - 1;
            }
        }
        System.out.println("Output String : " + String.valueOf(charsNew));
    }

    public static void main(String args[]) {
        String s1 = "I am akshay mehra";
        int trueLength = s1.length();
        System.out.println("Input String : " + s1);
        ReplaceAllSpacesInURL r = new ReplaceAllSpacesInURL();
        r.replace(s1, trueLength);
    }
}
