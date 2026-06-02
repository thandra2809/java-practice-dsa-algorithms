package org.dsa.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharsLC1002 {
    static void main() {

        /**
         * Input: words = ["bella","label","roller"]
         * Output: ["e","l","l"]
         *
         * Input: words = ["cool","lock","cook"]
         * Output: ["c","o"]
         */
        List<String> listOfStrings = new ArrayList<>();

        listOfStrings = findCommonCharacters(new String[]{"bella", "label", "roller"});

        System.out.println(listOfStrings);


    }

    private static List<String> findCommonCharacters(String[] strings) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String str : strings) {
            char[] chars = str.toCharArray();
            int[] freq = new int[26];
            for (char aChar : chars) {
                freq[aChar - 'a'] += 1;
            }

            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }


        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }
        return res;
    }
}
