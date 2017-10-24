package com.algorithm.training.dynamic_programming.partition_to_k_equal_sum_subsets;

import java.util.stream.IntStream;

public class Solution {
    int average;
    int[] nums;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean canPartitionKSubSets = false;
        int sum = IntStream.of(nums).sum();
        this.average = sum / 4;
        if(sum%k == 0) return canPartitionSubsets(new boolean[nums.length], -1, k);
        this.nums = nums;
        return canPartitionKSubSets;
    }
    public boolean canPartitionSubsets(boolean[] isVisited, int startPoint, int k) {
        boolean canPartitionKSubSets = false;
        for(int i = startPoint + 1; i < nums.length; i++) {
            if(nums[startPoint] + nums[i] < this.average) {
                
            }
        }
        return canPartitionKSubSets;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] nums = {4, 3, 2, 3, 5, 2, 1};
    	System.out.println(solution.canPartitionKSubsets(nums, 4)); //true
    }
}
