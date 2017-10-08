package com.algorithm.training.dynamic_programming.lis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/lis/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int numbers[] = new int[scanner.nextInt()];
			int dp[] = new int[numbers.length];
			int maxLength = 0;
			for(int i = 0; i < numbers.length; i++) {
				numbers[i] = scanner.nextInt();
				dp[i] = 1;
			}
			for(int i = 0; i < numbers.length; i++) {
				for(int j = 0; j < i; j++) {
					if(numbers[i] > numbers[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				maxLength = Math.max(maxLength, dp[i]);
			}
			System.out.println(maxLength);
		}
	}
}
