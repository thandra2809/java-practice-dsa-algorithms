package org.dsa.practice.arrays;

import java.util.Arrays;

public class PrintMissingElements {
    static void main() {
        int[] array1 = {6, 7, 8,11,13,14,15,17,18};
        Arrays.sort(array1);

        int difference = array1[0];

        for (int j = 0; j < array1.length; j++) {
            if((array1[j] - j) != difference) {
                while(difference < (array1[j]-j)) {
                    System.out.printf("Missing element %d \n",j+difference);
                    difference++;
                }
            }
        }

    }

}
