package com.algorithm.training.tree.longest_univalue_path;

import com.algorithm.training.etc.TreeNode;

public class Solution {
    public int longestUnivaluePath(TreeNode root) {
        int longestPathLength = 0;
        if(root.left != null && root.val == root.left.val) {
            longestPathLength += (1 + longestUnivaluePath(root.left));
        }
        if(root.right != null && root.val == root.right.val) {
            longestPathLength += (1 + longestUnivaluePath(root.right));
        }
        if(root.left != null && root.val != root.left.val) {
            longestPathLength = Math.max(longestPathLength, longestUnivaluePath(root.left));
        }
        if(root.right != null && root.val != root.right.val) {
            longestPathLength = Math.max(longestPathLength, longestUnivaluePath(root.right));
        }
        return longestPathLength;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
//        TreeNode root = new TreeNode(5); //2
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(1);
//        root.right.right = new TreeNode(5);
        
        TreeNode root = new TreeNode(1); //2
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        System.out.println(solution.longestUnivaluePath(root));
    }
}
