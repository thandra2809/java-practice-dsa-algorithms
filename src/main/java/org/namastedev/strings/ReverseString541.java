package org.namastedev.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseString541 {
    static void main() {
        String s = "a";
        int k = 2;

        String[] splittedStrings = splitStrings(s,k);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < splittedStrings.length; i++) {

            if(splittedStrings[i].length()>=k) {
                sb.append(doTheSwap(splittedStrings[i], k));
            }else{
                sb.append(splittedStrings[i]);
            }
             System.out.println(sb.toString());
        }



    }

    private static String doTheSwap(String splittedString, int k) {

        char[] chars = splittedString.toCharArray();

        int l=0;
        int r=k;
        char temp = ' ';
        while (l<r-1){
            temp = chars[l];
            chars[l] = chars[r-1];
            chars[r-1] = temp;
            l++;
            r--;
        }

        return new String(chars);
    }

    static String[] splitStrings(String s,int k){
        List<String> chunks = new ArrayList<>();
        int chunkSize = 2*k;

        if (s.length() < 2*k) {
            chunks.add(s);
            return chunks.toArray(new String[0]);
        }

        for (int i = 0; i < s.length(); i=i+2*k)
        {
            int end = Math.min(i + chunkSize, s.length());
            chunks.add(s.substring(i, end));
        }
        return chunks.toArray(new String[0]);
    }


}
