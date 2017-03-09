package com.algorithm.k_diff_pairs_in_an_array;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findPairs(int[] nums, int k) {
        Set<String> checkDuplicate = new HashSet<>();
        int pairCount = 0;
        for(int i = 0; i < nums.length; i++) {
        	for(int j = i+1; j < nums.length; j++) {
        		if(Math.abs(nums[i]-nums[j]) == k && checkDuplicate.add(nums[i]+","+nums[j]) && (nums[i]==nums[j] || checkDuplicate.add(nums[j]+","+nums[i]))) {
        			pairCount++;
        		}
        	}
        }
        return pairCount;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {3, 1, 4, 1, 5};
		System.out.println(solution.findPairs(nums, 2));
	}
}
