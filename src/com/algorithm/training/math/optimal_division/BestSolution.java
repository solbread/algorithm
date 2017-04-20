package com.algorithm.training.math.optimal_division;

public class BestSolution {
    public String optimalDivision(int[] nums) {
        StringBuilder result = new StringBuilder(nums[0] + (nums.length==1 ? "" : "/"));
        for(int i = 1; i < nums.length; i++) {
        	if(i==1 && nums.length > 2) {
        		result.append('(');
        	}
        	result.append(nums[i]).append('/');
        	if(i == nums.length-1 && nums.length > 2) {
        		result.setCharAt(result.length()-1, ')');
        	}
        }
    	return result.toString();
    }
    public static void main(String[] args) {
		BestSolution solution = new BestSolution();
		int nums[] = {1000, 100, 10, 2}; //output:1000/(100/10/2)
		System.out.println(solution.optimalDivision(nums));
	}
}
