package com.algorithm.training.dynamic_programming.jumpgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int board[][];
	static int cache[][];
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/jumpgame/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int boardSize = scanner.nextInt();
			board = new int[boardSize][boardSize];
			for(int i = 0; i < boardSize; i++) {
				for (int j = 0; j < boardSize; j++) {
					board[i][j] = scanner.nextInt();
				}
			}
			System.out.println(main.isPossibleArrival(0, 0) ? "YES" : "NO" );
		}
	}
	
	public boolean isPossibleArrival(int startX, int startY) {
		if(startX > board.length-1 || startY > board.length-1) return false;
		if(startX == board.length-1 && startY == board.length-1) return true;
		int moveDistance = board[startX][startY];
		return isPossibleArrival(startX + moveDistance, startY) || isPossibleArrival(startX, startY + moveDistance);
	}
}
