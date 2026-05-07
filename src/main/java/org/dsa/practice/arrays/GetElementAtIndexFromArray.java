package org.dsa.practice.arrays;

public class GetElementAtIndexFromArray {

    public static void main(String[] args) {
        int[] array = {5,7,9,11,34,154,67,89,100};

        System.out.println(getElementAtIndexFromArray(array,5));

    }

    private static int getElementAtIndexFromArray(int[] array,int index) {
        if(index>=0 && index<array.length) {
            return array[index];
        }
        return -1;
    }


}