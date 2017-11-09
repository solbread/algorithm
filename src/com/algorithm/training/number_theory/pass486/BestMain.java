package com.algorithm.training.number_theory.pass486;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/number_theory/pass486/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int[] minFactor = new int[10000001];
		int[] minFactorPow = new int[10000001];
		int[] factorNumber = new int[10000001];
		minFactor[0] = minFactor[1] = -1;
		for(int i = 2; i < minFactor.length; i++) {
			minFactor[i] = i;
		}
		for(int i = 2; i <= (int)Math.sqrt(minFactor.length); i++) {
			if(minFactor[i] == i) {
				for(int j = i*i; j < minFactor.length; j+=i) {
					if(minFactor[j] == j) {
						minFactor[j] = i;
					}
				}
			}
		}
		for (int i = 2; i < minFactor.length; i++) {
			if(minFactor[i] == i) {
				minFactorPow[i] = 1;
				factorNumber[i] = 2;
			} else {
				int m =  i / minFactor[i];
//				minFactorPow[i] = minFactorPow[m] + 1; //추후 확인할 것 
				if(minFactor[i] != minFactor[m]) {
					minFactorPow[i] = 1;
				} else {
					minFactorPow[i] = (minFactorPow[m] + 1);
				}
				factorNumber[i] = (factorNumber[m] / minFactorPow[i]) * (minFactorPow[i] + 1);
			}
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int divisorNumber = scanner.nextInt();
			int low = scanner.nextInt();
			int high = scanner.nextInt();
			int passwordCount = 0;
			for(int i = low; i <= high; i++) {
				if(factorNumber[i] == divisorNumber) passwordCount++; 
			}
			System.out.println(passwordCount);
		}
	}
}
