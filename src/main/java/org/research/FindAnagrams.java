package org.research;

import java.util.*;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if (s.length() < p.length()) return list;

        // Build frequency array for p
        int[] pFrequency = new int[26];
        for (char c : p.toCharArray()) {
            pFrequency[c - 'a']++;
        }

        // Build frequency array for first window
        int[] windowFrequency = new int[26];
        for (int i = 0; i < p.length(); i++) {
            windowFrequency[s.charAt(i) - 'a']++;
        }

        int left  = 0;
        int right = p.length();

        while (right <= s.length()) {

            // Compare using Arrays.equals instead of building key strings
            if (Arrays.equals(pFrequency, windowFrequency)) {
                System.out.println("Anagram found at index: " + left);
                list.add(left);
            }

            if (right < s.length()) {
                // Add new right char into window
                windowFrequency[s.charAt(right) - 'a']++;
                // Remove old left char from window
                windowFrequency[s.charAt(left) - 'a']--;
            }

            left++;
            right++;
        }

        return list;
    }

    public static void main(String[] args) {
        FindAnagrams sol = new FindAnagrams();

        System.out.println("Test 1: " + sol.findAnagrams("cbaebabacd", "abc"));
        System.out.println("Expected:  [0, 6]");
        System.out.println();

        System.out.println("Test 2: " + sol.findAnagrams("abab", "ab"));
        System.out.println("Expected:  [0, 1, 2]");
        System.out.println();

        System.out.println("Test 3: " + sol.findAnagrams("hello", "xyz"));
        System.out.println("Expected:  []");
        System.out.println();

        System.out.println("Test 4: " + sol.findAnagrams("aaaaaaa", "aaa"));
        System.out.println("Expected:  [0, 1, 2, 3, 4]");
    }
}