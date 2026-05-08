package org.dsa.practice.arrays;

import java.util.Arrays;

public class SetOperations {

    static void main() {
        int[] array1 = {2, 6, 10, 15, 25};
        int[] array2 = {3, 6, 10, 15, 20};

        System.out.println("First array is " + Arrays.toString(array1));
        System.out.println("Second array is " + Arrays.toString(array2));
        System.out.println("Union array is::" + Arrays.toString(unionOperation(array1, array2)));

        System.out.println("***************************************************");


    }

    public static int[] unionOperation(int[] array1, int[] array2) {

        int i = 0, j = 0, k = 0;

        int[] array3 = new int[array1.length + array2.length];

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                array3[k] = array1[i];

                i++;
            } else if (array1[i] > array2[j]) {
                array3[k] = array2[j];

                j++;
            } else {
                array3[k] = array1[i];

                i++;
                j++;
            }
            k++;
        }
        // Copy over the last remaining element in either

        while (i < array1.length) {
            array3[k] = array1[i];
            i++;
        }
        while (j < array2.length) {
            array3[k] = array2[j];
            j++;
        }

         // The result array should be equal to k+1
         int[] result = new int[++k];

        int m=0;
        while (m < result.length) {
            result[m] = array3[m];
            m++;
        }

        return result;
    }

    public static int[] intersectionOperation(int[] array1, int[] array2) {
        return array1;
    }

    public static int[] minusOperation(int[] array1, int[] array2) {
        return array1;
    }
}
