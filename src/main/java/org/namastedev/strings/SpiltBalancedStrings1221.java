package org.namastedev.strings;

public class SpiltBalancedStrings1221 {
    static void main() {
        String s="RLRRLLRLRL";

        char[] arr = s.toCharArray();
        int lCount = 0;
        int rCount = 0;
        int balancedStringCount = 0;

        for (int i = 0; i < arr.length; i++) {

            if(arr[i]=='R'){
                rCount++;
            }else if(arr[i]=='L'){
                lCount++;
            }

            if(lCount==rCount)
            {
                balancedStringCount++;
            }
        }

        System.out.println(balancedStringCount);

    }
}
