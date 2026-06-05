package org.namastedev.greedyalgos;

public class GasCostLC134 {

    static void main() {
      int[] gas = new int[]{1,2,3,4,5};
      int[] cost = new int[]{3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            totalGas += net;
            tank += net;

            // Tank went negative — stations [start..i] can't be the start
            if (tank < 0) {
                start = i + 1;  // try next station
                tank = 0;      // reset tank
            }
        }

        // If total gas < total cost, circuit is impossible
        return totalGas >= 0 ? start : -1;
    }

}
