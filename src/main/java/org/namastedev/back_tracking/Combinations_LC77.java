package org.namastedev.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations_LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k,
                           List<Integer> current,
                           List<List<Integer>> result) {
        // Base case: combination is complete
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Pruning: only iterate if enough numbers remain
        // need = k - current.size() slots to fill
        // available = n - i + 1 numbers from i to n
        // condition: available >= need  →  i <= n - (k - current.size()) + 1
        int need = k - current.size();
        for (int i = start; i <= n - need + 1; i++) {
            current.add(i);                        // choose
            backtrack(i + 1, n, k, current, result); // explore
            current.remove(current.size() - 1);    // un-choose
        }
    }
}
