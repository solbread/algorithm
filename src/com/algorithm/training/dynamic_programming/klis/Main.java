package com.algorithm.training.dynamic_programming.klis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int[] numbers;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/klis/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			numbers = new int[scanner.nextInt()];
			int k = scanner.nextInt();
			for(int i = 0; i < numbers.length; i++) {
				numbers[i] = scanner.nextInt();
			}
			
		}
	}
}
