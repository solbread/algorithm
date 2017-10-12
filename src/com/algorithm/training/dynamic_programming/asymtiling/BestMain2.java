package com.algorithm.training.dynamic_programming.asymtiling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestMain2 {
	static final int MOD_VALUE = 1000000007;
	static int[] tilingCache;
	static int[] asymmetricCache;
	public static void main(String[] args) {
		BestMain2 main = new BestMain2();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/asymtiling/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int width = scanner.nextInt();
			tilingCache = new int[width];
			asymmetricCache = new int[width];
			for(int i = 0; i < width; i++) {
				tilingCache[i] = -1;
				asymmetricCache[i] = -1;
			}
			System.out.println(main.getAsymmetricCount(width));
		}
	}
	
	public int getAsymmetricCount(int width) {
		if(width <= 2) return 0;
		if(asymmetricCache[width-1] != -1) return asymmetricCache[width-1];
		int asymmetricCount = getAsymmetricCount(width-2) % MOD_VALUE;
		asymmetricCount = (asymmetricCount + getAsymmetricCount(width-4)) % MOD_VALUE;
		asymmetricCount = (asymmetricCount + getTilingCount(width-3)) % MOD_VALUE;
		asymmetricCount = (asymmetricCount + getTilingCount(width-3)) % MOD_VALUE;
		asymmetricCache[width-1] =  asymmetricCount;
		return asymmetricCache[width-1];
	}
	
	public int getTilingCount(int n) {
		if(n <= 1) return 1;
		if(tilingCache[n-1] != -1) return tilingCache[n-1];
		int tilingCount = (getTilingCount(n-1) + getTilingCount(n-2)) % MOD_VALUE;
		tilingCache[n-1] = tilingCount;
		return tilingCache[n-1];
	}
}
