package org.namastedev.arrays;

import java.util.Arrays;

public class MoveZeros {
    static void main() {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        int insertPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[insertPosition];
                nums[insertPosition] = nums[i];
                nums[i] = temp;
                insertPosition++;
            }
        }

        System.out.println(Arrays.toString(nums));

    }
}
