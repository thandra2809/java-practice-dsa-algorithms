package org.namastedev.greedyalgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    static void main() {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = arr[0];

        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.toString(current));


        for (int i = 1; i < arr.length; i++) {
           if (arr[i][0] <= current[1]) {
               current[1] = Math.max(current[1],arr[i][1]);
           }else {
               result.add(current);
               current = arr[i];
           }
        }

        result.add(current);
        System.out.println(Arrays.deepToString(result.toArray()));




    }
}
