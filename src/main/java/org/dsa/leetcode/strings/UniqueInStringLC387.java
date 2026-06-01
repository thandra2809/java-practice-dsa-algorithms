package org.dsa.leetcode.strings;

import java.util.Arrays;

public class UniqueInStringLC387 {
    static void main() {
//        String s1 = "leetcode"
//        String s2s = "loveleetcode"
//        s = "aabb"

        int index=-1;
        index = firstUniqueCharacterInString("leetcode");
        System.out.println(index);

        index = firstUniqueCharacterInString("loveleetcode");
        System.out.println(index);
        
        index = firstUniqueCharacterInString("aabb");
        System.out.println(index);
    }

    private static int firstUniqueCharacterInString(String s) {
        int[] map = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map[charArray[i] - 'a']++;
        }
        System.out.println(Arrays.toString(map));
        for (int i = 0; i < charArray.length; i++) {
            if (map[charArray[i] - 'a'] == 1) return i;
        }


        return -1;
    }
}
