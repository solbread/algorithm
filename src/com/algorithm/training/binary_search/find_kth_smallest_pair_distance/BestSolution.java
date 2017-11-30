package com.algorithm.training.binary_search.find_kth_smallest_pair_distance;

import java.util.Arrays;

public class BestSolution {
    public int smallestDistancePair(int[] nums, int k) {
    	Arrays.sort(nums);
    	int left = nums[1]-nums[0], right = nums[nums.length-1]-nums[0];
    	for(int i = 2; i < nums.length; i++) {
    		left = Math.min(left, nums[i]-nums[i-1]);
    	}
    	while(left < right) {
    		int mid = left + (right - left) / 2;
    		if(countPairs(nums, mid) < k) {
    			left = mid + 1;
    		} else {
    			right = mid;
    		}
    	}
    	return left;
    }
    
    private int countPairs(int[] nums, int k) {
    	int count = 0;
    	for(int i = 0; i < nums.length; i++) {
    		count += (upperBound(nums, i, nums[i]+k) - i - 1);
    	}
    	return count;
    }
    
    private int upperBound(int nums[], int left, int k) {
    	int right = nums.length;
    	while(left < right) {
    		int mid = left + (right - left) / 2;
    		if(k >= nums[mid]) {
    			left = mid+1;
    		} else {
    			right = mid;
    		}
    	}
    	return left;
    }
    
    public static void main(String[] args) {
        BestSolution solution = new BestSolution();
        System.out.println(solution.smallestDistancePair(new int[] {1,3,1}, 1)); //0
        System.out.println(solution.smallestDistancePair(new int[] {62,100,4}, 2)); //58
    }
}
