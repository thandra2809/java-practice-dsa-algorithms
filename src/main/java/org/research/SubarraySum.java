package org.research;

import java.util.HashMap;

public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: prefix sum of 0 has occurred once (empty subarray)
        map.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for (int n : nums) {
            // Add current element to prefix sum
            prefixSum += n;

            // If (prefixSum - k) exists in map,
            // it means there is a subarray ending here with sum = k
            count += map.getOrDefault(prefixSum - k, 0);

            // Store current prefix sum in map
            map.merge(prefixSum, 1, Integer::sum);
        }

        return count;
    }

    // ── Helper: print array ───────────────────────────────────────────────────
    static String arrayToString(int[] nums) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i < nums.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SubarraySum sol = new SubarraySum();

        // ── Test 1: basic case ────────────────────────────────────────────────
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Test 1 — Basic case:");
        System.out.println("  nums     : " + arrayToString(nums1));
        System.out.println("  k        : " + k1);
        System.out.println("  Result   : " + sol.subarraySum(nums1, k1));
        System.out.println("  Expected : 2  → [1,1] at index 0-1 and 1-2");
        System.out.println();

        // ── Test 2: single element equals k ──────────────────────────────────
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Test 2 — Multiple subarrays:");
        System.out.println("  nums     : " + arrayToString(nums2));
        System.out.println("  k        : " + k2);
        System.out.println("  Result   : " + sol.subarraySum(nums2, k2));
        System.out.println("  Expected : 2  → [3] at index 2 and [1,2] at index 0-1");
        System.out.println();

        // ── Test 3: negative numbers ──────────────────────────────────────────
        int[] nums3 = {1, -1, 1, -1, 1};
        int k3 = 0;
        System.out.println("Test 3 — Negative numbers:");
        System.out.println("  nums     : " + arrayToString(nums3));
        System.out.println("  k        : " + k3);
        System.out.println("  Result   : " + sol.subarraySum(nums3, k3));
        System.out.println("  Expected : 4");
        System.out.println();

        // ── Test 4: no subarray found ─────────────────────────────────────────
        int[] nums4 = {1, 2, 3};
        int k4 = 7;
        System.out.println("Test 4 — No subarray found:");
        System.out.println("  nums     : " + arrayToString(nums4));
        System.out.println("  k        : " + k4);
        System.out.println("  Result   : " + sol.subarraySum(nums4, k4));
        System.out.println("  Expected : 0");
        System.out.println();

        // ── Test 5: single element equals k ──────────────────────────────────
        int[] nums5 = {5};
        int k5 = 5;
        System.out.println("Test 5 — Single element equals k:");
        System.out.println("  nums     : " + arrayToString(nums5));
        System.out.println("  k        : " + k5);
        System.out.println("  Result   : " + sol.subarraySum(nums5, k5));
        System.out.println("  Expected : 1");
        System.out.println();

        // ── Test 6: entire array is the subarray ──────────────────────────────
        int[] nums6 = {1, 2, 3, 4, 5};
        int k6 = 15;
        System.out.println("Test 6 — Entire array sums to k:");
        System.out.println("  nums     : " + arrayToString(nums6));
        System.out.println("  k        : " + k6);
        System.out.println("  Result   : " + sol.subarraySum(nums6, k6));
        System.out.println("  Expected : 1");
        System.out.println();

        // ── Test 7: all zeros ─────────────────────────────────────────────────
        int[] nums7 = {0, 0, 0, 0};
        int k7 = 0;
        System.out.println("Test 7 — All zeros:");
        System.out.println("  nums     : " + arrayToString(nums7));
        System.out.println("  k        : " + k7);
        System.out.println("  Result   : " + sol.subarraySum(nums7, k7));
        System.out.println("  Expected : 10  → every subarray sums to 0");
        System.out.println();

        // ── Summary ───────────────────────────────────────────────────────────
        System.out.println("=== Summary ===");
        System.out.printf("%-10s %-30s %-6s %-10s %-10s%n",
                "Test", "nums", "k", "Result", "Expected");
        System.out.println("------------------------------------------------------------------------");

        int[][]  allNums    = {nums1, nums2, nums3, nums4, nums5, nums6, nums7};
        int[]    allK       = {k1, k2, k3, k4, k5, k6, k7};
        String[] expected   = {"2", "2", "4", "0", "1", "1", "10"};

        for (int i = 0; i < allNums.length; i++) {
            System.out.printf("%-10s %-30s %-6d %-10s %-10s%n",
                    "Test " + (i + 1),
                    arrayToString(allNums[i]),
                    allK[i],
                    sol.subarraySum(allNums[i], allK[i]),
                    expected[i]);
        }
    }
}