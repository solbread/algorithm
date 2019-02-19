package com.algorithm.training.array.majority_element;

public class BestSolution {
    public int majorityElement(int[] nums) {
    	int major = nums[0], count = 1;
    	for(int i = 1; i < nums.length; i++) {
    		if(count == 0) {
    			major = nums[i];
    			count++;
    		} else if(major == nums[i]) {
    			count++;
    		} else {
    			count--;
    		}
    	}
    	return major;
    }
    
    public static void main(String[] args) {
    	BestSolution solution = new BestSolution();
    	System.out.println(solution.majorityElement(new int[] {1,2,2})); //2
	}
}
