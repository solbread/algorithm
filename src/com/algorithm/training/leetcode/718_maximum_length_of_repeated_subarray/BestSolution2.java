package com.algorithm.training.dynamic_programming.maximum_length_of_repeated_subarray;

public class BestSolution2 {
    public int findLength(int[] A, int[] B) {
    	int maxLength = 0;
    	int[] dp = new int[B.length+1];
    	for(int i = 1; i <= A.length; i++) {
    		for(int j = B.length; j > 0; j--) {
    			dp[j] = (A[i-1] == B[j-1]) ? 1 + dp[j-1] : 0;
    			maxLength = Math.max(maxLength, dp[j]);
    		}
    	}
    	return maxLength;
    }
    public static void main(String[] args) {
        BestSolution2 solution = new BestSolution2();
        System.out.println(solution.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7})); //3
        System.out.println(solution.findLength(new int[]{0,0,0,0,0,0,1,0,0,0}, new int[]{0,0,0,0,0,0,0,1,0,0})); //9
        System.out.println(solution.findLength(new int[]{0,1,1,1}, new int[]{1,0,1,0,1})); //2
        System.out.println(solution.findLength(new int[]{1,0,0,0,1}, new int[]{1,0,0,1,1})); //3
    }
}
