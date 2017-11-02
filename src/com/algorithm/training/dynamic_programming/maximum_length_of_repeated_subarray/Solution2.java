package com.algorithm.training.dynamic_programming.maximum_length_of_repeated_subarray;

import java.util.Arrays;

public class Solution2 {
    int[][] cache;
    int[] A, B;
    public int findLength(int[] A, int[] B) {
        this.A = A;
        this.B = B;
        this.cache = new int[A.length+1][B.length+1];
        for(int[] subCache : this.cache) Arrays.fill(subCache, -1);
        return getFindMaxLength(A.length, B.length);
    }
    public int getFindMaxLength(int aIdx, int bIdx) {
        if(aIdx == A.length+1 || bIdx == B.length+1) return 0;
        if(cache[aIdx][bIdx] != -1) return cache[aIdx][bIdx];
        if(A[aIdx-1] == B[bIdx-1]) {
            return Math.max(1 + getFindMaxLength(aIdx+1, bIdx+1), Math.max(getFindMaxLength(aIdx+1, bIdx), getFindMaxLength(aIdx, bIdx+1)));
        }
        return Math.max(getFindMaxLength(aIdx+1, bIdx), getFindMaxLength(aIdx, bIdx+1));
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7})); //3
        System.out.println(solution.findLength(new int[]{0,0,0,0,0,0,1,0,0,0}, new int[]{0,0,0,0,0,0,0,1,0,0})); //9
    }
}
