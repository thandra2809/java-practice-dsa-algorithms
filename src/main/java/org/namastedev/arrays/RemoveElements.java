package org.namastedev.arrays;

import java.util.Arrays;

public class RemoveElements {
    static void main() {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;

        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val) {
                int temp = nums[pointer];
                nums[pointer] = nums[i];
                nums[i] = temp;
                pointer++;
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(pointer);


    }
}
