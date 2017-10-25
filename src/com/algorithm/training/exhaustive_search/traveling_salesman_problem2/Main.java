package com.algorithm.training.exhaustive_search.traveling_salesman_problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static double[][] cityDistance;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/exhaustive_search/traveling_salesman_problem2/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int cityNumber = scanner.nextInt();
			cityDistance = new double[cityNumber][cityNumber];
			for(int i = 0; i < cityNumber; i++) {
				for(int j = 0; j <cityNumber; j++) {
					cityDistance[i][j] = scanner.nextDouble();
				}
			}
			double minPathLength = Double.MAX_VALUE;
			//구현
			System.out.println(String.format("%.10f", minPathLength));
		}
	}
}
