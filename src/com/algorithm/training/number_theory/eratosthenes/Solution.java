package com.algorithm.training.number_theory.eratosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<Integer> eratosthenes(int n) {
		List<Integer> primeList = new ArrayList<>();
		boolean isPrime[] = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for(int i = 2; i <= (int)Math.sqrt(isPrime.length); i++) {
			if(isPrime[i]) {
				for(int j = i*i; j < isPrime.length; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		for(int i = 0; i < isPrime.length; i++) {
			if(isPrime[i]) primeList.add(i);
		}
		return primeList;
	}
    public static void main(String[] args) {
		Solution solution = new Solution();
		List<Integer> primeList = solution.eratosthenes(10);
		for(int prime : primeList) {
			System.out.print(prime + " ");
		}
	}
}
