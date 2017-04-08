package com.algorithm.training.bit_manipulation.reverse_bits;

@Deprecated //������ �ڵ�
public class Solution {
    public int reverseBits(int n) {
    	int reverseBits = 0;
    	for(int i = 31; i >= 0; i--) {
    		reverseBits += ((n&1)==1? Math.pow(2, i) : 0);
    		n = n >> 1;
    	}
    	return reverseBits;
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverseBits(1));
	}
}
