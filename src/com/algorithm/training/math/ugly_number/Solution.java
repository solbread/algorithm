package com.algorithm.training.math.ugly_number;

public class Solution {
    public boolean isUgly(int num) {
    	if(num == 0 || num == 1 || num == 2 || num == 3 || num == 5) return num != 0;
    	else if(num % 2 == 0) return isUgly(num / 2);
    	else if(num % 3 == 0) return isUgly(num / 3);
    	else if(num % 5 == 0) return isUgly(num / 5);
    	else return false;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.isUgly(0)); //false
    	System.out.println(solution.isUgly(6)); //true
		System.out.println(solution.isUgly(14)); //false
	}
}
