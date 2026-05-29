package org.namastedev.strings;

public class LongestCommonPrefixLC14 {
    static void main() {
        String[] strs = new String[]{"flower","flow","flight"};
        String prefix = strs[0];

        if (strs == null || strs.length == 0) {prefix= "";}


        for (int i = 1; i < strs.length; i++) {
            // trim prefix until current string starts with it
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {prefix= "";}
            }
        }
        System.out.println(prefix);
    }
}
