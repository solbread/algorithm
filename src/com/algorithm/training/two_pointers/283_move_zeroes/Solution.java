package com.algorithm.training.two_pointers.move_zeroes;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while(left < nums.length && right < nums.length) {
        	if(nums[left] == 0) {
        		if(nums[right] == 0) {
        			right++;
        		} else {
        			swap(nums, left, right);
        			right = ++left;
        		}
        	} else {
        		right = ++left;
        	}
        }
    }
    
    private void swap(int[] nums, int left, int right) {
    	int tmp = nums[left];
    	nums[left] = nums[right];
    	nums[right] = tmp;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		
		int nums5[] = {0, 0, 0, 0, 0};
		solution.moveZeroes(nums5);
		System.out.println(Arrays.toString(nums5)); // 0, 0, 0, 0, 0
		
		int nums[] = {0, 1, 0, 3, 12};
		solution.moveZeroes(nums);
		System.out.println(Arrays.toString(nums)); // 1, 3, 12, 0, 0
		
		int nums2[] = {0, 0, 0, 1, 3, 12};
		solution.moveZeroes(nums2);
		System.out.println(Arrays.toString(nums2)); // 1, 3, 12, 0, 0
		
		int nums3[] = {1, 0, 0, 0, 3, 12};
		solution.moveZeroes(nums3);
		System.out.println(Arrays.toString(nums3)); // 1, 3, 12, 0, 0
				
		int nums4[] = {};
		solution.moveZeroes(nums4);
		System.out.println(Arrays.toString(nums4)); //
    }
}
