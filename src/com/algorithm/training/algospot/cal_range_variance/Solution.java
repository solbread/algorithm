package com.algorithm.training.partition_sum.cal_variance;

public class Solution {
	public double calVariance(int[] numbers, int i, int j) {
	    int[] partitionSum = new int[numbers.length];
	    int[] squareSum = new int[numbers.length];
	    for(int k = 0; k < partitionSum.length; k++) {
	        if(k == 0) {
	            partitionSum[k] = numbers[k];
	            squareSum[k] = numbers[k]*numbers[k];
	        }
	        else {
	            partitionSum[k] = partitionSum[k-1] + numbers[k]; 
	            squareSum[k] = squareSum[k-1] + numbers[k]*numbers[k];
	        }
	    }
	    int pSum = partitionSum[j] - (i==0 ? 0 : partitionSum[i-1]);
	    int pSquareSum = squareSum[j] - (i==0 ? 0 : squareSum[i-1]);
	    int pNumberCount = (j-i+1);
	    double pAverage = pSum / (double)pNumberCount;
	    return (pSquareSum - 2*pAverage*pSum + pNumberCount*pAverage*pAverage) / (double)pNumberCount;
	} 
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.calVariance(new int[]{1,2,3,4}, 1, 2));
		System.out.println(solution.calVariance(new int[]{1,2,3,4}, 0, 2));
	}
}
