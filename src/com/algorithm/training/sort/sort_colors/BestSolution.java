package com.algorithm.training.sort.sort_colors;

import java.util.Arrays;

@SuppressWarnings("unused")
public class BestSolution {
    public void sortColors(int[] nums) {
    	int index0 = -1, index1 = -1, index2 = -1;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] == 0) {
    			nums[++index2] = 2; nums[++index1] = 1; nums[++index0] = 0;
    		} else if(nums[i] == 1) {
    			nums[++index2] = 2; nums[++index1] = 1;
    		} else if(nums[i] == 2) {
    			nums[++index2] = 2;
    		}
    	}
//        System.out.println(Arrays.toString(nums));
    }
	public static void main(String[] args) {
		BestSolution solution = new BestSolution();
		solution.sortColors(new int[] {1,0,2,2,1,2});
	}
}
