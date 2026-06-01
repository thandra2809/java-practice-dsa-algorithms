package org.namastedev.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TreeBuilder — builds a binary tree from LeetCode array format.
 *
 * LeetCode array format:
 *   - Values are level-order (BFS order)
 *   - null means no node at that position
 *
 * Example: [1, null, 2, 3]
 *      1
 *       \
 *        2
 *       /
 *      3
 *
 * Usage:
 *   TreeNode root = TreeBuilder.build(new Integer[]{1, null, 2, 3});
 */
public class TreeBuilder {

    /**
     * Build a binary tree from a LeetCode-style Integer array.
     * Null values in the array represent missing nodes.
     */
    public static TreeNode build(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.poll();

            // assign left child
            if (i < arr.length) {
                if (arr[i] != null) {
                    node.left = new TreeNode(arr[i]);
                    queue.offer(node.left);
                }
                i++;
            }

            // assign right child
            if (i < arr.length) {
                if (arr[i] != null) {
                    node.right = new TreeNode(arr[i]);
                    queue.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }

    /**
     * Build from int array (no nulls) — useful for BST problems.
     * Example: TreeBuilder.build(new int[]{5, 3, 8, 1, 4})
     */
    public static TreeNode build(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Integer[] boxed = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) boxed[i] = arr[i];
        return build(boxed);
    }
}