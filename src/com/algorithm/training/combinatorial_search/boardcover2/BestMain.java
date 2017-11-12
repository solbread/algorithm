package com.algorithm.training.combinatorial_search.boardcover2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BestMain {
	static boolean[][] board, block; //true면 채워져있고 false면 비어있는것 
	static List<List<int[]>> settingCase;
	static int blockWidth, blockHeight, blockNumber, maxBlockCount;
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
			board  = new boolean[Integer.parseInt(stringTokenizer.nextToken())][Integer.parseInt(stringTokenizer.nextToken())];
			int blockWidth = Integer.parseInt(stringTokenizer.nextToken()), blockHeight = Integer.parseInt(stringTokenizer.nextToken()), blanckCount = 0;
			for(int i = 0;  i < board.length; i++) {
				char row[] = bufferedReader.readLine().toCharArray();
				for(int j = 0; j < board[i].length; j++) {
					board[i][j] = row[j] == '#';
					if(row[j] == '.') {
						blanckCount++;
					}
				}
			}
			block = new boolean[blockWidth][blockHeight];
			for(int i = 0; i < block.length; i++) {
				char row[] = bufferedReader.readLine().toCharArray();
				for(int j = 0; j < row.length; j++) {
					block[i][j] = row[j] == '#';
				}
			}
			main.makeSettingCase();
			main.countMaxBlock(0, 0, 0, blanckCount);
			System.out.println(maxBlockCount);
		}
	}
	
	public void makeSettingCase() {
		settingCase = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			List<int[]> setting = new ArrayList<>();
			int leftTop[] = {-1,-1};
			for(int j = 0; j < block.length; j++) {
				for(int k = 0; k < block[j].length; k++) {
					if(block[j][k]) {
						if(leftTop[0] == -1) {
							leftTop[0] = j;
							leftTop[1] = k;
						}
						setting.add(new int[]{j-leftTop[0], k-leftTop[1]});
					}
				}
			}
			boolean isSame = !settingCase.isEmpty();
			for(int j = 0; j < settingCase.size() && isSame; j++) {
				for(int k = 0; k < setting.size() && isSame; k++) {
					isSame = isSame && settingCase.get(j).get(k)[0] == setting.get(k)[0]
							&& settingCase.get(j).get(k)[1] == settingCase.get(j).get(k)[1];
				}
			}
			if(!isSame) settingCase.add(setting);
			rotateBlock();
		}
		blockNumber = settingCase.get(0).size();
	}
	
	public void rotateBlock() {
		boolean[][] rotatedBlock = new boolean[block[0].length][block.length];
		for(int i = 0; i < rotatedBlock.length; i++) {
			for(int j = 0; j < rotatedBlock[0].length; j++) {
				rotatedBlock[i][j] = block[block.length-1-j][i];
			}
		}
		block = rotatedBlock;
	}
	
	
	public void countMaxBlock(int i, int j, int currentBlockCount, int remainedBlanckCount) {
		if(currentBlockCount + remainedBlanckCount / blockNumber <= maxBlockCount) return;
		boolean cover = false;
		for(; i < board.length && !cover; i++) {
			j = 0;
			for(; j < board[i].length && !cover; j++) {
				if(!board[i][j]) {
					cover = true;
					for(List<int[]> settings : settingCase) {
						if(canSet(settings, i, j)) {
							setBlock(settings, i, j, true);
							countMaxBlock(i, j+1, currentBlockCount+1, remainedBlanckCount-blockNumber);
							setBlock(settings, i, j, false);
						}
					}
					board[i][j] = true;
					countMaxBlock(i, j+1, currentBlockCount, remainedBlanckCount-1);
					board[i][j] = false;
				}
			}
		}
		if(!cover) maxBlockCount = Math.max(maxBlockCount, currentBlockCount);
	}

	private boolean canSet(List<int[]> settings, int cX, int cY) {
		boolean canSet = true;
		for(int i = 0; i < settings.size() && canSet; i++) {
			int afterX = cX + settings.get(i)[0];
			int afgterY = cY + settings.get(i)[1];
			canSet = canSet && afterX >= 0 && afterX < board.length 
					&& afgterY >= 0 && afgterY < board[0].length
					&& !board[afterX][afgterY];
		}
		return canSet;
	}
	
	private void setBlock(List<int[]> settings, int cX, int cY, boolean setMode) {
		for(int[] set : settings) {
			board[cX+set[0]][cY+set[1]] = setMode;
		}
	}
}
