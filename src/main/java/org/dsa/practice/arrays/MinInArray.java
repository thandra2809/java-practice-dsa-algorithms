package org.dsa.practice.arrays;

public class MinInArray {
    public static void main(String[] args) {
        int[] array = {5,7,9,1,34,154,67,89,100};

        System.out.println(minInArray(array));

    }

    public static int minInArray(int[] array) {
        int min = Integer.MAX_VALUE;
        if (array == null || array.length == 0) { return 0; }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}