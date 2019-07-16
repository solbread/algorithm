package com.algorithm.training.trie.maximum_xor_of_two_numbers_in_an_array;

import java.util.HashSet;
import java.util.Set;

public class BestSolution {
	public int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;
		Set<Integer> set;
		for(int i = 31; i >=0; i--) {
			set = new HashSet<>();
			mask |= (1<<i);
			for(int num : nums) {
				set.add(num&mask);
			}
			int tmp = max|(1<<i);
			for(int num : set) {
				if(set.contains(tmp^num)) {
					max = tmp;
					break;
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {3, 10, 5, 25, 2, 8};
		System.out.println(solution.findMaximumXOR(nums)); //28
	}
}
