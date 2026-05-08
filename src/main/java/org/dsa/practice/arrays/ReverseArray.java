package org.dsa.practice.arrays;


import java.util.Arrays;

public class ReverseArray {

    public static int[] rotate(int[] arr, int k) {

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };

        System.out.println("Original Array:: " +Arrays.toString(arr));

        int[] newArray = rotate(arr, arr.length);


        System.out.println("Reversed Array" + Arrays.toString(newArray));

    }
}