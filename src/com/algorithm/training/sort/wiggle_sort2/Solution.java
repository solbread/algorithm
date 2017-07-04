package com.algorithm.training.sort.wiggle_sort2;

public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
        	for (int j = i+1; j < nums.length; j++) {
        		if(i%2 == 1) {
        			if(nums[i-1] < nums[i]) break;
        			
        		} else {
        			
        		}
        	}
        }
    	printArr(nums);
    }
    private void printArr(int nums[]) {
    	for (int num : nums) {
    		System.out.print(num + " ");
    	}
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1, 5, 1, 1, 6, 4};
		solution.wiggleSort(nums);
	}
}
