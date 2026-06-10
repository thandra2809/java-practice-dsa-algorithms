package org.research;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramFrequencyIndex {
    static void main() {

        String s = "abab";
        String p = "ab";


        List<Integer> list = new ArrayList<>();
        int[] pFrequency = new int[26];

        for(char c : p.toCharArray()) {
            pFrequency[c-'a']++;
        }

        String pFrequencyKey = "";
        for (int k = 0; k < 26; k++)
        {
            pFrequencyKey = pFrequencyKey + String.valueOf((char)(k+'a')) + pFrequency[k];
        }

        int left=0;
        int right=p.length();


        while(right<=s.length()) {
            String windowString = s.substring(left,right);
            int[] windowFrequency = new int[26];
            String windowFrequencyKey = "";

            for(char c : windowString.toCharArray()) {
                windowFrequency[c-'a']++;
            }
            for (int k = 0; k < 26; k++)
            {
                windowFrequencyKey = windowFrequencyKey + String.valueOf((char)(k+'a')) + windowFrequency[k];
            }

            if(pFrequencyKey.equals(windowFrequencyKey)) {
                System.out.println("Anagram matching freq:: " + left+ " " + right);
                list.add(left);

            }
            left= left+1;
            right= right+1;
        }




    }
}
