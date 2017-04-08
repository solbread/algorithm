package com.algorithm.training.trie.maximum_xor_of_two_numbers_in_an_array;

public class Solution {
	public int findMaximumXOR(int[] nums) {
		Object[] root = {null, null};
		for(int num : nums) {
			Object[] current = root;
			for(int i = 31; i >= 0; i --) {
				int bit = (num>>i)&1;
				if(current[bit]==null) {
					current[bit] = new Object[]{null, null};
				}
				current = (Object[]) current[bit];
			}
		}
		int maximumXor = 0;
		for(int num : nums) {
			int currentMaximumXor = 0;
			Object[] current = root;
			for(int i = 31; i >=0; i--) {
				int bit = (num>>i)&1;
				if(current[bit^1]==null) {
					current = (Object[]) current[bit];
				} else {
					currentMaximumXor += (1<<i);
					current = (Object[]) current[bit^1];
				}
			}
			maximumXor = Math.max(maximumXor,currentMaximumXor);
		}
		return maximumXor;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {3, 10, 5, 25, 2, 8};
		System.out.println(solution.findMaximumXOR(nums)); //28
	}
}
