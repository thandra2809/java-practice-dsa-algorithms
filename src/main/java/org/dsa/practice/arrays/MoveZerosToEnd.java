package org.dsa.practice.arrays;

import java.util.Arrays;

public class MoveZerosToEnd {

    static void main() {
        int[] firstArray = {0,1,0,3,12};

        int[] resultantArray = moveZerosToEnd(firstArray);

        System.out.println();
        System.out.println(Arrays.toString(resultantArray));
    }

    private static int[] moveZerosToEnd(int[] nums) {
        if (nums == null || nums.length == 0) { return new int[0]; }

        int insertPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp         = nums[insertPosition];
                nums[insertPosition]  = nums[i];
                nums[i]          = temp;
                insertPosition++;
            }
        }

        return nums;
    }
}
