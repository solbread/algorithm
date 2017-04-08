package com.algorithm.training.bit_manipulation.number_of_1_bits;

public class Solution {
    public int hammingWeight(int n) {
    	int hammingWeigt = 0;
        for(int i = 1; i <= 32; i ++) {
        	hammingWeigt += (n&1);
        	n = n >> 1;
        }
        return hammingWeigt;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.hammingWeight(11));
	}
}
