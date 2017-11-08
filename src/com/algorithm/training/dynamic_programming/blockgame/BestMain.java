package com.algorithm.training.dynamic_programming.blockgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestMain {
	static int[][][] settingBlock = {{{-1,0},{-1,-1}}, {{-1,0},{-1,1}}, {{1,0},{1,-1}}, {{1,0},{1,1}}, {{0,1}}, {{1,0}}};
	static char[][] board;
	public static void main(String[] args) {
		BestMain main = new BestMain();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/blockgame/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			board = new char[5][5];
			for(int i = 0; i < board.length; i++) {
				board[i] = scanner.next().toCharArray();
			}
			System.out.println(main.isWin() ? "WINNING" : "LOSING");
		}
	}
	public boolean isWin() {
		boolean isWin = false;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == '.') {
					board[i][j] = '#';
					for(int k = 0; k < settingBlock.length; k++) {
						isWin |= setBlock(i, j, settingBlock[k]);
					}
					board[i][j] = '.';
				}
			}
		}
		return isWin;
	}
	private boolean setBlock(int cX, int cY, int[][] points) {
		boolean canSet = true, isWin = false;
		for(int i = 0; i < points.length; i++) {
			if(cX+points[i][0] < 0 || cX+points[i][0] >= board.length 
					|| cY+points[i][1] < 0 || cY+points[i][1] >= board[0].length 
					|| board[cX+points[i][0]][cY+points[i][1]] == '#') {
				canSet = false;
			}
		}
		if(canSet) {
			for(int i = 0; i < points.length; i++) {
				board[cX+points[i][0]][cY+points[i][1]] = '#';
			}
			isWin |= !isWin();
			for(int i = 0; i < points.length; i++) {
				board[cX+points[i][0]][cY+points[i][1]] = '.';
			}
		}
		return isWin;
	}
}
