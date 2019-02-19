package com.algorithm.training.dynamic_programming.search_maze;

import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static char[][] board;
	static int[][] visit;
	static int[][] cache;
	static int n, m;
	public static void main(String[] args) {
		String path = "src/com/algorithm/training/dynamic_programming/search_maze/test";
		Scanner in = null;
		try {
//			in = new Scanner(new File(path));
			in = new Scanner(new InputStreamReader(System.in));
		} catch (Exception e) {
			e.printStackTrace();
		}
		n = in.nextInt();
		m = in.nextInt();
		board = new char[n][m];
		visit = new int[n][m];
		cache = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = in.next();
			for (int j = 0; j < m; j ++) {
				board[i][j] = line.charAt(j);
				cache[i][j] = -1;
			}
		}
		System.out.println(Main.dp(0, 0));
	}
	public static int dp(int x, int y) {
		if(cache[x][y] != -1) return cache[x][y];
		
		int minCount = Integer.MAX_VALUE;
		if(x==n-1 && y == m-1) return 1;
		visit[x][y] = 1;
		if(x > 0 && board[x-1][y] == '1' && visit[x-1][y] == 0) minCount = Math.min(minCount, dp(x-1, y));
		if(y > 0 && board[x][y-1] == '1' && visit[x][y-1] == 0) minCount = Math.min(minCount, dp(x,y-1));
		if(x < n-1 && board[x+1][y] == '1' && visit[x+1][y] == 0) minCount = Math.min(minCount, dp(x+1, y));
		if(y < m-1 && board[x][y+1] == '1' && visit[x][y+1] == 0) minCount = Math.min(minCount, dp(x,y+1));
		visit[x][y] = 0;
		cache[x][y] = (minCount != Integer.MAX_VALUE ? minCount+1 : minCount);
		return cache[x][y];
	}
}
