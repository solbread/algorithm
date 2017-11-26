package com.algorithm.training.binary_search.find_kth_smallest_pair_distance;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
    	Map<Integer, Integer> counter = new HashMap<>();
    	for(int i = 0; i < nums.length; i++) {
    		for(int j = i+1; j < nums.length; j++) {
    			counter.put(Math.abs(nums[j]-nums[i]), counter.getOrDefault(Math.abs(nums[j]-nums[i]), 0)+1);
    		}
    	}
        for(int diff : counter.keySet()) {
        	if(k <= counter.get(diff)) return diff;
        	k -= counter.get(diff);
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestDistancePair(new int[] {1,3,1}, 1)); //0
    }
}
