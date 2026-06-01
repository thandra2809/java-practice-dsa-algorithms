package org.namastedev.greedyalgos;

import java.util.Arrays;

public class MeetingIntervalsLC252 {
    static void main() {
        int[][] intervals1 = new int[][]{{5, 10},{0, 30},  {15, 20}};

        int[][] intervals2 = new int[][]{{7, 10}, {2, 4}};


        boolean canAttendMeetings = false;
        canAttendMeetings = checkMeetingOverlap(intervals1);


        canAttendMeetings = checkMeetingOverlap(intervals2);


    }

    private static boolean checkMeetingOverlap(int[][] intervals) {
        Arrays.sort(intervals,(interval1,interval2)->interval1[0]-interval2[0]);
        System.out.println(Arrays.deepToString(intervals));

        return false;

    }


}
