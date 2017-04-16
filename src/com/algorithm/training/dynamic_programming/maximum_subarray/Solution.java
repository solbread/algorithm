package com.algorithm.training.dynamic_programming.maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = 0, currentSum = 0;
        for(int num : nums) {
        	currentSum = Math.max(currentSum+num, num);
        	maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    
	public static void main(String[] args) {
		Solution solution = new Solution();
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(solution.maxSubArray(nums));
	}
}
