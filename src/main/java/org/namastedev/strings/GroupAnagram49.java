package org.namastedev.strings;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram49 {
    static void main() {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        char[] tempStringArray;
        for (int i = 0; i < strs.length; i++) {
            tempStringArray = strs[i].toCharArray();
            Arrays.sort(tempStringArray);
            String key = new String(tempStringArray);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        List<List<String>> result = new ArrayList<>(map.values());

        System.out.println(result);
    }
}
