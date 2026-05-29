package org.namastedev.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindClosestKLC658 {

    static void main() {
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));  // [1,2,3,4]
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1)); // [1,2,3,4]
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 5));  // [2,3,4,5]
        System.out.println(findClosestElements(new int[]{1, 3, 5, 7, 9}, 3, 6));  // [3,5,7]
    }

    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - k; // window of size k slides within this range

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            // compare distances of left and right ends of window
            if (x - arr[mid] > arr[mid + k] - x) {
                lo = mid + 1; // right end is closer → slide window RIGHT
            } else {
                hi = mid;     // left end is closer  → slide window LEFT
            }
        }

        // collect k elements starting from lo
        List<Integer> result = new ArrayList<>();
        for (int i = lo; i < lo + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
