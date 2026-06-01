package org.namastedev.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TreePrinter — visualize any binary tree in the console.
 *
 * Usage:
 *   TreePrinter.print(root);       // tree diagram
 *   TreePrinter.levelOrder(root);  // level-by-level output
 */
public class TreePrinter {

    /**
     * Print tree as a visual diagram using ASCII art.
     *
     * Example output for [1,2,3,4,5]:
     *   └── 1
     *       ├── 2
     *       │   ├── 4
     *       │   └── 5
     *       └── 3
     */
    public static void print(TreeNode root) {
        if (root == null) {
            System.out.println("(empty tree)");
            return;
        }
        printHelper(root, "", false);
    }

    private static void printHelper(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) return;
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.val);
        printHelper(node.left,  prefix + (isLeft ? "│   " : "    "), true);
        printHelper(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    /**
     * Print all nodes level by level.
     *
     * Example output for [1,2,3]:
     *   Level 0: [1]
     *   Level 1: [2, 3]
     */
    public static void levelOrder(TreeNode root) {
        if (root == null) { System.out.println("(empty tree)"); return; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            StringBuilder sb = new StringBuilder("Level " + level + ": [");
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sb.append(node.val);
                if (i < size - 1) sb.append(", ");
                if (node.left  != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            sb.append("]");
            System.out.println(sb);
            level++;
        }
    }
}