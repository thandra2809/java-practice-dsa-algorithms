package org.capone.question_1_2_3_4;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK_LC325 {
    static void main() {

        int[] nums = new int[]{1, 1, 1};
        int k = 2;

        int maxLengthOfArray = maxSubArrayLen(nums, k);
        System.out.println(maxLengthOfArray);

    }

//    public static int subarraySum(int[] nums, int k) {
//        int sum = nums[0];
//        int left = 0;
//        int right = 0;
//        int maxLength = 0;
//        int arrSize = nums.length - 1;
//        int numberOfSubArrays = 0;
//
//        while (right < arrSize) {
//
//            while (left <= right && sum > k) {
//                sum = sum - nums[left];
//                left++;
//            }
//
//            if (sum == k) {
//                maxLength = Math.max(maxLength, right - left + 1);
//                numberOfSubArrays++;
//            }
//
//            right++;
//
//            if (right <= arrSize) {
//                sum = sum + nums[right];
//            }
//
//
//        }
//        System.out.println("Number of subarrays ******" +numberOfSubArrays);
//        return maxLength;
//
//    }

    public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefix sum 0 at index -1

        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // only store first occurrence (leftmost = longest)
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

}
