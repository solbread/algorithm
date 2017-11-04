package com.algorithm.training.dynamic_programming.tictactoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char board[][];
	static int[] cache;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/tictactoe/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			board = new char[3][3];
			cache = new int[(int)Math.pow(3, 9)];
			Arrays.fill(cache, -2);
			int boardNumber = 0;
			int turn = 0;
			for(int i = 0; i < board.length; i++) {
				board[i] = scanner.next().toCharArray();
				for(int j = 0; j < board.length; j++) {
					turn = board[i][j] == 'x' ? turn+1 : (board[i][j] == 'o' ? turn-1 : turn);
					boardNumber += Math.pow(3, i*3+j) * (board[i][j] == '.' ? 0 : (board[i][j] == 'x' ? 1 : 2));
				}
			}
			turn = (turn == 0 ? 'x' : 'o');
			int gameResult = main.getGameResult(boardNumber, (char)turn);
			System.out.println(gameResult == 0 ? "TIE" : (gameResult == 1 ? (char)turn : (char)('o'+'x'-turn)));
		}
	}
	//현재turn이 이기면 1, 비기면 0, 지면 -1
	public int getGameResult(int boardIdentification, char turn) {
		if(isFinished()) return -1;
		if(cache[boardIdentification] != -2) return cache[boardIdentification];
		int gameResult = -2;
		for(int i = 0; i < board.length; i ++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == '.') {
					board[i][j] = turn;
					gameResult = Math.max(gameResult, -getGameResult(
							boardIdentification + (int)Math.pow(3, i*3+j) * (board[i][j] == '.' ? 0 : (board[i][j] == 'x' ? 1 : 2)), 
							(char)('o'+'x'-turn)));
					board[i][j] = '.';
				}
			}
		}
		cache[boardIdentification] = (gameResult == -2) ?  0 : gameResult;
		return cache[boardIdentification];
	}
	
	private boolean isFinished() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 1; j < board[i].length; j++) {
				if(board[i][j-1] == '.' || board[i][j-1] != board[i][j]) break;
				if(board[i][j-1] == board[i][j] && j == board[i].length-1) return true;
			}
			for(int j = 1; j < board[i].length; j++) {
				if(board[j-1][i] == '.' || board[j-1][i] != board[j][i]) break;
				if(board[j-1][i] == board[j][i] && j == board[i].length-1) return true;
			}
		}
		return (board[0][0] != '.' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
			|| (board[0][2] != '.' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
	}
}
