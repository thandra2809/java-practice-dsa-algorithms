package org.dsa.leetcode.strings;

import java.util.Arrays;

public class FindWordsThatCanBeFormedLC1160 {
    static void main() {
        int totalOfChars = 0;

        totalOfChars = countWords(new String[]{"cat", "bt", "hat", "tree"}, "atach");

        System.out.println(totalOfChars);
    }

    private static int countWords(String[] words, String chars) {
        int totalCharCount = 0;
        int[] charCounts = new int[26];
        for (char c : chars.toCharArray()) {
            charCounts[c - 'a']++;
        }

        for (int i = 0; i < words.length; i++) {
            int[] wordCounts = new int[26];

            for (char c : words[i].toCharArray()) {
                wordCounts[c - 'a']++;
            }

            boolean goodString = true;

            for (int j = 0; j < wordCounts.length; j++) {
                if (wordCounts[j] > charCounts[j]) {
                    goodString = false;
                    break;
                }
            }

            if (goodString) totalCharCount += words[i].length();
            // return totalCharCount;
        }


        return totalCharCount;
    }

}
