package com.algorithm.training.exhaustive_search.picnic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Set<String> friendSet;
	static boolean[] isMatched;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/exhaustive_search/picnic/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			isMatched = new boolean[scanner.nextInt()];
			int friendNumber = scanner.nextInt();
			friendSet = new HashSet<>();
			for(int i = 0; i < friendNumber; i ++) {
				int friend1 = scanner.nextInt();
				int friend2 = scanner.nextInt();
				friendSet.add(Math.min(friend1, friend2) + "," + Math.max(friend1, friend2));
			}
			System.out.println(main.getPairNumber(0));
		}
	}
	public int getPairNumber(int targetStudentNumber) {
		int pairNumber = 0;
		isMatched[targetStudentNumber] = true;
		for(int i = 0; i < isMatched.length; i++) {
			if(!isMatched[i] && friendSet.contains(Math.min(targetStudentNumber, i) + "," + Math.max(targetStudentNumber, i))) {
				isMatched[i] = true;
				if(findAllPair()) pairNumber++;
				else {
					for(int j = 0; j < isMatched.length; j++) {
						if(!isMatched[j]) {
							pairNumber += getPairNumber(j);
							break;
						}
					}
				}
				isMatched[i] = false;
			}
		}
		isMatched[targetStudentNumber] = false;
 		return pairNumber;
	}
	
	private boolean findAllPair() {
		for(int i = 0; i < isMatched.length; i++) {
			if(!isMatched[i]) return false;
		}
		return true;
	}
}
