package com.algorithm.training.number_theory.potion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestMain2 {
	public static void main(String[] args) {
		BestMain2 main = new BestMain2();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/number_theory/potion/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int recipe[] = new int[scanner.nextInt()];
			int put[] = new int[recipe.length];
			for(int i = 0; i < recipe.length; i++) {
				recipe[i] = scanner.nextInt();
			}
			for(int i = 0; i < put.length; i++) {
				put[i] = scanner.nextInt();
			}
			int gcd = main.getGCD(recipe);
			double maxRatio = 1;
			for(int i = 0; i < recipe.length; i++) {
				maxRatio = Math.max(maxRatio, Math.ceil((double)put[i]/recipe[i]*gcd) / gcd); 
			}
			for(int i = 0; i < recipe.length; i++) {
				System.out.print((int)(maxRatio*recipe[i]) - put[i] + " ");
			}
			System.out.println();
		}
	}
	public int getGCD(int[] numbers) {
		int gcd = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			gcd = getGCD(gcd, numbers[i]);
		}
		return gcd;
	}
	
	public int getGCD(int p, int q) {
		if(q == 0) return p;
		return getGCD(q, p%q);
	}
}
