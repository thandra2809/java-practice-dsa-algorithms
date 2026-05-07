package org.dsa.practice.arrays;

public class MaxInArray {
    public static void main(String[] args) {
        int[] array = {5,7,9,11,34,154,67,89,100};

        System.out.println(maxInArray(array));

    }

    public static int maxInArray(int[] array) {
        int max = Integer.MIN_VALUE;
        if (array == null || array.length == 0) { return 0; }

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

}