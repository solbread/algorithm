package com.algorithm.training.math.rectangle_overlap;

public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec1[3] <= rec2[1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3})); //true
        System.out.println(solution.isRectangleOverlap(new int[]{0,0,1,1}, new int[]{1,0,2,1})); //false
    }
}
