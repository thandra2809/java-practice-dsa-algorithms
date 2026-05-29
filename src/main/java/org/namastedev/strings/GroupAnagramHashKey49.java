package org.namastedev.strings;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagramHashKey49 {

    static void main() {

        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};

        int[] frequencyKey = new int[26];

        char[] tempStringArray;
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            tempStringArray = strs[i].toCharArray();

            for (int j = 0; j < tempStringArray.length; j++) {
                frequencyKey[tempStringArray[j] - 'a']++;
            }

            String finalKey="";
            for (int k = 0; k < 26; k++)
            {
                finalKey = finalKey + String.valueOf((char)(k+'a')) + frequencyKey[k];
            }

            frequencyKey = new int[26];

            map.putIfAbsent(finalKey,new ArrayList<>());
            map.get(finalKey).add(strs[i]);
        }

        System.out.println(new ArrayList<>(map.values()));



    }
}
