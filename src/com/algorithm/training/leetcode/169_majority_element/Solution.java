package com.algorithm.training.array.majority_element;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int num : nums) {
        	counter.put(num, counter.getOrDefault(num, 0)+1);
        	if(counter.get(num) > nums.length/2) return num;
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.majorityElement(new int[] {1,2,2})); //2
	}
}
