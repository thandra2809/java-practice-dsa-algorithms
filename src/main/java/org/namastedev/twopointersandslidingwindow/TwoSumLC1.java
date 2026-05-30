package org.namastedev.twopointersandslidingwindow;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumLC1 {
    static void main() {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] targetNumsIndexes = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                targetNumsIndexes[0] = map.getOrDefault(difference, 0);
                targetNumsIndexes[1] = i;
            } else {
                map.put(nums[i], i);
            }

        }

        System.out.println(Arrays.toString(targetNumsIndexes));


    }
}
