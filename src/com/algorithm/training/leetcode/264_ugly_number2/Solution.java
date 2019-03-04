package com.algorithm.training.math.ugly_number2;

public class Solution {
    public int nthUglyNumber(int n) {
        int[][] factors = {{2,0}, {3,0}, {5,0}};
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        for(int i = 1; i < n; i++) {
        	uglyNumber[i] = Integer.MAX_VALUE;
        	for(int j = 0; j < factors.length; j++) {
        		uglyNumber[i] = Math.min(uglyNumber[i], factors[j][0] * uglyNumber[factors[j][1]]);
        	}
        	for(int j = 0; j < factors.length; j++) {
        		if(factors[j][0] * uglyNumber[factors[j][1]] == uglyNumber[i]) {
        			factors[j][1]++;
        		}
        	}
        }
        return uglyNumber[n-1];
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.nthUglyNumber(10)); //12
	}
}
