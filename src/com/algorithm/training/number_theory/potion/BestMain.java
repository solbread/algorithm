package com.algorithm.training.number_theory.potion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestMain {
	public static void main(String[] args) {
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
			int additionalPut[] = new int[recipe.length];
			for(int i = 0; i < recipe.length; i++) {
				recipe[i] = scanner.nextInt();
			}
			for(int i = 0; i < put.length; i++) {
				put[i] = scanner.nextInt();
				if(recipe[i] > put[i]) {
					additionalPut[i] = recipe[i]-put[i];
					put[i] = recipe[i];
				}
			}
			boolean cooking = true;
			double ratio = (double)put[0]/recipe[0];
			while(cooking) {
				for(int i = 0; i < recipe.length; i++) {
					int totalSpoon = (int)Math.ceil(ratio * recipe[i]);
					additionalPut[i] += totalSpoon - put[i];
					put[i] = totalSpoon;
					if(ratio != (double)put[i]/recipe[i]) {
						ratio = (double)put[i]/recipe[i];
						break;
					}
					if(i == recipe.length-1) cooking = false;
				}
			}
			for(int i = 0; i < additionalPut.length; i++) {
				System.out.print(additionalPut[i] + " ");
			}
			System.out.println();
		}
	}
}
