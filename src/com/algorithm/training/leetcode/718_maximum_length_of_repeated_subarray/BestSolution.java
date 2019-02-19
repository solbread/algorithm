package com.algorithm.training.dynamic_programming.maximum_length_of_repeated_subarray;

public class BestSolution {
    public int findLength(int[] A, int[] B) {
    	int maxLength = 0;
    	int[][] dp = new int[A.length+1][B.length+1];
    	for(int i = 1; i <= A.length; i++) {
    		for(int j = 1; j <= B.length; j++) {
    			if(A[i-1] == B[j-1]) {
    				dp[i][j] = 1 + dp[i-1][j-1];
    				maxLength = Math.max(maxLength, dp[i][j]);
    			}
    		}
    	}
    	return maxLength;
    }
    public static void main(String[] args) {
        BestSolution solution = new BestSolution();
        System.out.println(solution.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7})); //3
        System.out.println(solution.findLength(new int[]{0,0,0,0,0,0,1,0,0,0}, new int[]{0,0,0,0,0,0,0,1,0,0})); //9
        System.out.println(solution.findLength(new int[]{0,1,1,1}, new int[]{1,0,1,0,1})); //2
    }
}
