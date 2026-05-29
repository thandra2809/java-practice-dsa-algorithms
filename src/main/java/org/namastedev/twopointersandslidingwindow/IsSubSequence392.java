package org.namastedev.twopointersandslidingwindow;

public class IsSubSequence392 {
    static void main() {
        String s = "abc";
        String t = "ahbgdc";

        char[] firstArray = s.toCharArray();
        char[] secondArray = t.toCharArray();

        int i = 0;
        int j = 0;

        while (j<secondArray.length) {
            if (firstArray[i] == secondArray[j]) {
                i++;
                j++;
            }else{
                j++;
            }
        }

        if(i!=firstArray.length){
            System.out.println("Not a subsequence");
        }else{
            System.out.println("Subsequence");
        }
    }
}
