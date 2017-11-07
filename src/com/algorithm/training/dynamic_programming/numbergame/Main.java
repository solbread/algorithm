package com.algorithm.training.dynamic_programming.numbergame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int board[];
	static int cache[][];
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/numbergame/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			board = new int[scanner.nextInt()];
			cache = new int[board.length][board.length];
			for(int i = 0; i < board.length; i++) {
				board[i] = scanner.nextInt();
				Arrays.fill(cache[i], -50001);
			}
			System.out.println(main.getScoreDiff(0, board.length-1));
		}
	}
	public int getScoreDiff(int left, int right) {
		if(right < left) return 0;
		if(cache[left][right] != -50001) return cache[left][right];
 		int scoreDiff = board[left]-getScoreDiff(left+1, right);
		scoreDiff = Math.max(scoreDiff, board[right]-getScoreDiff(left, right-1));
		if(right-left + 1 >= 2) {
			scoreDiff = Math.max(scoreDiff, -getScoreDiff(left, right-2));
			scoreDiff = Math.max(scoreDiff, -getScoreDiff(left+2, right));
		}
		cache[left][right] = scoreDiff;
		return cache[left][right];
	}
}