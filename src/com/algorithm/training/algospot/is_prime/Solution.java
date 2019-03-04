package com.algorithm.training.number_theory.is_prime;

public class Solution {
	public boolean isPrime(int n) {
		if(n<=1) return false;
		if(n==2) return true;
		if(n%2==0) return false;
		for(int i = 2; i <= (int)Math.sqrt(n); i+=2) {
			if(n%2 == 0) return false;
		}
		return true;
		
	}
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPrime(5));
		System.out.println(solution.isPrime(6));
	}
}
