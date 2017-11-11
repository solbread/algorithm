package com.algorithm.training.skill.multiplication;

public class EgyptMultiplication {
	public long multiplication(long x, long y, long modular) {
		if(x > y) {
			long tmp = x;
			x = y;
			y = tmp;
		}
		long ret = 0;
		while(x > 0) {
			if((x & 1) > 0) ret = (ret + y) % modular;
			x>>=1;
			y = (y<<1)%modular;
		}
	    return ret;
	}
	public static void main(String[] args) {
		EgyptMultiplication egyptMultiplication = new EgyptMultiplication();
		System.out.println(egyptMultiplication.multiplication(7, 25, 100000007));
		System.out.println(egyptMultiplication.multiplication(2147483650l, 2l, 100000007));
	}
}
