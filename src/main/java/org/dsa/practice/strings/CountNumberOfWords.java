package org.dsa.practice.strings;

public class CountNumberOfWords {
    static void main() {
        String str = "can you count the   number of words";

        char[] charArray = str.toCharArray();
        int numberOfWords = 1;

        for (int c = 0; c < charArray.length ; c++) {
            if (charArray[c] == ' ' && charArray[c - 1] != ' ') {
                numberOfWords++;
            }

        }

        System.out.println(numberOfWords);

    }
}
