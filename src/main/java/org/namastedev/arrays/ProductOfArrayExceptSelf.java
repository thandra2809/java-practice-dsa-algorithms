package org.namastedev.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    static void main() {

        int arr[] = {1, 2, 3, 4};

        int result[] = productOfArray(arr);

        System.out.println(Arrays.toString(result));

    }

    private static int[] productOfArray(int[] arr) {
        int n = arr.length;
        int[] prefixArray = new int[n];
        int[] suffixArray = new int[n];
        int[] resultArray = new int[n];

        // first calculate prefix array
        prefixArray[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixArray[i] = prefixArray[i - 1] * arr[i - 1];
        }

        System.out.println("Prefix array: " + Arrays.toString(prefixArray));

        suffixArray[n - 1] = 1;
        for (int i = n - 1; i > 0; i--) {
            suffixArray[i - 1] = suffixArray[i] * arr[i];
        }

        System.out.println("Suffix Array:" + Arrays.toString(suffixArray));

        for (int i = 0; i < n; i++) {
            resultArray[i] = prefixArray[i] * suffixArray[i];
        }

        return resultArray;
    }
}
