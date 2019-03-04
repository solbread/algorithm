package com.algorithm.training.partition_sum.get_zero_approximae_range;

import java.util.Arrays;

public class Solution {
    public int getZeroApproximateRange(int[] numbers) {
        for(int i = 1; i < numbers.length; i++) {
            numbers[i]+= numbers[i-1];
        }
        Arrays.sort(numbers);
        int minDiff = Math.abs(numbers[0]);
        for(int i = 1; i < numbers.length; i++) {
            minDiff = Math.min(minDiff, Math.min(Math.abs(numbers[i]), Math.abs(numbers[i-1]-numbers[i])));
        }
        return minDiff;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.getZeroApproximateRange(new int[]{-14,7,2,3,-8,4,-6,8,9,11})); //1
		System.out.println(solution.getZeroApproximateRange(new int[]{3, -3})); //0
		System.out.println(solution.getZeroApproximateRange(new int[]{1, 0, 3})); //0
		System.out.println(solution.getZeroApproximateRange(new int[]{1, 1, -2, 3})); //0
	}
}
