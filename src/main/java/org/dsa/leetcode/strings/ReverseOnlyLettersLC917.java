package org.dsa.leetcode.strings;

public class ReverseOnlyLettersLC917 {
    static void main() {
     String s1 = "ab-cd";
     String reversedS1 = reverseOnlyLetters(s1);
        System.out.println(reversedS1);
     String s2 = "a-bC-dEf-ghIj";
        String reversedS2 = reverseOnlyLetters(s2);
        System.out.println(reversedS2);
     String s3 = "Test1ng-Leet=code-Q!";
        String reversedS3 = reverseOnlyLetters(s3);
        System.out.println(reversedS3);


    }

    private static String reverseOnlyLetters(String s1) {
        char[] charArray = s1.toCharArray();

        // left pointer
        int l = 0;
        // right pointer
        int r=charArray.length-1;

        while(l<r){
            if(isNotALetter(charArray[l])){
                l++;
                continue;
            }
            if(isNotALetter(charArray[r])){
                r--;
                continue;
            }

            if(!isNotALetter(charArray[l])&&!isNotALetter(charArray[r])){
                char temp = charArray[l];
                charArray[l] = charArray[r];
                charArray[r] = temp;
                l++;
                r--;
            }

        }

        return new String(charArray);
    }

    private static boolean isNotALetter(char c) {
        return !Character.isLetter(c);
    }


}
