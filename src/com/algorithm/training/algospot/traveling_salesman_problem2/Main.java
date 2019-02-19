package com.algorithm.training.exhaustive_search.traveling_salesman_problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static double cache[][];
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
			cache = new double[(int)Math.pow(2, cityNumber)][cityNumber];
			for(double[] subCache : cache) Arrays.fill(subCache, -1);
			Arrays.fill(cache[(int)Math.pow(2, cityNumber)-1], 0);
			for(int i = 0; i < cityNumber; i++) {
				for(int j = 0; j <cityNumber; j++) {
					cityDistance[i][j] = scanner.nextDouble();
				}
			}
			double minPathLength = Double.MAX_VALUE;
			for(int i = 0; i < cityNumber; i++) {
				minPathLength = Math.min(minPathLength, main.getMinPathLength((1 << i), i));
			}
			System.out.println(String.format("%.10f", minPathLength));
		}
	}
	
	public double getMinPathLength(int visit, int startPoint) {
		double minPathLength = Double.MAX_VALUE;
		if(cache[visit][startPoint] != -1) return cache[visit][startPoint];
		for(int i = 0; i < cityDistance.length; i++) {
			if( (visit & (1 << i)) == 0) {
				visit += (1<<i);
				minPathLength = Math.min(minPathLength, cityDistance[startPoint][i] + getMinPathLength(visit, i));
				visit -= (1<<i);
			}
		}
		cache[visit][startPoint] = minPathLength;
		return cache[visit][startPoint];
	}
}
