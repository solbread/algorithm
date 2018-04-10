package com.algorithm.contest.leetcode_20180408.c_largest_sum_of_averages;

public class Solution {
	int[] A;
	double[][] cache;
    public double largestSumOfAverages(int[] A, int K) {
        this.A = A;
        this.cache = new double[A.length+1][A.length+1];
        for(int i = 0; i < cache.length; i++) {
        	for(int j = 0; j < cache[i].length; j++) {
        		this.cache[i][j] = -1;
        	}
        }
        return dp(1, K-1, A[0], 1);
    }
    public double dp(int index, int K, int curGroupSum, int curGroupCnt) {
    	if(cache[index][K] != -1) return cache[index][K];
    	
    	if(index >= A.length) return (double)curGroupSum/curGroupCnt;
    	//create new group
    	double sum = Double.MIN_VALUE;
    	if(K > 0) {
    		sum = Math.max(sum, (double)curGroupSum/curGroupCnt + dp(index+1, K-1, A[index], 1));
    	}
    	
    	//not create new group
    	sum = Math.max(sum,dp(index+1, K, curGroupSum+A[index], curGroupCnt+1));
    	
    	return sum;
//    	cache[index][K] = sum;
//    	return cache[index][K];
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.largestSumOfAverages(new int[] {9,1,2,3,9}, 3)); //20
		System.out.println(solution.largestSumOfAverages(new int[] {1,2,3,4,5,6,7}, 4)); //20.5
	}
}
