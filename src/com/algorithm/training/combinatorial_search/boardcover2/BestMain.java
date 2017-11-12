package com.algorithm.training.combinatorial_search.boardcover2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestMain {
	static char[][] board, block;
	static int[][][] settingCase;
	static int blockWidth, blockHeight, maxBlockCount;
	public static void main(String[] args) {
		BestMain main = new BestMain();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/combinatorial_search/boardcover2/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			maxBlockCount = 0;
			board  = new char[scanner.nextInt()][scanner.nextInt()];
			int blockWidth = scanner.nextInt(), blockHeight = scanner.nextInt(), blanckCount = 0;
			for(int i = 0;  i < board.length; i++) {
				board[i] = scanner.next().toCharArray();
				for(int j = 0; j < board[i].length; j++) {
					if(board[i][j] == '.') blanckCount++;
				}
			}
			int blockNumber = 0;
			block = new char[blockWidth][blockHeight];
			for(int i = 0; i < block.length; i++) {
				block[i] = scanner.next().toCharArray();
				for(int j = 0; j < block[i].length; j++) {
					if(block[i][j] == '#') blockNumber++;
				}
			}
			main.makeSettingCase(blockNumber);
			main.countMaxBlock(0, blanckCount);
			System.out.println(maxBlockCount);
		}
	}
	
	public void makeSettingCase(int blockNumber) {
		settingCase = new int[4][blockNumber][2];
		for(int i = 0; i < settingCase.length; i++) {
			int index = 0;
			int leftTop[] = {-1,-1};
			for(int j = 0; j < block.length; j++) {
				for(int k = 0; k < block[j].length; k++) {
					if(block[j][k] == '#') {
						if(leftTop[0] == -1) {
							leftTop[0] = j;
							leftTop[1] = k;
						}
						settingCase[i][index] = new int[]{j-leftTop[0], k-leftTop[1]};
						index++;
					}
				}
			}
			rotateBlock();
		}
	}
	
	public void rotateBlock() {
		char[][] rotatedBlock = new char[block[0].length][block.length];
		for(int i = 0; i < rotatedBlock.length; i++) {
			for(int j = 0; j < rotatedBlock[0].length; j++) {
				rotatedBlock[i][j] = block[block.length-1-j][i];
			}
		}
		block = rotatedBlock;
	}
	
	
	public void countMaxBlock(int currentBlockCount, int remainedBlanckCount) {
		if(currentBlockCount + remainedBlanckCount / settingCase[0].length <= maxBlockCount) return;
		boolean cover = false;
		for(int i = 0; i < board.length && !cover; i++) {
			for(int j = 0; j < board[i].length && !cover; j++) {
				if(board[i][j] == '.') {
					cover = true;
					for(int[][] settings : settingCase) {
						if(canSet(settings, i, j)) {
							setBlock(settings, i, j, '#');
							countMaxBlock(currentBlockCount+1, remainedBlanckCount-settingCase[0].length);
							setBlock(settings, i, j, '.');
						}
					}
					board[i][j] = '#';
					countMaxBlock(currentBlockCount, remainedBlanckCount-1);
					board[i][j] = '.';
				}
			}
		}
		if(!cover) maxBlockCount = Math.max(maxBlockCount, currentBlockCount);
	}

	private boolean canSet(int[][] settings, int cX, int cY) {
		boolean canSet = true;
		for(int[] setting : settings) {
			int x = setting[0];
			int y = setting[1];
			canSet = canSet && cX+x >= 0 && cX+x < board.length 
					&& cY+y >= 0 && cY+y < board[0].length
					&& board[cX+x][cY+y] == '.';
		}
		return canSet;
	}
	
	private void setBlock(int[][] settings, int cX, int cY, char setChar) {
		for(int[] set : settings) {
			board[cX+set[0]][cY+set[1]] = setChar;
		}
	}
}
