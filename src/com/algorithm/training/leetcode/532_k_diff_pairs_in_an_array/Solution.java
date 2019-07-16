package com.algorithm.training.two_pointers.k_diff_pairs_in_an_array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findPairs(int[] nums, int k) {
        Set<String> checkDuplicate = new HashSet<>();
        int pairCount = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
        	for(int j = i+1; j < nums.length && nums[j]-nums[i]<=k; j++) {
        		if((nums[j]-nums[i])==k && checkDuplicate.add(nums[i]+","+nums[j])) {
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
