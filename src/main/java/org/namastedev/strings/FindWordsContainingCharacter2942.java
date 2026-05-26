package org.namastedev.strings;

import java.util.ArrayList;

public class FindWordsContainingCharacter2942 {
    static void main() {

        String[] words = new String[]{"abc", "bcd", "aaaa", "cbc"};
        char x = 'a';

        // return list of integers at which the string contains character [0,2]

        ArrayList<Integer> result = new ArrayList<>();

        char[] str;
        for (int i = 0; i < words.length; i++) {
            str = words[i].toCharArray();

            int j = 0;
            while (j < str.length) {
                if (str[j] == x) {
                    result.add(i);
                   break;
                }
                j++;
            }
        }

        System.out.println(result);

    }
}
