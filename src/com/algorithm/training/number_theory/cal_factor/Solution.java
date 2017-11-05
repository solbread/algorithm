package com.algorithm.training.number_theory.cal_factor;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> factorSimple(int n) {
		List<Integer> factorList = new ArrayList<>();
		int sqrt = (int)Math.sqrt(n);
		for(int i = 2; i <= sqrt; i++) {
			while(n%i==0) {
				n/=i;
				factorList.add(i);
			}
		}
		if(n!=1) factorList.add(n);
		return factorList;
	}
    public static void main(String[] args) {
		Solution solution = new Solution();
		for(int f : solution.factorSimple(11)) {
			System.out.print(f + " ");
		}
	}
}
