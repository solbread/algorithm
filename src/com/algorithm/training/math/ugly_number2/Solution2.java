package com.algorithm.training.math.ugly_number2;

public class Solution2 {
    public int nthUglyNumber(int n) {
        int[][] factors = {{2,0,1}, {3,0,1}, {5,0,1}};
        int[] uglyNumber = new int[n];
        int next = 1;
        for(int i = 0; i < n; i++) {
        	uglyNumber[i] = next;
        	next = Integer.MAX_VALUE;
        	for(int j = 0; j < factors.length; j++) {
        		if(factors[j][2] == uglyNumber[i]) {
        			factors[j][2] = (factors[j][0] * uglyNumber[factors[j][1]++]);
        		}
        		next = Math.min(next,factors[j][2]);
        	}
        }
        return uglyNumber[n-1];
    }
    public static void main(String[] args) {
    	Solution2 solution = new Solution2();
    	System.out.println(solution.nthUglyNumber(10)); //12
	}
}
