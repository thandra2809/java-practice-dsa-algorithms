package org.capone.question_1_2_3_4;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArraysWithSUMK_LC560 {

    static void main() {
        int[] nums = {1,1,1};
        int k = 2;

        int numberOfSubArrays = subarraySum(nums, k);
        System.out.println(numberOfSubArrays);

    }


    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // one empty prefix with sum 0

        int count = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
