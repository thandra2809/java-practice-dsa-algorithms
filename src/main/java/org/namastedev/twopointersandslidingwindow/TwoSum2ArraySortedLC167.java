package org.namastedev.twopointersandslidingwindow;

import java.util.Arrays;

public class TwoSum2ArraySortedLC167 {
    static void main() {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] targetNumIndexes = new int[2];

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {

            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                targetNumIndexes[0] = left;
                targetNumIndexes[1] = right;
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }


        }

        System.out.println(Arrays.toString(targetNumIndexes));
    }
}
