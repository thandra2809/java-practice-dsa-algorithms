package org.namastedev.twopointersandslidingwindow;

public class ContainerWithMostWaterLC11 {
    static void main() {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int l = 0;
        int r = height.length-1;

        int maxArea = 0;

        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(area, maxArea);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(maxArea);


    }
}
