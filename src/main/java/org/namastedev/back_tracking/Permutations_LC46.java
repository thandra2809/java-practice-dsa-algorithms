package org.namastedev.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_LC46 {
    static void main() {
        List<List<Integer>> result = new ArrayList<>();
        result = permute(new int[]{1, 2, 3});
        System.out.println(result);

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    public static void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) { // add only at leaf
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip already used

            //used[i] = true;
            current.add(nums[i]);           // choose
            backtrack(nums, current, used, result); // explore
            current.remove(current.size() - 1);     // unchoose
            //used[i] = false;
        }
    }


}
