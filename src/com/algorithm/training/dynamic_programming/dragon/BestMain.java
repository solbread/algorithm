package com.algorithm.training.dynamic_programming.dragon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestMain {
	static String REPLACE_X = "X+YF", REPLACE_Y = "FX-Y";
	static int MAX_LENGTH = 1000000051;
	static int[] length;
	public static void main(String[] args) {
		BestMain main = new BestMain();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/dragon/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		main.setGenerationLength();
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int generation = scanner.nextInt();
			int start = scanner.nextInt();
			int strNumber  = scanner.nextInt();
			String dragonCurve = "";
			for(int i = 0; i < strNumber; i++) {
				dragonCurve += main.getKthDragonCurve("FX", generation, start+i);
			}
			System.out.println(dragonCurve);
		}
	}
	
	private char getKthDragonCurve(String str, int generation, int k) {
		if(generation == 0) return str.charAt(k-1);
		for(char c : str.toCharArray()) {
			switch (c) {
			case 'X':
			case 'Y':
				if(length[generation] < k) k-=length[generation];
				else return getKthDragonCurve(c == 'X' ? REPLACE_X : REPLACE_Y, generation-1, k); 
				break;
			default:
				if(k==1) return c;
				k--;
				break;
			}
		}
		return '-';
	}
	
	private void setGenerationLength() {
		length = new int[51];
		length[0] = 1;
		for(int i = 1; i < length.length; i++) {
			length[i] = Math.min(MAX_LENGTH, 2 * length[i-1] + 2);
		}
	}
}
