package com.algorithm.training.number_theory.eratosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestSolution {
	public List<Integer> eratosthenes(int n) {
		List<Integer> primeList = new ArrayList<>();
		int[] isPrime = new int[(int)Math.ceil((n+1)/16.0)];
		Arrays.fill(isPrime, (int)Math.pow(2, 16)-1);
		isPrime[0] -= 3;
		for(int i = 2; i <= n; i++) {
			if((isPrime[i>>4] & (1 << (i & 15))) > 0) {
				for(int j = i*i; j <= n; j+=i) {
					isPrime[j>>4] &= ~(1 << (j & 15));
				}
 			}
		}
		for(int i = 0; i < isPrime.length; i++) {
			for(int j = 0; j < 16 && ((i<<4) + j <= n); j++) {
				if((isPrime[i] & (1 << j)) > 0) {
					primeList.add((i<<4) + j);
				}
			}
		}
		return primeList;
	}
    public static void main(String[] args) {
		BestSolution solution = new BestSolution();
		List<Integer> primeList = solution.eratosthenes(19);
		for(int prime : primeList) {
			System.out.print(prime + " ");
		}
	}
} 
