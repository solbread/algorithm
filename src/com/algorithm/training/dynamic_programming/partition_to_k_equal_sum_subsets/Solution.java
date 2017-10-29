package com.algorithm.training.dynamic_programming.partition_to_k_equal_sum_subsets;

import java.util.stream.IntStream;

public class Solution {
    int average;
    int[] nums;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean canPartitionKSubSets = false;
        int sum = IntStream.of(nums).sum();
        this.average = sum / k;
        this.nums = nums;
        
        if(sum%k == 0) {
            for(int i = 0; i < nums.length;i ++) {
                if(canPartitionSubsets(new boolean[nums.length], i, this.average, k)) return true;
            }
        }
        return canPartitionKSubSets;
    }
    
    public boolean canPartitionSubsets(boolean[] isVisited, int startPoint, int targetSum, int k) {
        if(startPoint != -1) isVisited[startPoint] = true;
        if(k == 0) return isAllVisited(isVisited);
        if(nums[startPoint] == targetSum) {
            if(canPartitionSubsets(isVisited, getNextTargetIndex(isVisited), average, k-1)) return true;
        }
        for(int i = startPoint+1; i < nums.length; i++) {
            if(!isVisited[i]) {
                if(nums[startPoint] + nums[i] == targetSum) {
                    isVisited[i] = true;
                    if(canPartitionSubsets(isVisited, getNextTargetIndex(isVisited), average, k-1)) return true;
                    isVisited[i] = false;
                } else if(nums[startPoint] + nums[i] < targetSum) {
                    if(canPartitionSubsets(isVisited, i, targetSum - nums[startPoint], k)) return true;
                }
            }
        }
        if(startPoint != -1)isVisited[startPoint] = false;
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
    	System.out.println(solution.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4)); //true
    	System.out.println(solution.canPartitionKSubsets(new int[]{5,2,5,5,5,5,5,5,5,5,5,5,5,5,5,3}, 15)); //true
    	System.out.println(solution.canPartitionKSubsets(new int[]{2,2,10,5,2,7,2,2,13}, 3)); //true
    }
}
