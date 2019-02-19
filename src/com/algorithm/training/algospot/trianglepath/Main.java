package com.algorithm.training.dynamic_programming.trianglepath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int[][] triangle;
	static int[][] cache;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/trianglepath/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int triangleSize = scanner.nextInt();
			triangle = new int[triangleSize][];
			cache = new int[triangleSize][];
			for(int i = 0; i < triangle.length; i++) {
				triangle[i] = new int[i+1];
				cache[i] = new int[i+1];
				for(int j = 0; j < triangle[i] .length; j++) {
					triangle[i][j] = scanner.nextInt();
					cache[i][j] = -1;
				}
			}
			System.out.println(main.getMaxSum(0, 0));
		}
	}
	public int getMaxSum(int startX, int startY) {
		if(startX >= triangle.length || startY >= triangle[startX].length) return 0;
		if(cache[startX][startY] != -1) return cache[startX][startY];
		cache[startX][startY] = triangle[startX][startY] + Math.max(getMaxSum(startX+1, startY), getMaxSum(startX+1, startY+1));
		return cache[startX][startY];
	}
}
