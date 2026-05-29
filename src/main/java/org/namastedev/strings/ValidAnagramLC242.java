package org.namastedev.strings;

import java.util.HashMap;

public class ValidAnagramLC242 {
    static void main() {
        String s = "car";
        String t = "rat";

        HashMap<Character, Integer> map = new HashMap<>();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for (char c : sArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
        for (char c : tArray) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        System.out.println(map);

        boolean isAnagram = map.entrySet().stream().allMatch((v)->v.getValue()==0);

        if(isAnagram){
            System.out.println("Is a Anagram");
        }
    }
}
