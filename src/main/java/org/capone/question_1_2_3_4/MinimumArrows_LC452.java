package org.capone.question_1_2_3_4;

import java.util.Arrays;

public class MinimumArrows_LC452 {
    static void main() {

        int[][] points = new int[][]{{1,2},{2,3},{3,4},{4,5}};
        System.out.println(findMinArrowShots(points));

    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] - b[1]);

        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }

}
