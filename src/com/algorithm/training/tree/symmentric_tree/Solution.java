package com.algorithm.training.tree.symmentric_tree;

import com.algorithm.training.etc.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
    	if(root==null) return true;
    	return check(root.left, root.right);
    }
    private boolean check(TreeNode node1, TreeNode node2) {
    	if(node1 == null || node2 == null) return node1==node2;
    	if(node1.val != node2.val) return false;
    	return check(node1.left, node2.right) && check(node1.right, node2.left);
    }
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(2);
    	root.left = new TreeNode(4);
    	root.right = new TreeNode(2);
		Solution solution = new Solution();
		System.out.println(solution.isSymmetric(root));
	}
}
