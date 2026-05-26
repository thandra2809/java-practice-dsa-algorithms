package org.namastedev.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    static void main() {

        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        int m=0;
        int n =1;


        int nums3[] = new int[m+n];

        int i = 0;
        int j = 0;
        int k = 0;


        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i];
                i++;
            }else {
                nums3[k] = nums2[j];
                j++;
            }
            k++;
        }

        for (; i < m; i++) {
            nums3[k] = nums1[i];
            k=k+1;
        }

        for (; j < n; j++) {
            nums3[k] = nums2[j];
            k=k+1;
        }

        nums1 = new int[nums3.length];
        for(int p=0;p<nums3.length;p++){
            nums1[p] = nums3[p];
        }


        System.out.println(Arrays.toString(nums1));


    }
}
