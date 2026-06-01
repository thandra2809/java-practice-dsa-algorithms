package org.dsa.leetcode.strings;

public class ReversePrefixLC2000 {
    static void main() {
        String word = "abcdefd";
        char ch = 'd';

        String reversedWord = reverseThePrefix(word,ch);
        System.out.println(reversedWord);
    }

    private static String reverseThePrefix(String word, char ch) {

        // find the index of the char
        char[] charArray = word.toCharArray();
        int prefixIndex = 0;

        for(int i=0;i<charArray.length;i++) {
            if(charArray[i]==ch) {
                prefixIndex = i;
                break;
            }
        }
        System.out.println("prefixIndex:"+prefixIndex);

        int l =0;
        int r=prefixIndex;
        while(l<r) {
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;
            l++;
            r--;
        }

        return new String(charArray);
    }
}
