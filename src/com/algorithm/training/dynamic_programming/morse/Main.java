package com.algorithm.training.dynamic_programming.morse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int COMBINATION_MAX_VALUE = 1000000001;
	static int[][] combination = new int[201][201];
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/morse/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		main.setCombination();
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(main.getKthMorse(n, m, k));
		}
	}
	public void setCombination() {
		for(int i = 0; i < combination.length; i++) {
			combination[i][0] = 1;
			combination[i][i] = 1;
			for (int j = 1; j < i; j++) {
				combination[i][j] = Math.min(COMBINATION_MAX_VALUE, combination[i-1][j-1] + combination[i-1][j]);
			}
		}
	}
	public String getKthMorse(int n, int m, int k) {
		String kthMorse = "";
		if(n==0) {
			for(int i = 0; i < m; i++) {
				kthMorse += "o";
			}
		} else if(k <= combination[n+m-1][n-1]) {
			kthMorse = "-" + getKthMorse(n-1, m, k);
		} else {
			kthMorse = "o" + getKthMorse(n, m-1, k-combination[n+m-1][n-1]);
		}
		return kthMorse;
    }
}
