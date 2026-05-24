package org.dsa.practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubarraySumPrint {

    public static void printSubarrays(int[] nums, int k) {
        System.out.println("Subarrays with sum = " + k + ":");

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            List<Integer> sub = new ArrayList<>();

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sub.add(nums[j]);

                if (sum == k) {
                    System.out.println(sub);
                }
            }
        }
    }

    public static void main(String[] args) {
        printSubarrays(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7);
    }
}