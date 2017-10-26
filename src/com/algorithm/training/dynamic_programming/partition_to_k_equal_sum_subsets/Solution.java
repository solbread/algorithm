package com.algorithm.training.dynamic_programming.partition_to_k_equal_sum_subsets;

import java.util.stream.IntStream;

public class Solution {
    int average;
    int[] nums;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean canPartitionKSubSets = false;
        int sum = IntStream.of(nums).sum();
        this.average = sum / 4;
        this.nums = nums;
        if(sum%k == 0) return canPartitionSubsets(new boolean[nums.length], -1, this.average, k+1);
        return canPartitionKSubSets;
    }
    public boolean canPartitionSubsets(boolean[] isVisited, int startPoint, int targetSum, int k) {
        if(startPoint != -1) isVisited[startPoint] = true;
        if(k==0) return isAllVisited(isVisited);
        for(int i = startPoint + 1; i < nums.length; i++) {
            if(startPoint == -1 || nums[startPoint] + nums[i] == targetSum) {
                isVisited[i] = true;
                if(canPartitionSubsets(isVisited, getNextTargetIndex(isVisited), average, k-1)) return true;;
                isVisited[i] = false;
            } else if(nums[startPoint] + nums[i] < targetSum) {
                if(canPartitionSubsets(isVisited, i, targetSum - nums[startPoint] - nums[i], k)) return true;
            }
        }
        if(startPoint != -1) isVisited[startPoint] = false;
        return false;
    }
    
    private boolean isAllVisited(boolean[] isVisited) {
        for(boolean v : isVisited) {
            if(!v) return false;
        }
        return true;
    }
    
    private int getNextTargetIndex(boolean isVisited[]) {
        int index = -1;
        for(int i = 0; i < isVisited.length; i++) {
            if(!isVisited[i]) {
                return i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] nums = {4, 3, 2, 3, 5, 2, 1};
    	System.out.println(solution.canPartitionKSubsets(nums, 4)); //true
    }
}
