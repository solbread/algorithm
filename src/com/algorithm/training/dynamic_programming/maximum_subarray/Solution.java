package com.algorithm.training.dynamic_programming.maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
    	if(nums.length==0) return 0;
        int maxSum = nums[0], currentSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	currentSum = Math.max(currentSum+nums[i], nums[i]);
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
