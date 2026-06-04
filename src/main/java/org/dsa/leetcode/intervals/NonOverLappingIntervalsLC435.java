package org.dsa.leetcode.intervals;

import java.util.Arrays;

public class NonOverLappingIntervalsLC435 {
    static void main() {
        int erasedIntervals = 0;
        erasedIntervals = eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}});
        System.out.println(erasedIntervals);
    }


    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        System.out.println("intervals = " + Arrays.deepToString(intervals));

        int kept = 1;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) {
                kept++;
                lastEnd = intervals[i][1];
            }
        }

        return intervals.length - kept;


    }
}
