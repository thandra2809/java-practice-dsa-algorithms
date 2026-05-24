package org.dsa.practice.strings;

import java.util.Arrays;

public class LowerToUpperAndUpperToLower {
    static void main() {

        String testString = "WElCOME";

        char[] testChars = testString.toCharArray();

        for(int i = 0; i < testChars.length; i++) {
            if(testChars[i] >= 'a' && testChars[i] <= 'z') {
                // convert small to cap deduct small a and add caps A
                testChars[i] = (char)(testChars[i]-'a'+'A');
            }else if(testChars[i] >= 'A' && testChars[i] <= 'Z') {
                // convert caps to small deduct capital A and add small a
                testChars[i] = (char)(testChars[i]-'A'+'a');
            }
        }

        System.out.println(Arrays.toString(testChars));
    }
}
