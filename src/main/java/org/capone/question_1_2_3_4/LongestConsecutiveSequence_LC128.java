package org.capone.question_1_2_3_4;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_LC128 {
    static void main() {
       int lengthOfSequence = longestConsecutive(new int[]{100,4,200,1,3,2});
        System.out.println(lengthOfSequence);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < nums.length) {
            set.add(nums[i]);
            i++;
        }

        int maxLen = 0;


        int j = 0;
        while (j < nums.length) {
            int num = nums[j];

            // Only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int curr = num;
                int len  = 1;

                // Step 3: Count consecutive numbers
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }

                maxLen = Math.max(maxLen, len);
            }
            j++;
        }

        return maxLen;
    }
}
