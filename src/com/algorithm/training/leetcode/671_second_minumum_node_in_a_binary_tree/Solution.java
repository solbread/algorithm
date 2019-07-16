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
		int leftValue = (leftNode == null) ? -1 : 
			(leftNode.val != this.rootValue ? leftNode.val : findSecondMinimumValue(leftNode.left, leftNode.right));
		int rightValue = (rightNode == null) ? -1 :
			(rightNode.val != this.rootValue ? rightNode.val : findSecondMinimumValue(rightNode.left, rightNode.right));
		if(leftValue != -1 && rightValue != -1) return Math.min(leftValue, rightValue);
		return Math.max(leftValue, rightValue);
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(solution.findSecondMinimumValue(root));
	}
}
