package com.algorithm.training.tree.longest_univalue_path;

import com.algorithm.training.etc.TreeNode;

public class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        Solution solution = new Solution();
        return solution.getLongestPath(root, 0);
    }
    private int getLongestPath(TreeNode root, int prevPathType) {
        int longestPathLength = 0;
        if(root.left != null && root.val == root.left.val && (prevPathType == 0 || prevPathType == 1)) {
            longestPathLength += (1 + getLongestPath(root.left, 1));
        }
        if(root.right != null && root.val == root.right.val && (prevPathType == 0 || prevPathType == 2)) {
            longestPathLength += (1 + getLongestPath(root.right, 2));
        }
        if(root.left != null && root.val != root.left.val) {
            longestPathLength = Math.max(longestPathLength, getLongestPath(root.left, 0));
        }
        if(root.right != null && root.val != root.right.val) {
            longestPathLength = Math.max(longestPathLength, getLongestPath(root.right, 0));
        }
        return longestPathLength;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root = new TreeNode(5); //2
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        
//        TreeNode root = new TreeNode(1); //2
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(5);
        
        System.out.println(solution.longestUnivaluePath(root));
    }
}
