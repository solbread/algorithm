package com.algorithm.training.binary_search.upper_bound;

public class Solution {
	public int getUpperBound(int k, int[] nums) {
		int left = 0, right = nums.length;
		while(left < right) {
			int mid = (left + right) / 2;
			if(nums[mid] <= k) left = mid + 1;
			else right = mid;
		}
		return right;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.getUpperBound(7, new int[] {1,3,5,7,7})); //5
		System.out.println(solution.getUpperBound(6, new int[] {1,2,3,5,7,9,11,15})); //4
		System.out.println(solution.getUpperBound(7, new int[] {1,2,3,4,5})); //5
	}
}
