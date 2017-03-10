package com.algorithm.k_diff_pairs_in_an_array;

import java.util.HashMap;
import java.util.Map;

public class BestSolution {
	public int findPairs(int[] nums, int k) {
		if(nums.length == 0 && k < 0) return 0;
		Map<Integer, Integer> check = new HashMap<>();
		int pairCnt = 0;
		for(int num : nums) {
			check.put(num, check.getOrDefault(num, 0) + 1);
		}
		for(Integer key : check.keySet()) {
			if(k==0 && check.get(key) >= 2) pairCnt++;
			else if(k!=0 && check.containsKey(key+k)) pairCnt++;
		}
		return pairCnt;
	}
	
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {3, 1, 4, 1, 5};
		System.out.println(solution.findPairs(nums, 2));
	}
}
