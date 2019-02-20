package com.algorithm.training.divide_and_conquer.sum_of_numbers;

public class Solution {
	public int calSum(int n) {
		if(n == 1) return n;
		return n + calSum(n-1);
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.calSum(10));
	}
}
