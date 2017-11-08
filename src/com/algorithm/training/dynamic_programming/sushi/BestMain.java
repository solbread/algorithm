package com.algorithm.training.dynamic_programming.sushi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestMain {
	static int[][] shusi;
	public static void main(String[] args) {
		BestMain main = new BestMain();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/sushi/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			shusi = new int[scanner.nextInt()][2];
			int budget = scanner.nextInt();
			for(int i = 0; i < shusi.length; i++) {
				for(int j = 0; j < shusi[i].length; j++) {
					shusi[i][j] = scanner.nextInt();
				}
			}
			
		}
	}
}
