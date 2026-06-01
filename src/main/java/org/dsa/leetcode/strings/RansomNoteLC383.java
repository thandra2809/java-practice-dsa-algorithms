package org.dsa.leetcode.strings;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class RansomNoteLC383 {
    static void main() {

        boolean canMagazineBeConstructed = false;

        System.out.println(checkForRansomNotes("a","b"));
        System.out.println(checkForRansomNotes("aa","ab"));
        System.out.println(checkForRansomNotes("aa","aab"));

    }

    private static boolean checkForRansomNotes(String ransomNote, String magazine) {
        int[] counts = new int[26];
        char[] charArray = magazine.toCharArray();

        for (char c : charArray) {
            counts[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--counts[c - 'a'] < 0) {
                return false;
            }
        }



        return true;
    }
}
