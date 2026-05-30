package org.namastedev.twopointersandslidingwindow;

import java.util.HashMap;

public class LongestSubStringLC3 {
    static void main() {

        String s = "abcabcbb";

        HashMap<Character, Integer> map = new HashMap<>(); // char -> last seen index
        int max = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // if duplicate found, shrink window from left
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);                        // update last seen index
            max = Math.max(max, right - left + 1);    // update max window size

            System.out.println(map);
            System.out.println(max);
        }

        System.out.println(max);

    }
}
