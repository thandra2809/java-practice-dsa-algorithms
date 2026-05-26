package org.namastedev.arrays;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber136 {
    static void main() {
        int[] nums = new int[]{4,1,2,1,2};
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int streamKey = map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);

        System.out.println(map);
        System.out.println(streamKey);


    }
}
