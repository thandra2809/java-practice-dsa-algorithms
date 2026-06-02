package org.dsa.leetcode.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class AllCommonCharactersLC1941 {
    static void main() {
        boolean commonCharString = false;

        commonCharString = checkForCommonChars("abacbc");
        System.out.println(commonCharString);
    }

    private static boolean checkForCommonChars(String s) {
        int[] frequency = new int[26];
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            frequency[arr[i] - 'a']++;
        }

        HashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                set.add(frequency[i]);
            }
        }
        return set.size() == 1;
    }
}
