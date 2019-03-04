package com.algorithm.training.skill.pow;

public class CalculatePow1 {
	public long getPow(long number, long multiplier, int modular) {
		if(multiplier==0) return 1;
		if(multiplier==1) return number;
		long ret = getPow(number, multiplier/2, modular);
		ret = (ret * ret) % modular;
		if(multiplier%2==1) ret = (ret*number) % modular;
		return ret;
	}
	public static void main(String[] args) {
		CalculatePow1 calculatePowX = new CalculatePow1();
		System.out.println(calculatePowX.getPow(3, 4, 100000007));
		System.out.println(calculatePowX.getPow(3, 5, 100000007));
	}
}
