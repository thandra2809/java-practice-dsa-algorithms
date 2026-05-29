package org.namastedev.strings;

public class LargestOdd {
    static void main() {

        String num = "678889";
        String largestOdd = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 != 0) {
                largestOdd = num.substring(0, i + 1);
                break;
            }else{
                largestOdd =  "";
            }
        }

        System.out.println(largestOdd);

    }
}
