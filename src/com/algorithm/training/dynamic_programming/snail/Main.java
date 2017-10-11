package com.algorithm.training.dynamic_programming.snail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int[][] cache;
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
			int wellDepth = scanner.nextInt();
			int monsoonDuration = scanner.nextInt();
			cache = new int[wellDepth][monsoonDuration];
			System.out.println(main.getEscapeProbaility(wellDepth, monsoonDuration));
		}
	}
	public double getEscapeProbaility(int remainDepth, int remainDuration) {
		if(remainDuration == 0) return remainDepth <= 0 ? 1 : 0;
		return (0.25 * getEscapeProbaility(remainDepth-1, remainDuration-1)) + (0.75 * getEscapeProbaility(remainDepth-2, remainDuration-1));
	}
}
