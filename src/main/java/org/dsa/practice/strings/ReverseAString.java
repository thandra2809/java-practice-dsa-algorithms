package org.dsa.practice.strings;

import java.util.Arrays;

public class ReverseAString {
    static void main() {

        String str = "python";

        String reversedString = reverseMethod1(str);
        System.out.println("******************************");
        System.out.println("The reversed String is:: " + reversedString);
        System.out.println("******************************");


        String reversedString2 = reverseMethod2WithExtraArray(str);
        System.out.println("******************************");
        System.out.println("The reversed String is:: " + reversedString2);
        System.out.println("******************************");

    }

    private static String reverseMethod2WithExtraArray(String str) {
        char[] charArray = str.toCharArray();
        char[] reversedArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            reversedArray[i] = charArray[charArray.length - i - 1];
        }
        return new String(reversedArray);
    }

    private static String reverseMethod1(String str) {
        char[] charArray = str.toCharArray();
        char temp;

        int i = 0;
        int j = charArray.length - 1;

        while (i < j) {
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
        return new String(charArray);

    }



}
