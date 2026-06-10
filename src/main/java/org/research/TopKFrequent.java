package org.research;

import java.util.*;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: build frequency map
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.merge(n, 1, Integer::sum);
        }

        // Step 2: min-heap ordered by frequency (smallest freq at top)
        // so we keep only the top k frequent elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );

        // Step 3: push each element into heap, evict if size exceeds k
        for (int key : freqMap.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();   // remove least frequent
            }
        }

        // Step 4: build result array from heap
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    // ── Helper: print array ───────────────────────────────────────────────────
    static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        TopKFrequent sol = new TopKFrequent();

        // ── Test 1: basic case ────────────────────────────────────────────────
        int[] nums1 = {1, 1, 1, 2, 2, 3,1,1,2,3,3,3,4,};
        int k1 = 2;
        System.out.println("Test 1 — Basic case:");
        System.out.println("  nums     : " + arrayToString(nums1));
        System.out.println("  k        : " + k1);
        System.out.println("  Result   : " + arrayToString(sol.topKFrequent(nums1, k1)));
        System.out.println("  Expected : [1, 2]");
        System.out.println();
//
//        // ── Test 2: single element ────────────────────────────────────────────
//        int[] nums2 = {1};
//        int k2 = 1;
//        System.out.println("Test 2 — Single element:");
//        System.out.println("  nums     : " + arrayToString(nums2));
//        System.out.println("  k        : " + k2);
//        System.out.println("  Result   : " + arrayToString(sol.topKFrequent(nums2, k2)));
//        System.out.println("  Expected : [1]");
//        System.out.println();
//
//        // ── Test 3: all same frequency ────────────────────────────────────────
//        int[] nums3 = {1, 2, 3, 4};
//        int k3 = 2;
//        System.out.println("Test 3 — All same frequency:");
//        System.out.println("  nums     : " + arrayToString(nums3));
//        System.out.println("  k        : " + k3);
//        System.out.println("  Result   : " + arrayToString(sol.topKFrequent(nums3, k3)));
//        System.out.println("  Expected : any 2 elements");
//        System.out.println();



    }
}