package com.algorithm.training.bit_manipulation.exercise_15_puzzle;

public class Solution {
	public long getMask(int[][] board) {
		long mask = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				mask |= ((long)board[i][j] << (((i<<2)+j)<<2));
			}
		}
		return mask;
	}
	public int[][] getBoard(long mask) {
		int[][] board = new int[4][4];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j <board.length; j++) {
				board[i][j] = (int)( (mask >> (((i<<2)+j)<<2)) & 15);
			}
		}
		return board;
	}
	public int getValue(long mask, int index) {
		return (int)( (mask >> (index << 2)) & 15);
	}
	public long setValue(long mask, int index, long value) {
		mask = (mask & ~(15 << (index << 2)) | (value << (index << 2)));
		return mask;
	}
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.getMask(new int[][]{{0,1,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}})); //1921
		for(int i = 0; i < 16; i++) {
			System.out.print(solution.getValue(16, i) + " ");
		}
		System.out.println();
		for(int[] row : solution.getBoard(16)) {
			for(int n : row) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
		System.out.println(solution.getMask(new int[][]{{1,2,3,4},{14,15,1,2},{1,3,5,7},{2,4,6,7}})); //8521502298822558497l
		for(int i = 0; i < 16; i++) {
			System.out.print(solution.getValue(8521502298822558497l, i) + " ");
		}
		System.out.println();
		for(int[] row : solution.getBoard(8521502298822558497l)) {
			for(int n : row) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(solution.setValue(65536, 0, 2));
	}
}
