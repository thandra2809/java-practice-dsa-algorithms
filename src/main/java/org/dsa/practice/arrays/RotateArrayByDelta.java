package org.dsa.practice.arrays;

import java.util.Arrays;

public class RotateArrayByDelta {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("Original Array:: " + Arrays.toString(arr));
        int[] newArray = rotate(arr, 7);


        System.out.println("Rotated Array" + Arrays.toString(newArray));
    }
    public static int[] rotate(int[] arr, int noOfPositionsToRotate) {

        int n = arr.length;
        noOfPositionsToRotate %= n;

        // Storing rotated version of array
        int[] temp = new int[n];

        // Copy last d elements to the front of temp
        for (int i = 0; i < noOfPositionsToRotate; i++)
            temp[i] = arr[n - noOfPositionsToRotate + i];

        // Copy the first n - d elements to the back of temp
        for (int i = 0; i < n - noOfPositionsToRotate; i++)
            temp[i + noOfPositionsToRotate] = arr[i];

        // Copying the elements of temp in arr to get the
        // final rotated array
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];

    return arr;

    }
}
