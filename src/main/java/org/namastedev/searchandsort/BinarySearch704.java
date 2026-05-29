package org.namastedev.searchandsort;

public class BinarySearch704 {
    static void main() {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 2;


        int low = 0;
        int high =nums.length-1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                System.out.println(mid);
            }else{
                System.out.println("Not found");
            }
            if (nums[mid] < target) {
                low = mid+1;
            }else  {
                high = mid-1;
            }
        }

    }
}
