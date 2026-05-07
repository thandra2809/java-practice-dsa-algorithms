package org.dsa.practice.arrays;


import java.util.ArrayList;
import java.util.Arrays;

public class RotateArray {

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
        ArrayList<Integer> arr1 = new ArrayList<>();
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };

        int[] newArray = rotate(arr, arr.length);

        System.out.println(Arrays.toString(newArray));

    }
}