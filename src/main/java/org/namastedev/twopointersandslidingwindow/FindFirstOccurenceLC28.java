package org.namastedev.twopointersandslidingwindow;

public class FindFirstOccurenceLC28 {
    static void main() {
        String haystack = "sadbutsad";
        String needle = "sad";

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for ( j = i; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }

            }

            if(j==m){
                System.out.println(i);
            }

        }


    }
}
