package com.algorithm.training.combinatorial_search.boardcover2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BestMain {
	static char[][] board, block;
	static List<List<int[]>> settingCase;
	static int blockWidth, blockHeight, maxBlockCount;
	public static void main(String[] args) throws IOException {
		BestMain main = new BestMain();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/com/algorithm/training/combinatorial_search/boardcover2/test"))));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		int cases = Integer.parseInt(bufferedReader.readLine());
		while(cases-- > 0) {
			maxBlockCount = 0;
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
			board  = new char[Integer.parseInt(stringTokenizer.nextToken())][Integer.parseInt(stringTokenizer.nextToken())];
			int blockWidth = Integer.parseInt(stringTokenizer.nextToken()), blockHeight = Integer.parseInt(stringTokenizer.nextToken()), blanckCount = 0;
			for(int i = 0;  i < board.length; i++) {
				board[i] = bufferedReader.readLine().toCharArray();
				for(int j = 0; j < board[i].length; j++) {
					if(board[i][j] == '.') blanckCount++;
				}
			}
			int blockNumber = 0;
			block = new char[blockWidth][blockHeight];
			for(int i = 0; i < block.length; i++) {
				block[i] = bufferedReader.readLine().toCharArray();
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
		settingCase = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			List<int[]> setting = new ArrayList<>();
			int leftTop[] = {-1,-1};
			for(int j = 0; j < block.length; j++) {
				for(int k = 0; k < block[j].length; k++) {
					if(block[j][k] == '#') {
						if(leftTop[0] == -1) {
							leftTop[0] = j;
							leftTop[1] = k;
						}
						setting.add(new int[]{j-leftTop[0], k-leftTop[1]});
					}
				}
			}
			Collections.sort(setting, (a,b) -> (a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]));
			boolean isSame = true;
			for(List<int[]> addedSetting : settingCase) {
				for(int j = 0; j < setting.size(); j++) {
					isSame = isSame && addedSetting.get(j)[0] == setting.get(j)[0]
							&& addedSetting.get(j)[1] == addedSetting.get(j)[1];
				}
			}
			if(settingCase.isEmpty() || !isSame) settingCase.add(setting);
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
		if(currentBlockCount + remainedBlanckCount / settingCase.get(0).size() <= maxBlockCount) return;
		boolean cover = false;
		for(int i = 0; i < board.length && !cover; i++) {
			for(int j = 0; j < board[i].length && !cover; j++) {
				if(board[i][j] == '.') {
					cover = true;
					for(List<int[]> settings : settingCase) {
						if(canSet(settings, i, j)) {
							setBlock(settings, i, j, '#');
							countMaxBlock(currentBlockCount+1, remainedBlanckCount-settingCase.get(0).size());
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

	private boolean canSet(List<int[]> settings, int cX, int cY) {
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
	
	private void setBlock(List<int[]> settings, int cX, int cY, char setChar) {
		for(int[] set : settings) {
			board[cX+set[0]][cY+set[1]] = setChar;
		}
	}
}
