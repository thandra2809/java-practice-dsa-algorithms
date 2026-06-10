package org.research;

import java.util.HashMap;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        // Pass 1: build frequency map
        for (char c : s.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        }

        // Pass 2: find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter sol = new FirstUniqueCharacter();

        // Test 1: normal case
        String s1 = "leetcode";
        int result1 = sol.firstUniqChar(s1);
        System.out.println("Test 1 — Input: \"" + s1 + "\"");
        System.out.println("         Index : " + result1);
        System.out.println("         Char  : " + (result1 != -1 ? s1.charAt(result1) : "none"));
        System.out.println("         Expected: 0 (l)");
        System.out.println();

        // Test 2: first unique is in the middle
        String s2 = "loveleetcode";
        int result2 = sol.firstUniqChar(s2);
        System.out.println("Test 2 — Input: \"" + s2 + "\"");
        System.out.println("         Index : " + result2);
        System.out.println("         Char  : " + (result2 != -1 ? s2.charAt(result2) : "none"));
        System.out.println("         Expected: 2 (v)");
        System.out.println();

        // Test 3: no unique character
        String s3 = "aabb";
        int result3 = sol.firstUniqChar(s3);
        System.out.println("Test 3 — Input: \"" + s3 + "\"");
        System.out.println("         Index : " + result3);
        System.out.println("         Char  : " + (result3 != -1 ? s3.charAt(result3) : "none"));
        System.out.println("         Expected: -1 (no unique char)");
        System.out.println();

        // Test 4: single character
        String s4 = "z";
        int result4 = sol.firstUniqChar(s4);
        System.out.println("Test 4 — Input: \"" + s4 + "\"");
        System.out.println("         Index : " + result4);
        System.out.println("         Char  : " + (result4 != -1 ? s4.charAt(result4) : "none"));
        System.out.println("         Expected: 0 (z)");
        System.out.println();

        // Test 5: all same characters
        String s5 = "aaaa";
        int result5 = sol.firstUniqChar(s5);
        System.out.println("Test 5 — Input: \"" + s5 + "\"");
        System.out.println("         Index : " + result5);
        System.out.println("         Char  : " + (result5 != -1 ? s5.charAt(result5) : "none"));
        System.out.println("         Expected: -1 (no unique char)");
        System.out.println();

        // Test 6: unique char at the end
        String s6 = "aabbc";
        int result6 = sol.firstUniqChar(s6);
        System.out.println("Test 6 — Input: \"" + s6 + "\"");
        System.out.println("         Index : " + result6);
        System.out.println("         Char  : " + (result6 != -1 ? s6.charAt(result6) : "none"));
        System.out.println("         Expected: 4 (c)");
        System.out.println();

        // ── Summary ───────────────────────────────────────────────────────────
        System.out.println("=== Summary ===");
        System.out.printf("%-10s %-15s %-8s %-8s%n", "Test", "Input", "Index", "Char");
        System.out.println("------------------------------------------");
        String[] inputs   = {s1, s2, s3, s4, s5, s6};
        int[]    results  = {result1, result2, result3, result4, result5, result6};
        for (int i = 0; i < inputs.length; i++) {
            char ch = results[i] != -1 ? inputs[i].charAt(results[i]) : '-';
            System.out.printf("%-10s %-15s %-8d %-8s%n",
                "Test " + (i + 1), inputs[i], results[i], ch);
        }
    }
}