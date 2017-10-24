package com.algorithm.training.greedy.minastirith;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/greedy/strjoin/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			double[][] checkPointInfo = new double[scanner.nextInt()][3];
			for(int i = 0; i < checkPointInfo.length; i++) {
				checkPointInfo[i][0] = scanner.nextDouble();
				checkPointInfo[i][1] = scanner.nextDouble();
				checkPointInfo[i][2] = scanner.nextDouble();
			}
		}
	}
}