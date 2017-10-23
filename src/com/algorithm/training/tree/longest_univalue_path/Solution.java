package com.algorithm.training.tree.longest_univalue_path;

import com.algorithm.training.etc.TreeNode;

public class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        int longestPathLength = 0;
        if(root.left != null && root.val == root.left.val) {
            longestPathLength += (1 + getLongestSubPath(root.left));
        }
        if(root.right != null && root.val == root.right.val) {
            longestPathLength += (1 + getLongestSubPath(root.right));
        }
        longestPathLength = Math.max(longestPathLength, longestUnivaluePath(root.left));
        longestPathLength = Math.max(longestPathLength, longestUnivaluePath(root.right));
        return longestPathLength;
    }
    private int getLongestSubPath(TreeNode subRoot) {
        int tmpLength1 = 0, tmpLength2 = 0;
        if(subRoot.left != null && subRoot.val == subRoot.left.val) {
            tmpLength1 = 1 + getLongestSubPath(subRoot.left);
        }
        if(subRoot.right != null && subRoot.val == subRoot.right.val) {
            tmpLength2 = 1 + getLongestSubPath(subRoot.right);
        }
        return Math.max(tmpLength1, tmpLength2);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(5); //2
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(1); //2
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(5);

        TreeNode root3 = new TreeNode(5); //2
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(5);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(1);
        root3.right.left = new TreeNode(5);

        TreeNode root4 = new TreeNode(5); //2
        root4.left = new TreeNode(4);
        root4.right = new TreeNode(5);
        root4.left.left = new TreeNode(1);
        root4.left.right = new TreeNode(1);
        root4.right.left = new TreeNode(5);
        root4.right.right = new TreeNode(5);
        root4.right.left.left = new TreeNode(4);
        root4.right.left.right = new TreeNode(2);
        root4.right.left.left.left = new TreeNode(4);

        TreeNode root5 = new TreeNode(5); //3
        root5.left = new TreeNode(4);
        root5.right = new TreeNode(5);
        root5.left.left = new TreeNode(1);
        root5.left.right = new TreeNode(1);
        root5.right.left = new TreeNode(5);
        root5.right.right = new TreeNode(5);
        root5.right.left.left = new TreeNode(4);
        root5.right.left.right = new TreeNode(2);
        root5.right.left.left.left = new TreeNode(4);
        root5.right.left.left.left.left = new TreeNode(4);
        root5.right.left.left.left.left.right = new TreeNode(4);

        System.out.println(solution.longestUnivaluePath(root));
        System.out.println(solution.longestUnivaluePath(root2));
        System.out.println(solution.longestUnivaluePath(root3));
        System.out.println(solution.longestUnivaluePath(root4));
        System.out.println(solution.longestUnivaluePath(root5));
    }
}
