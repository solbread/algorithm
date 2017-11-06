package com.algorithm.training.number_theory.pass486;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/number_theory/pass486/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int[] factorNumber = new int[10000001];
		for(int i = 2; i < factorNumber.length; i++) {
			for(int j = i * 2; j < factorNumber.length; j+=i) {
				factorNumber[j]++;
			}
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int divisorNumber = scanner.nextInt();
			int low = scanner.nextInt();
			int high = scanner.nextInt();
			int passwordCount = 0;
			for(int i = low; i <= high; i++) {
				if(factorNumber[i]+2 == divisorNumber) passwordCount++; 
			}
			System.out.println(passwordCount);
		}
	}
}
