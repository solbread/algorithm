package com.algorithm.training.dynamic_programming.sushi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/sushi/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int shusi[][] = new int[scanner.nextInt()][2];
			int dp[] = new int[201];
			int budget = scanner.nextInt() / 100;
			for(int i = 0; i < shusi.length; i++) {
				for(int j = 0; j < shusi[i].length; j++) {
					shusi[i][j] = scanner.nextInt();
					if(j==0) shusi[i][j] /= 100;
				}
			}
			for(int i = 1; i <= budget; i++) {
			    for(int j = 0; j < shusi.length; j++) {
			        if(i >= shusi[j][0]) {
			            dp[i%201] = Math.max(dp[i%201], dp[(i-shusi[j][0])%201] + shusi[j][1]);
			        }
			    }
			}
			System.out.println(dp[budget%201]);
		}
	}
}
