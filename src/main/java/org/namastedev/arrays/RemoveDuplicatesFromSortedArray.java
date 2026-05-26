package org.namastedev.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {


    static void main() {

        int[] nums = new int[]{1, 2, 2, 3, 3, 3, 4, 5, 6, 6, 7};
        int uP = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[uP]) {
                uP = uP + 1;
                nums[uP] = nums[i];
            }
        }

        System.out.println(uP);
        System.out.println(Arrays.toString(nums));

    }

}
