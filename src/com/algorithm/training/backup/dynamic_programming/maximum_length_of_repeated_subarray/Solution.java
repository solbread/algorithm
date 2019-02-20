package com.algorithm.training.dynamic_programming.maximum_length_of_repeated_subarray;

import java.util.Arrays;

public class Solution {
    int[][] overlapCache, lengthCache;
    int[] A, B;
    public int findLength(int[] A, int[] B) {
        this.A = A;
        this.B = B;
        this.overlapCache = new int[A.length][B.length];
        this.lengthCache = new int[A.length][B.length];
        for(int i = 0; i < A.length; i++) {
            Arrays.fill(this.overlapCache[i], -1);
            Arrays.fill(this.lengthCache[i], -1);
        }
        return getFindMaxLength(0, 0);
    }
    public int getFindMaxLength(int aIdx, int bIdx) {
        if(aIdx == A.length || bIdx == B.length) return 0;
        if(lengthCache[aIdx][bIdx] != -1) return lengthCache[aIdx][bIdx];
        if(A[aIdx] == B[bIdx]) {
            lengthCache[aIdx][bIdx] = Math.max(calOverlapLength(aIdx, bIdx), Math.max(getFindMaxLength(aIdx + 1, bIdx), getFindMaxLength(aIdx, bIdx+1)));
        } else {
            lengthCache[aIdx][bIdx] = Math.max(getFindMaxLength(aIdx + 1, bIdx), getFindMaxLength(aIdx, bIdx+1));
        }
        return lengthCache[aIdx][bIdx];
    }
    private int calOverlapLength(int aIdx, int bIdx) {
        if(aIdx == A.length || bIdx == B.length) return 0;
        if(overlapCache[aIdx][bIdx] != -1) return overlapCache[aIdx][bIdx];
        int overlapLength = 0;
        if(A[aIdx]==B[bIdx]) overlapLength = 1 + calOverlapLength(aIdx+1, bIdx+1);
        overlapCache[aIdx][bIdx] = overlapLength;
        return overlapCache[aIdx][bIdx];
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7})); //3
    	System.out.println(solution.findLength(new int[]{0,0,0,0,0,0,1,0,0,0}, new int[]{0,0,0,0,0,0,0,1,0,0})); //9
    }
}
