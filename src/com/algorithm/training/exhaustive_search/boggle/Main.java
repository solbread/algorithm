package com.algorithm.training.exhaustive_search.boggle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static char[][] board;
	static char[] targetWordChars;
	static int[][][] cache;
	public static void main(String[] args) {
		Main main = new Main();
//		Scanner scanner = new Scanner(System.in);
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/exhaustive_search/boggle/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		board = new char[5][5];
		while(cases-- > 0) {
			for(int i = 0; i < 5; i++) {
				board[i] = scanner.next().toCharArray();
			}
			int targetWordNum = scanner.nextInt();
			for(int i = 0; i < targetWordNum; i++) {
				String targetWord = scanner.next();
				targetWordChars = targetWord.toCharArray();
				cache = new int[5][5][targetWordChars.length];
				boolean isSearched = false;
				for(int j = 0; j < board.length; j++) {
					for(int k = 0; k < board[j].length; k++) {
						isSearched = main.searchTargetWord(j, k, 0);
						if(isSearched) break;
					}
					if(isSearched) break;
				}
				System.out.println(targetWord + " " + (isSearched ? "YES" : "NO"));
			}
		}
		scanner.close();
	}
	
	public boolean searchTargetWord(int xPoint, int yPoint, int searchPosition) {
		if(cache[xPoint][yPoint][searchPosition] != 0) return cache[xPoint][yPoint][searchPosition] == 1; 
		if(board[xPoint][yPoint] == targetWordChars[searchPosition]) {
			boolean isSearched = false;
			if(searchPosition == targetWordChars.length-1) isSearched = true;
			if(xPoint > 0) isSearched = isSearched || searchTargetWord(xPoint-1, yPoint, searchPosition+1);
			if(xPoint > 0 && yPoint > 0) isSearched = isSearched || searchTargetWord(xPoint-1, yPoint-1, searchPosition+1);
			if(yPoint > 0) isSearched = isSearched || searchTargetWord(xPoint, yPoint-1, searchPosition+1);
			if(xPoint < 4 && yPoint > 0) isSearched = isSearched || searchTargetWord(xPoint+1, yPoint-1, searchPosition+1);
			if(xPoint < 4) isSearched = isSearched || searchTargetWord(xPoint+1, yPoint, searchPosition+1);
			if(xPoint < 4 && yPoint < 4) isSearched = isSearched || searchTargetWord(xPoint+1, yPoint+1, searchPosition+1);
			if(yPoint < 4) isSearched = isSearched || searchTargetWord(xPoint, yPoint+1, searchPosition+1);
			if(xPoint > 0 && yPoint < 4) isSearched = isSearched || searchTargetWord(xPoint-1, yPoint+1, searchPosition+1);
			cache[xPoint][yPoint][searchPosition] = (isSearched) ? 1 : 2;
		} else {
			cache[xPoint][yPoint][searchPosition] = 2;
		}
		return cache[xPoint][yPoint][searchPosition] == 1;
	}
}
