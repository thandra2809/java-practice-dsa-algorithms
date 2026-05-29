package org.namastedev.binarysearch;

public class SearchInRotatedSortedArray33Version2 {
    static void main() {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 6)); // 2
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
    }


    private static int search(int[] nums, int target) {

        // Step 1: find pivot (index of minimum element)
        int pivot = findPivot(nums);
        System.out.println("Pivot index: " + pivot); // 4

        // Step 2: binary search on LEFT half [0, pivot-1]
        int leftResult = binarySearch(nums, 0, pivot - 1, target);
        if (leftResult != -1) return leftResult;

        // Step 3: binary search on RIGHT half [pivot, n-1]
        return binarySearch(nums, pivot, nums.length - 1, target);
    }


    private static int findPivot(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1; // min is in right half
            } else {
                hi = mid;     // min is in left half or at mid
            }
        }
        return lo; // pivot index
    }

    private static int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
