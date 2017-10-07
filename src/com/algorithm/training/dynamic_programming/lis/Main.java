package com.algorithm.training.dynamic_programming.lis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int[] numbers;
	static int[][] cache;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/lis/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			numbers = new int[scanner.nextInt()];
			cache = new int[numbers.length+1][numbers.length];
			for(int i = 0; i < numbers.length; i++) {
				numbers[i] = scanner.nextInt();
			}
			for(int i = 0; i < cache.length; i++) {
				for(int j = 0; j < cache[i].length; j++) {
					cache[i][j] = -1;
				}
			}
			System.out.println(main.getMaxLength(-1, 0) + 1);
		}
	}
	
	public int getMaxLength(int prevPoint, int currentPoint) {
		if(currentPoint == numbers.length) return 0;
		if(cache[prevPoint+1][currentPoint] != -1) return cache[prevPoint][currentPoint];
		if(prevPoint == -1 || numbers[prevPoint] < numbers[currentPoint]) {
			cache[prevPoint+1][currentPoint] = Math.max(getMaxLength(currentPoint, currentPoint+1) + (prevPoint == -1 ? 0 : 1), getMaxLength(prevPoint, currentPoint+1));
		} else {
			cache[prevPoint+1][currentPoint] = getMaxLength(prevPoint, currentPoint+1);
		}
		return cache[prevPoint+1][currentPoint];
	}
}
