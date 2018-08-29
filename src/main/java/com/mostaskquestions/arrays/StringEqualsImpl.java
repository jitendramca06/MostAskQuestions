package com.mostaskquestions.arrays;

/**
 * @author Jitendra Kumar : 24/8/18
 */
public class StringEqualsImpl {
    private static boolean equals(String source, String target) {
        int t = 0;
        int s = 0;
        char[] sources = source.toCharArray();
        char[] targets = target.toCharArray();

        while (s < sources.length && t < targets.length) {
            if (sources[s++] == targets[t++]) continue;
            else return false;
        }

        return true;
    }

    public static void main(String[] args) {
        /*String target = "Target";
        String source = "Target";
        System.out.println(equals(target, source));*/

        String target = "Sargetdvsadkljvllllllllllllllllllllllsdkljjjjjjjjjjjjjjjjjjjjjjjjjjjjvldshsdkvdslkvsdkvkxbcsdklvdsklvdskvcsdlkvdslkvjsd";
        String source = "Sargetdvsadkljvllllllllllllllllllllllsdkljjjjjjjjjjjjjjjjjjjjjjjjjjjjvldshsdkvdslkvsdkvkxbcsdklvdsklvdskvcsdlkvdslkvjsd";
        System.out.println(equals(target, source));
    }
}
