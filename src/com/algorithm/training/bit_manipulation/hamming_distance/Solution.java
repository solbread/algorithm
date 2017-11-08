package com.algorithm.training.bit_manipulation.hamming_distance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int hammingDistance = 0;
        for(int i = 0; i < 32; i++) {
            if((result & (1 << i)) > 0) hammingDistance++;
        }
        return hammingDistance;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.hammingDistance(1, 4)); //2
	}
}
