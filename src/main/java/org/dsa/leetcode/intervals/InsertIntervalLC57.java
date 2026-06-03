package org.dsa.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervalLC57 {
    static void main() {
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};

        int[][] mergedIntervals = insertInterval(intervals, newInterval);

        System.out.println(Arrays.deepToString(mergedIntervals));


    }

    private static int[][] insertInterval(int[][] intervals, int[] newInterval) {

        int i = 0;
        int n = intervals.length;

        List<int[]> mergedIntervals = new ArrayList<int[]>();

        //        int[][] intervals =new int[][]{{1,3},{6,9}};
        //        int[] newInterval =new int[]{2,5};
        // first merge non -overlapping at beginning
        while (i < n && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        // merge overlapping intervals

        while (i < n && intervals[i][0] <=newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        mergedIntervals.add(newInterval);

        // merge non-overlapping at last
        while (i < n) {
            mergedIntervals.add(intervals[i]);
            i++;
        }


        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
