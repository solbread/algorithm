package com.algorithm.training.dynamic_programming.snail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int wellDepth;
	static double[][] cache;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/snail/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			wellDepth = scanner.nextInt();
			int monsoonDuration = scanner.nextInt();
			cache = new double[2 * monsoonDuration+1][monsoonDuration];
			for(double[] row :cache) Arrays.fill(row, -1);
			System.out.println(main.getEscapeProbaility(0, monsoonDuration));
		}
	}
	public double getEscapeProbaility(int currentDepth, int remainDuration) {
		if(remainDuration == 0) return currentDepth >= wellDepth ? 1 : 0;
		if(cache[currentDepth][remainDuration-1] != -1) return cache[currentDepth][remainDuration-1];
		cache[currentDepth][remainDuration-1] = (0.25 * getEscapeProbaility(currentDepth+1, remainDuration-1)) + (0.75 * getEscapeProbaility(currentDepth+2, remainDuration-1));
		return cache[currentDepth][remainDuration-1];
	}
}
