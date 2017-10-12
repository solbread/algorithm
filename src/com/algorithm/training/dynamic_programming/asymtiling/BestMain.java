package com.algorithm.training.dynamic_programming.asymtiling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestMain {
	static final int MOD_VALUE = 1000000007;
	static int[] tilingCache;
	static int[] asymmetricCache;
	public static void main(String[] args) {
		BestMain main = new BestMain();
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
			for(int i = 0; i < tilingCache.length; i++) {
				tilingCache[i] = -1;
				asymmetricCache[i] = -1;
			}
			System.out.println(main.getAsymmetricCount(width));
		}
	}
	
	public int getAsymmetricCount(int width) {
		if(width < 2) return 0;
		if(asymmetricCache[width-1] != -1) return asymmetricCache[width-1];
		int tilingCount = getTilingCount(width);
		if(width % 2 == 0) {
			asymmetricCache[width-1] = (tilingCount - getTilingCount((width-2)/2) + MOD_VALUE) % MOD_VALUE;
			asymmetricCache[width-1] = (asymmetricCache[width-1] - getTilingCount(width/2) + MOD_VALUE) % MOD_VALUE;
		} else {
			asymmetricCache[width-1] = (tilingCount - getAsymmetricCount(width/2) + MOD_VALUE) % MOD_VALUE;
		}
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
