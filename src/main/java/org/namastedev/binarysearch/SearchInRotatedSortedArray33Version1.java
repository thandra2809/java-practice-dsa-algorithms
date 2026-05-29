package org.namastedev.binarysearch;

import java.util.Arrays;

public class SearchInRotatedSortedArray33Version1 {
    static void main() {
        int[] nums = new int[]{1};
        int target = 2;

        if (nums.length > 1) {
            //first find the rotated position
            int left = 0;
            int right = nums.length - 1;
            int noOfRotations = 0;
            while (left <= right) {
                if (nums[left] >= nums[right]) {
                    noOfRotations++;
                    right--;
                } else {
                    break;
                }
            }

            // reverse the first half
            reverse(nums, 0, (noOfRotations));
            // reverse  the second half
            reverse(nums, (noOfRotations + 1), nums.length - 1);
            // reverse whole array
            reverse(nums, 0, nums.length - 1);
        }
        System.out.println(Arrays.toString(nums));

        int targetIndex = binarySearch(nums, target);
        System.out.println(targetIndex);

    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
