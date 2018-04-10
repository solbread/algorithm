package com.algorithm.contest.leetcode_20180408.b_binary_tree_pruning;

import com.algorithm.training.etc.TreeNode;

public class Solution {
    public TreeNode pruneTree(TreeNode node) {
    	TreeNode curNode = null;
    	TreeNode left = node.left;
    	TreeNode right = node.right;
    	if(left != null) {
			left = pruneTree(node.left);
    	}
    	if(right != null) {
    		right = pruneTree(node.right);
    	}
    	if(left != null || right != null) {
    		curNode = new TreeNode(node.val);
    		curNode.left = left;
    		curNode.right = right;
    	} else if(left == null && right == null && node.val == 1) {
    		curNode = new TreeNode(node.val);
    	}
    	return curNode;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		solution.pruneTree(root);
//		System.err.println(treeNode);
	}
}
