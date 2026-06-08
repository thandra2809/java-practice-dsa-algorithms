package org.capone.question_1_2_3_4;

import java.util.Arrays;

public class NonOverlappingIntervals_LC435 {
    static void main() {

        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};

        int totalNumberOfNonOverlaps =  eraseOverlapIntervals(intervals);
        System.out.println(totalNumberOfNonOverlaps);

        intervals = new int[][]{{1,2},{1,2},{1,2}};
        totalNumberOfNonOverlaps =  eraseOverlapIntervals(intervals);
        System.out.println(totalNumberOfNonOverlaps);

        intervals = new int[][]{{1,2},{2,3}};
        totalNumberOfNonOverlaps =  eraseOverlapIntervals(intervals);
        System.out.println(totalNumberOfNonOverlaps);

    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1]; // no overlap, keep it
            } else {
                count++; // overlap, remove it
            }
        }

        return count;

    }
}
