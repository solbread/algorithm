package com.algorithm.training.bit_manipulation.reverse_bits;

public class BestSolution {
    public int reverseBits(int n) {
    	int reverseBits = 0;
    	for(int i = 0; i < 32; i++) {
    		reverseBits <<= 1;
    		reverseBits += (n&1);
    		n >>= 1;
    	}
    	return reverseBits;
    }
	public static void main(String[] args) {
		BestSolution solution = new BestSolution();
		System.out.println(solution.reverseBits(43261596));
		System.out.println(solution.reverseBits(1));
	}
}
