package com.algorithm.training.skill.pow;

public class CalculatePow2 {
	public long getPow(long number, long multiplier, int modular) {
		long ret = 1;
		while(multiplier > 0) {
			if((multiplier&1) == 1) ret = (ret*number)%modular; 
			number = (number*number)%modular;
			multiplier >>= 1;
		}
		return ret;
	}
	public static void main(String[] args) {
		CalculatePow2 calculatePow = new CalculatePow2();
		System.out.println(calculatePow.getPow(3, 4, 100000007));
	}
}
