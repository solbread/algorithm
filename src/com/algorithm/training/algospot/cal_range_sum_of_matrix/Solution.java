package com.algorithm.training.partition_sum.cal_range_sum_of_matrix;

public class Solution {
	public int calRangeSumOfMatrix(int[][] numbers, int x1, int y1, int x2, int y2) {
	    int[][] partitionSum = new int[numbers.length][];
	    for(int i = 0; i < numbers.length; i++) {
	        partitionSum[i] = new int[numbers[i].length];
	        for(int j = 0; j < numbers[i].length; j++) {
	            partitionSum[i][j] += (numbers[i][j] 
	                    + (i > 0 ? partitionSum[i-1][j] : 0)
	                    + (j > 0 ? partitionSum[i][j-1] : 0)
	                    - (i > 0 && j > 0 ? partitionSum[i-1][j-1] : 0));
	        }
	    }
	    return partitionSum[x2][y2] 
	            - (y1 > 0 ? partitionSum[x2][y1-1] : 0)
	            - (x1 > 0 ? partitionSum[x1-1][y2] : 0)
	            + (x1 > 0 && y1 > 0 ? partitionSum[x1-1][y1-1] : 0);
	} 
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.calRangeSumOfMatrix(new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,2}}, 1, 1, 3, 3));
		System.out.println(solution.calRangeSumOfMatrix(new int[][]{{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}}, 0, 0, 3, 3));
	}
}
