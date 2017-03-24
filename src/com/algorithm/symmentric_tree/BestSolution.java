package com.algorithm.symmentric_tree;

import java.util.Stack;

import com.algorithm.etc.TreeNode;

public class BestSolution {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		if(root.left == null || root.right == null) return (root.left==root.right);
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.left);
		stack.push(root.right);
		while(!stack.isEmpty()) {
			TreeNode right = stack.pop();
			TreeNode left = stack.pop();
			if(right.val != left.val) return false;
			stack.push(left.left);
			stack.push(right.right);
			stack.push(left.right);
			stack.push(right.left);
		}
		return true;
	}
	public static void main(String[] args) {
    	TreeNode root = new TreeNode(2);
    	root.left = new TreeNode(4);
    	root.right = new TreeNode(2);
    	BestSolution solution = new BestSolution();
		System.out.println(solution.isSymmetric(root));
	}
}
