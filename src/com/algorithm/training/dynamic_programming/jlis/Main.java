package com.algorithm.training.dynamic_programming.jlis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int[] numbers1, numbers2;
	static int[][] cache;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/jlis/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			numbers1 = new int[scanner.nextInt()];
			numbers2 = new int[scanner.nextInt()];
			cache = new int[numbers1.length+1][numbers2.length+1];
			for(int i = 0; i < cache.length; i++) {
				for(int j = 0; j < cache[i].length; j++) {
					cache[i][j] = -1;
				}
			}
			for(int i = 0; i < numbers1.length; i++) {
				numbers1[i] = scanner.nextInt();
			}
			for(int i = 0; i < numbers2.length; i++) {
				numbers2[i] = scanner.nextInt();
			}
			System.out.println(main.getJLISLength(-1, -1)-2);
		}
	}
	
	public int getJLISLength(int start1, int start2) {
		if(cache[start1+1][start2+1] != -1) return cache[start1+1][start2+1];
		int jlisLength = 2;
		long maxValue = Math.max(start1 == -1 ? Long.MIN_VALUE : numbers1[start1], 
				start2 == -1 ? Long.MIN_VALUE : numbers2[start2]);
		for(int i = start1+1; i < numbers1.length; i++) {
			if(maxValue < numbers1[i]) {
				jlisLength = Math.max(jlisLength, getJLISLength(i, start2) + 1);
			}
		}
		for(int i = start2+1; i < numbers2.length; i++) {
			if(maxValue < numbers2[i]) {
				jlisLength = Math.max(jlisLength, getJLISLength(start1, i) + 1);
			}
		}
		cache[start1+1][start2+1] = jlisLength;
		return cache[start1+1][start2+1];
	}
}
