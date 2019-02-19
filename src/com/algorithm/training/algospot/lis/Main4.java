package com.algorithm.training.dynamic_programming.lis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main4 {
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
			int subNumbers[] = new int[numbers.length];
			int subNumbersSize = 0;
			for(int i = 0; i < numbers.length; i++) { 
				numbers[i] = scanner.nextInt();
			}
			for(int i = 0; i < numbers.length; i++) {
				if(subNumbersSize == 0) {
					subNumbers[subNumbersSize++] = numbers[i];
				} else {
					//using lower bound
					int left = 0, right = subNumbersSize;
					while(left < right) {
						int mid = (left+right) / 2;
						if(subNumbers[mid] < numbers[i]) left = mid + 1;
						else right = mid;
					}
					subNumbers[right] = numbers[i];
					if(right == subNumbersSize) subNumbersSize++;
				}
			}
			System.out.println(subNumbersSize);
		}
	}
}
