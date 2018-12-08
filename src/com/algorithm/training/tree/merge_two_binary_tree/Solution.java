package com.algorithm.training.tree.merge_two_binary_tree;

import com.algorithm.training.etc.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t2 != null) {
            t1 = (t1 == null) ? new TreeNode(0) : t1;
            t1.val += t2.val;
            mergeTrees(t1.left, t2.left);
            mergeTrees(t1.right, t2.right);
        }
        return t1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = new TreeNode(1);

        TreeNode result = solution.mergeTrees(treeNode, treeNode2);
        System.out.println(result);
    }
}
