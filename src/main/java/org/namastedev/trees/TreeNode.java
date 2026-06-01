package org.namastedev.trees;
 
/**
 * Standard TreeNode definition — reuse this for ALL binary tree LC problems.
 * This matches LeetCode's TreeNode exactly.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
 
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val   = val;
        this.left  = left;
        this.right = right;
    }
}
 