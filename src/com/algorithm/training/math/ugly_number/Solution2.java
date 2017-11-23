package com.algorithm.training.math.ugly_number;

public class Solution2 {
    public boolean isUgly(int num) {
    	if(num == 0) return false;
    	for(int i : new int[] {2,3,5}) {
    		while(num % i == 0) {
    			num /= i;
    		}
    	}
    	return num == 1;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.isUgly(0)); //false
    	System.out.println(solution.isUgly(6)); //true
		System.out.println(solution.isUgly(14)); //false
	}
}
