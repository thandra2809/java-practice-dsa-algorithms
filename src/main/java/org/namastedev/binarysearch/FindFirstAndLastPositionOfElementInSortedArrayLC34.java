package org.namastedev.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindFirstAndLastPositionOfElementInSortedArrayLC34 {

    static void main() {
        System.out.println(findOccurrences(new int[]{5, 7, 7, 8, 8, 10}, 8)); // [3, 4]
        System.out.println(findOccurrences(new int[]{5, 7, 7, 8, 8, 10}, 7)); // [1, 2]
        System.out.println(findOccurrences(new int[]{5, 7, 7, 8, 8, 10}, 6)); // []
        System.out.println(findOccurrences(new int[]{1, 1, 1, 1, 1}, 1)); // [0, 1, 2, 3, 4]
        System.out.println(findOccurrences(new int[]{}, 0)); // []
    }

    private static List<Integer> findOccurrences(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();

        if (nums.length == 0) return result;

        // Step 1: find first occurrence using binary search
        int first = findFirst(nums, target);

        // target not found at all
        if (first == -1) return result;

        // Step 2: find last occurrence using binary search
        int last = findLast(nums, target);

        // Step 3: collect all indices from first to last
        for (int i = first; i <= last; i++) {
            result.add(i);
        }

        return result;
    }

    // Find FIRST (leftmost) position
    private static int findFirst(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                result = mid;
                hi = mid - 1; // keep searching LEFT
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }

    // Find LAST (rightmost) position
    private static int findLast(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                result = mid;
                lo = mid + 1; // keep searching RIGHT
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }


}