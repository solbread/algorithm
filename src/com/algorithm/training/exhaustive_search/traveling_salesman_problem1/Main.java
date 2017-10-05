package com.algorithm.training.exhaustive_search.traveling_salesman_problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static double[][] cityDistance;
	static boolean[] isVisited;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/exhaustive_search/traveling_salesman_problem1/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int cityNumber = scanner.nextInt();
			cityDistance = new double[cityNumber][cityNumber];
			isVisited = new boolean[cityNumber];
			for(int i = 0; i < cityNumber; i++) {
				for(int j = 0; j <cityNumber; j++) {
					cityDistance[i][j] = scanner.nextDouble();
				}
			}
			double minPathLength = Double.MAX_VALUE;
			for(int i = 0; i < cityNumber; i++) {
				isVisited[i] = true;
				minPathLength = Math.min(minPathLength, main.getMinPathLength(i));
				isVisited[i] = false;
			}
			System.out.println(String.format("%.10f", minPathLength));
		}
	}
	
	public double getMinPathLength(int currentCity) {
		double minPathLength = Double.MAX_VALUE;
		if(allCityVisited()) return 0;
		for(int i = 0; i < isVisited.length; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				minPathLength = Math.min(minPathLength, cityDistance[currentCity][i] + getMinPathLength(i));
				isVisited[i] = false;
			}
		}
		return minPathLength;
	}
	
	private boolean allCityVisited() {
		for(int i = 0; i < isVisited.length; i++) {
			if(!isVisited[i]) return false;
		}
		return true;
	}
}
