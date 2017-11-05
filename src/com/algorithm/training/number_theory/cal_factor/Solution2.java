package com.algorithm.training.number_theory.cal_factor;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	int minFactor[];
	private void eratosthenes(int n) {
		minFactor = new int[n+1];
		minFactor[0] = minFactor[1] = -1;
		for(int i = 2; i <= n; i++) {
			minFactor[i] = i;
		}
		int sqrt = (int)Math.sqrt(n);
		for(int i = 2; i <= sqrt; i++) {
			for(int j = i*i; j <= n; j+=i) {
				if(minFactor[j] == j) {
					minFactor[j] = i;
				}
			}
		}
	}
	public List<Integer> factor(int n) {
		eratosthenes(n);
		List<Integer> factorList = new ArrayList<>();
		while(n > 1) {
			factorList.add(minFactor[n]);
			n /= minFactor[n];
		}
		return factorList;
	}
    public static void main(String[] args) {
		Solution2 solution = new Solution2();
		for(int f : solution.factor(128)) {
			System.out.print(f + " ");
		}
	}
}
