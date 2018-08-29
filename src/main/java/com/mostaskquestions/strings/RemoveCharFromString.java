package com.mostaskquestions.strings;

public class RemoveCharFromString {

    public static String remove(String word, char unwanted) {
        StringBuilder sb = new StringBuilder();
        char[] letters = word.toCharArray();
        for (char c : letters) {
            if (c != unwanted) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String removeRecursive(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        return removeRecursive(word.substring(0, index) + word.substring(index + 1, word.length()), ch);
    }

    public static void main(String[] args) {
        String data = "Java is a programing language.";
        System.out.println(removeRecursive(data, 'a'));
        System.out.println(remove(data, 'a'));
    }

}
