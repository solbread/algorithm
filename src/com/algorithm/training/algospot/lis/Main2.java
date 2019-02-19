package com.algorithm.training.dynamic_programming.lis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {
	static int numbers[], cache[];
	public static void main(String[] args) {
		Main2 main = new Main2();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/lis/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			numbers = new int[scanner.nextInt()];
			cache = new int[numbers.length+1];
			for(int i = 0; i < numbers.length; i++) {
				numbers[i] = scanner.nextInt();
				cache[i] = -1;
			}
			cache[numbers.length] = -1;
			System.out.println(main.getMaxLength(-1)-1);
		}
	}
	
	public int getMaxLength(int startPoint) {
		if(cache[startPoint+1] != -1) return cache[startPoint+1];
		int maxLength = 1;
		for(int i = startPoint+1; i < numbers.length; i++) {
			if(startPoint == -1 || numbers[startPoint] < numbers[i]) {
				maxLength = Math.max(maxLength, getMaxLength(i)+1);
			}
		}
		cache[startPoint+1] = maxLength;
		return cache[startPoint+1];
	}
}
