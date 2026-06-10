package org.research;

public class TrappingRainwater {
    static void main() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;

        int totalTrappedWater = 0;


        while (left < right) {
            if(height[left] < height[right]) {
                if(height[left] >= maxLeft ) {
                    maxLeft = height[left];
                }else{
                    totalTrappedWater = totalTrappedWater + (maxLeft - height[left]);

                }
                left++;
            }else{
                if(height[right] >= maxRight) {
                    maxRight = height[right];
                }else{
                    totalTrappedWater = totalTrappedWater + (maxRight-height[right]);

                }
                right--;
            }
        }

        System.out.println(totalTrappedWater);

    }
}
