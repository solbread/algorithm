package com.algorithm.training.dynamic_programming.pi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static char[] subPi;
	static int[] cache;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/pi/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			subPi = scanner.next().toCharArray();
			cache = new int[subPi.length];
			for(int i = 0; i < cache.length; i++) {
				cache[i] = -1;
			}
			System.out.println(main.getMinScore(0));
		}
	}
	public int getMinScore(int start) {
		if(start == subPi.length) return 0;
		if(cache[start] != -1) return cache[start];
		int minScore = 20001;
		for(int i = 3; i <= 5 && start+i <= subPi.length; i ++) {
			minScore = Math.min(minScore, getCurrentScore(start, start+i-1) + getMinScore(start+i));
		}
		cache[start] = minScore;
		return cache[start];
	}
	
	private int getCurrentScore(int start, int end) {
		int currentScore = 0;
		boolean isAllSame = true, isProgressive = true, isAlternated = true;
		for(int i = start; i < end; i++) {
			if(subPi[i] != subPi[i+1]) isAllSame = false;
			if(subPi[i+1]-subPi[i] != subPi[start+1]-subPi[start]) isProgressive = false;
			if(i+2 < subPi.length && subPi[i] != subPi[i+2]) isAlternated = false;
		}
		currentScore = (isAllSame) ? 1 : (isProgressive ? (Math.abs(subPi[start+1]-subPi[start]) == 1 ? 2 : 5) : (isAlternated ? 4 : 10));
		return currentScore;
	}
}
