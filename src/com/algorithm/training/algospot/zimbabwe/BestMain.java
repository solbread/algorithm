package com.algorithm.training.dynamic_programming.zimbabwe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BestMain {
	static String currentEggCost, sortedEggCost;
	static int[][][] cache;
	static int m, MOD_VALUE = 1000000007;
	public static void main(String[] args) {
		BestMain main = new BestMain();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/zimbabwe/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			currentEggCost = scanner.next();
			sortedEggCost = main.sortEggCost();
			m = scanner.nextInt();
			cache = new int[(int)Math.pow(2, currentEggCost.length())][m][2];
			for(int[][] midCache : cache) {
				for(int[] bottomCahce : midCache) {
					Arrays.fill(bottomCahce, -1);
				}
			}
			for(int i = 0; i < m; i++) {
				int fillValue = i == 0 ? 1 : 0;
				cache[ (1 << currentEggCost.length()) -1][i][0] = 0;
				cache[ (1 << currentEggCost.length()) -1][i][1] = fillValue;
			}
			System.out.println(main.getEggCostCount(0, 0, 0, 0));
		}
	}	
	public String sortEggCost() {
		String sortedEggCost = "";
		int numbers[] = new int[currentEggCost.length()];
		for(int i = 0; i < currentEggCost.length(); i++) {
			numbers[i] = Character.getNumericValue(currentEggCost.charAt(i));
		}
		Arrays.sort(numbers);
		for(int number : numbers) {
			sortedEggCost += String.valueOf(number);
		}
		return sortedEggCost;
	}
	public int getEggCostCount(int visit, int currentIndex, int remained, int isSmall ) {
 		if(cache[visit][remained][isSmall] != -1) return cache[visit][remained][isSmall];
		int eggCostCount = 0;
		for(int i = 0; i < currentEggCost.length(); i++) {
			if( (visit & (1<<i)) == 0 
					&& (isSmall == 1 || currentEggCost.charAt(currentIndex) >= sortedEggCost.charAt(i))
					&& (i == 0 || sortedEggCost.charAt(i-1) != sortedEggCost.charAt(i) || (visit & (1 << i-1)) != 0 )) {
				visit += (1 << i);
				eggCostCount += getEggCostCount(visit, currentIndex+1, (remained*10 + Character.getNumericValue(sortedEggCost.charAt(i)))%m , (isSmall == 1 || currentEggCost.charAt(currentIndex) > sortedEggCost.charAt(i) ? 1 : 0));
				visit -= (1 << i);
			}
		}
		cache[visit][remained][isSmall] = eggCostCount % MOD_VALUE;
		return cache[visit][remained][isSmall];
	}
}