package org.namastedev.trees;

import java.util.*;

//// Node class representing each tree node
//class TreeNode {
//    int val;
//    TreeNode left, right;
//
//    TreeNode(int val) {
//        this.val = val;
//        this.left = null;
//        this.right = null;
//    }
//}

// Binary Tree class with build and traversal logic
class BinaryTree {

    TreeNode root;

    // Build the tree by inserting nodes in level-order (BFS style)
    public void insert(int val) {
        TreeNode newNode = new TreeNode(val);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Iterative Preorder Traversal: Root -> Left -> Right
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        // Stack to simulate recursion
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            // Visit the current node (Root)
            result.add(current.val);

            // Push RIGHT first so LEFT is processed first (LIFO)
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }
}

// Main class to test
public class PreorderTraversal {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        // Insert values: builds tree level by level
        // Result:
        //         1
        //       /   \
        //      2     5
        //     / \   / \
        //    3   4 6   7

        int[] values = {1, 2, 5, 3, 4, 6, 7};
        for (int val : values) {
            tree.insert(val);
        }

        // Run iterative preorder traversal
        List<Integer> result = tree.preorderTraversal(tree.root);

        // Print result
        System.out.println("Preorder Traversal (Root → Left → Right):");
        System.out.println(result);
        // Expected: [1, 2, 3, 4, 5, 6, 7]
    }
}