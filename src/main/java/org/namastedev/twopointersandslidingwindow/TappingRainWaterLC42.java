package org.namastedev.twopointersandslidingwindow;

public class TappingRainWaterLC42 {
    static void main() {
        int[] height = new int[]{0,1,0,2} ; //,1,0,1,3,2,1,2,1};
        int l =0;
        int r=height.length-1;

        int maxL=0;
        int maxR=0;
        int water = 0;

        while(l<r){
            if(height[l]<height[r]) {
                if (height[l] >= maxL) {
                    maxL = height[l];
                }else{
                    water = water + (maxL-height[l]);
                }
                l++;
            }else{
                if (height[r] > maxR) {
                    maxR = height[r];
                }else{
                    water = water + (maxR-height[r]);
                }
                r--;
            }



        }


        System.out.println(water);




    }



}
