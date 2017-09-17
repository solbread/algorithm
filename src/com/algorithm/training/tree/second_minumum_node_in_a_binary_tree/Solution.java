package com.algorithm.training.tree.second_minumum_node_in_a_binary_tree;

import com.algorithm.training.etc.TreeNode;

public class Solution {
	private int rootValue;
	public int findSecondMinimumValue(TreeNode root) {
		this.rootValue = root.val;
		return findSecondMinimumValue(root.left, root.right);
	}

	private int findSecondMinimumValue(TreeNode leftNode, TreeNode rightNode) {
		if(leftNode == null && rightNode ==null) return -1;
		if(leftNode == null) {
			if(rightNode.val != this.rootValue) return rightNode.val;
			return findSecondMinimumValue(rightNode.left, rightNode.right);
		} else if(rightNode == null) {
			if(leftNode.val != this.rootValue) return  leftNode.val;
			return findSecondMinimumValue(leftNode.left, leftNode.right);
		} else {
			if(leftNode.val != this.rootValue || rightNode.val != this.rootValue) return Math.max(leftNode.val, rightNode.val);
			return Math.min(findSecondMinimumValue(leftNode.left, leftNode.right), 
					findSecondMinimumValue(rightNode.left, rightNode.right));
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root = null;
		System.out.println(solution.findSecondMinimumValue(root));
	}
}
