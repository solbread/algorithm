package com.algorithm.training.binary_search.lower_bound;

public class Solution {
	public int getLowerBound(int k, int[] nums) {
		int left = 0, right = nums.length;
		while(left < right) {
			int mid = (left + right) / 2;
			if(nums[mid] < k) left = mid + 1;
			else right = mid;
		}
		return right;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.getLowerBound(7, new int[] {1,3,5,7,7})); //3
		System.out.println(solution.getLowerBound(6, new int[] {1,2,3,5,7,9,11,15})); //4
		System.out.println(solution.getLowerBound(7, new int[] {1,2,3,4,5})); //5
	}
}
