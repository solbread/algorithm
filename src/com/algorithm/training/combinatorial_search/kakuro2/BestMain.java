package com.algorithm.training.combinatorial_search.kakuro2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BestMain {
	static int board[][], hint[][][], length[], sum[], filled[], candidates[][][], solution[][];
	public static void main(String[] args) throws IOException {
		BestMain main = new BestMain();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/com/algorithm/training/combinatorial_search/kakuro2/test"))));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		int cases = Integer.parseInt(bufferedReader.readLine());
		while(cases-- > 0) {
			int boardSize = Integer.parseInt(bufferedReader.readLine())+1;
			board = new int[boardSize][boardSize];
			solution = new int[boardSize][boardSize];
			length = new int[boardSize*boardSize*2];
			sum = new int[boardSize*boardSize*2];
			filled = new int[boardSize*boardSize*2];
			for(int i = 1; i < board.length; i++) {
				StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(),  " ");
				for(int j = 1; j < boardSize; j++) {
					board[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}
			int hintCount = Integer.parseInt(bufferedReader.readLine())+1;
			hint = new int[boardSize][boardSize][2];
			for(int i = 1; i < hintCount; i++) {
				StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
				int y = Integer.parseInt(tokenizer.nextToken());
				int x = Integer.parseInt(tokenizer.nextToken());
				int direction = Integer.parseInt(tokenizer.nextToken());
				int hintNumber = y*board.length + x + (direction == 0 ? 0 : boardSize*boardSize);
				int value = Integer.parseInt(tokenizer.nextToken());
				int count = 0;
				if(direction == 0) x++;
				else y++;
				while(x < board[0].length && y < board.length && board[y][x] == 1) {
					hint[y][x][direction] = hintNumber;
					count++;
					if(direction == 0) x++;
					else y++;
				}
				sum[hintNumber] = value;
				length[hintNumber] = count;
				
			}
			candidates = new int[10][46][1024]; //length, sum, filled
			for(int i = 0; i < 1024; i += 2) {
				int length = main.getSize(i);
				int sum = main.getSum(i);
				int subset = i;
				while(true) {
					candidates[length][sum][subset] |= (i & ~subset);
					if(subset == 0) break;
					subset = ((subset-1) & i);
				}
			}
			main.fillBoard();
		}
	}
	
	public int getSize(int set) {
		return Integer.bitCount(set);
	}
	
	public int getSum(int set) {
		int sum = 0;
		for(int i = 1; i <= 9; i++) {
			if((set & (1<<i)) > 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	public boolean fillBoard() {
		//아직 숫자를 쓰지 않은 흰 칸 중 후보의 수가 최소인 칸을 찾는다.
		int y = -1, x = -1, minCandidate = 1023;
		for(int i = 1; i < board.length; i++) {
			for(int j = 1; j < board[i].length; j++) {
				if(board[i][j] == 1 && solution[i][j] == 0) {
					int currentCandidate = getCandidate(i, j);
					if(getSize(minCandidate) > getSize(currentCandidate)) {
						minCandidate = currentCandidate;
						y = i;
						x = j;
					}
				}
			}
		}
		
		//이 칸에 들어갈 숫자가 없으면 실패!
		if(minCandidate == 0) return false;
		
		//모든 칸이 채워졌으면 출력하고 종료한다.
		if(y == -1) {
			for(int i = 1; i < solution.length; i++) {
				for(int j = 1; j < solution[i].length; j++) {
					System.out.print((j==1 ? "" : " ") + solution[i][j]);
				}
				System.out.println();
			}
			return true;
		}
		
		//숫자를 하나씩 채워본다.
		for(int i = 1; i <= 9; i++) {
			if((minCandidate & (1 << i)) > 0) {
				put(y, x, i);
				if(fillBoard()) return true;
				remove(y, x, i);
			}
		}
		return false;
	}
	
	private int getCandidate(int y, int x) {
		int widthHint = hint[y][x][0];
		int heightHint = hint[y][x][1];
		return candidates[length[widthHint]][sum[widthHint]][filled[widthHint]]
				& candidates[length[heightHint]][sum[heightHint]][filled[heightHint]];
	}
	
	private void put(int y, int x, int value) {
		solution[y][x] = value;
		for(int i = 0 ; i <= 1; i++) {
			filled[hint[y][x][i]] |= (1<<value);
		}
	}
	
	private void remove(int y, int x, int value) {
		solution[y][x] = 0;
		for(int i = 0 ; i <= 1; i++) {
			filled[hint[y][x][i]] &= ~(1<<value);
		}
	}
}
