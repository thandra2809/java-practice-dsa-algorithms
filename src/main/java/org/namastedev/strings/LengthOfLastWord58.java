package org.namastedev.strings;

public class LengthOfLastWord58 {
    static void main() {

        String s = "  fly me   to   the moon  ";

        char[] chars = s.toCharArray();
        int len = chars.length - 1;

        while (len >= 0) {
            if (chars[len] == ' ') {
                len = len - 1;
            } else {
                break;
            }
        }

        int lastWordCount = 0;
        for (int i = len; i >= 0; i--) {
            if (chars[i] != ' ') {
                lastWordCount++;
            }else{
                break;
            }
        }

        System.out.println(lastWordCount);


    }
}
