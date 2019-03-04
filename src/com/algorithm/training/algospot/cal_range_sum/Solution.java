package com.algorithm.training.partition_sum.cal_range_sum;

public class Solution {
	public int rageSum(int[] numbers, int i, int j) {
	    int[] partitionSum = new int[numbers.length];
	    for(int k = 0; k < partitionSum.length; k++) {
	        if(k == 0) partitionSum[k] = numbers[k];
	        else partitionSum[k] = partitionSum[k-1] + numbers[k]; 
	    }
	    if(i==0) return partitionSum[j];
	    return partitionSum[j] - partitionSum[i-1];
	} 
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.rageSum(new int[]{1,2,3,4}, 1, 2));
		System.out.println(solution.rageSum(new int[]{1,2,3,4}, 0, 2));
	}
}
