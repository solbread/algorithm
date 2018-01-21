package com.algorithm.training.sort.sort_colors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int num : nums) {
        	counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int arrayIdx = 0;
        for(int i = 0; i < 3; i++) {
        	int iterateCount = counter.getOrDefault(i, 0);
        	for(int j = 0; j < iterateCount; j++) {
        		nums[arrayIdx] = i;
        		arrayIdx++;
        	}
        }
//        System.out.println(Arrays.toString(nums));
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.sortColors(new int[] {1,0,2,2,1,2});
	}
}
