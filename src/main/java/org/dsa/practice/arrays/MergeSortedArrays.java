package org.dsa.practice.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    static void main() {
        int[] firstArray = {1, 5, 7, 9, 18};
        int[] secondArray = {2, 6, 8, 9, 10};

        int[] mergedArray = new int[firstArray.length + secondArray.length];

        int i = 0;
        int j = 0;
        int k = 0;

        int m = firstArray.length;
        int n = secondArray.length;

        while (i < m && j < n) {
            if (firstArray[i] < secondArray[j]) {
                mergedArray[k] = firstArray[i];
                k++;
                i++;
            } else {
                mergedArray[k] = secondArray[j];
                k++;
                j++;

            }
        }
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

        // copy the leftover element
        while (i < m) {
            mergedArray[k] = firstArray[i];
            i++;
        }
        while (j < n) {
            mergedArray[k] = secondArray[j];
            j++;
        }

        System.out.println(Arrays.toString(mergedArray));
    }
}
