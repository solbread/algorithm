package com.algorithm.training.number_theory.cal_gcd;

public class Solution {
	public int getGCD(int p, int q) {
		if(q == 0) return p;
		return getGCD(q, p%q);
	}
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.getGCD(1024, 6));
	}
}
