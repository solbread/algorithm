package com.algorithm.training.tree.longest_univalue_path;

import com.algorithm.training.etc.TreeNode;

public class Solution {
    public int longestUnivaluePath(TreeNode root) {
        int longestPathLength = 1;
        if(root.left != null && root.val == root.left.val) {
            longestPathLength += longestUnivaluePath(root.left);
        }
        if(root.right != null && root.val == root.right.val) {
        }
        return longestPathLength;
    }
}
