package org.namastedev.twopointersandslidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumLC15 {
    static void main() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {  // this onwards 2 sum with corner conditions
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // if next number is duplicate of already compared number keep increasing or decreasing left right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }


            }

        }
        System.out.println(result);
        // return result;

    }
}
