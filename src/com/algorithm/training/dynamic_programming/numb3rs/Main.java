package com.algorithm.training.dynamic_programming.numb3rs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int townPaths[][];
	static double townProbability[];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/numb3rs/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int townNumber = scanner.nextInt();
			int day = scanner.nextInt();
			int prison = scanner.nextInt();
			townPaths = new int[townNumber][townNumber+1];
			townProbability = new double[townNumber];
			townProbability[prison] = 1.0;
			for(int i = 0; i < townPaths.length; i++) {
				for(int j = 0; j < townPaths.length; j++) {
					townPaths[i][j] = scanner.nextInt();
					if(townPaths[i][j] == 1) townPaths[i][townNumber]++;
				}
			}
			while(day-- > 0) {
				double[] tmpTownProbability = new double[townNumber];
				for(int i = 0; i < townPaths.length; i++) {
					for(int j = 0; j < townPaths.length; j++) {
						tmpTownProbability[j] += (townProbability[i] * townPaths[i][j] / townPaths[i][townNumber]);
					}
				}
				townProbability = tmpTownProbability;
			}
			int targetTownNumber = scanner.nextInt();
			for(int i = 0; i < targetTownNumber; i++) {
				System.out.print((i != 0 ? " " : "") + townProbability[scanner.nextInt()]);
			}
			System.out.println();
		}
	}
}
