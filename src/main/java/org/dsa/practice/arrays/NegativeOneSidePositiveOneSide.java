package org.dsa.practice.arrays;

import java.util.Arrays;

public class NegativeOneSidePositiveOneSide {
    static void main() {
        int arr[] = {3, -1, 2, 4, 0, -9, -6, 2, 3, -10, 5, -7};

        System.out.println("The current array is " + Arrays.toString(arr));

        int[] swappedArray = swappedArray(arr);

        System.out.println("The swapped array is " + Arrays.toString(swappedArray));
    }

    private static int[] swappedArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            while (arr[i] < 0) {
                i++;
            }
            while (arr[j] > 0) {
                j--;
            }
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
