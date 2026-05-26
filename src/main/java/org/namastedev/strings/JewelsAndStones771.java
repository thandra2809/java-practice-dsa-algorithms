package org.namastedev.strings;

public class JewelsAndStones771 {
    static void main() {

        String jewels = "aA";
        String stones = "aAAbbbb";

        char[] jewelArray = jewels.toCharArray();
        char[] stonesArray = stones.toCharArray();

        int countOfJewels = 0;
        for (int i = 0; i < stonesArray.length; i++) {

            for (int j = 0; j < jewelArray.length; j++) {
                if (stonesArray[i] == jewelArray[j]) {
                    countOfJewels++;
                    break;
                }
            }

        }

        System.out.println(countOfJewels);



    }
}
