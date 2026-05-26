package org.namastedev.arrays;

public class MaxConsecutiveOnes485 {

    static void main() {

        int[] nums = new int[]{1,1,0,1,1,1,0,1,1,0,1,1,1,1};


        int currentCount = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount++;
            }

            if(nums[i] != 1){
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }

        // should apply math max at last because it can be that last counter is the max one.
        maxCount = Math.max(maxCount, currentCount);
        System.out.println(currentCount);
        System.out.println(maxCount);


    }

}
