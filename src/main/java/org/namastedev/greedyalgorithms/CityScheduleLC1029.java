package org.namastedev.greedyalgorithms;

import java.util.Arrays;

public class CityScheduleLC1029 {
    static void main() {

        int totalCost = twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}});
        System.out.println(totalCost);

    }

    public static int twoCitySchedCost(int[][] costs) {
        // Sort by difference: how much cheaper is city A vs city B
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        System.out.println(Arrays.deepToString(costs));

        int total = 0;
        int n = costs.length / 2;

        // First n people → city A (cheapest to send to A)
        for (int i = 0; i < n; i++) {
            total += costs[i][0];
        }

        // Last n people → city B (cheapest to send to B)
        for (int i = n; i < costs.length; i++) {
            total += costs[i][1];
        }

        return total;
    }
}
