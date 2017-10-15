package com.algorithm.training.dynamic_programming.poly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BestMain {
	static int MOD_VALUE = 10000000;
	static int cache[][];
	public static void main(String[] args) {
		BestMain main = new BestMain();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/poly/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int squareNumber = scanner.nextInt();
			cache = new int[squareNumber+1][squareNumber+1];
			for(int[] subCache : cache) Arrays.fill(subCache, -1);
			int result = 0;
			for(int i = 1; i <= squareNumber; i++) {
				result += main.getPolyCount(squareNumber-i, i);
				result %= MOD_VALUE;
			}
			System.out.println(result);
		}
	}
	public int getPolyCount(int remainedSquareCount, int currentSquareCount) {
		if(remainedSquareCount == 0) return 1;
		if(cache[remainedSquareCount][currentSquareCount] != -1) return cache[remainedSquareCount][currentSquareCount];
		int polyCount = 0;
		for(int i = 1; i <= remainedSquareCount; i++) {
			int tmpPolyCount = (getPolyCount(remainedSquareCount-i, i) * (currentSquareCount + i -1));
			tmpPolyCount %= MOD_VALUE;
			polyCount += tmpPolyCount;
			polyCount %= MOD_VALUE;
		}
		cache[remainedSquareCount][currentSquareCount] = polyCount;
		return cache[remainedSquareCount][currentSquareCount];
	}
}
