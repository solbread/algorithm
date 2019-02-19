package com.algorithm.training.divide_and_conquer.sum_of_numbers;

public class Solution2 {
	public int calSum(int n) {
		if(n==1) return n;
		else if(n % 2 == 1) return n + calSum(n-1);
		return (2*calSum(n/2)) + (n*n/4);
	}
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.calSum(10));
	}
}
