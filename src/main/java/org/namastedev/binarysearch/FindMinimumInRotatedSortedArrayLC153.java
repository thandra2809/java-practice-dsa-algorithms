package org.namastedev.binarysearch;

public class FindMinimumInRotatedSortedArrayLC153 {
    static void main() {

        int[] nums = new int[]{3,4,5,1,2};

        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1; // min is in RIGHT half
            } else {
                hi = mid; // min is at mid or in LEFT half
            }
        }

        System.out.println(nums[lo]);  // lo == hi → minimum found
        System.out.println(lo);

    }
}
