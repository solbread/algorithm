package com.algorithm.training.greedy.matchorder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/greedy/matchorder/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int[] russian = new int[scanner.nextInt()];
			int[] korean = new int[russian.length];
			for(int i = 0; i < russian.length; i++) {
				russian[i] = scanner.nextInt();
			}
			for(int i = 0; i < korean.length; i++) {
				korean[i] = scanner.nextInt();
			}
			Arrays.sort(russian);
			Arrays.sort(korean);
			int koreanIndex = korean.length-1, winCount = 0;
			for(int i = russian.length-1; i >= 0; i--) {
				if(russian[i] <= korean[koreanIndex]) {
					winCount++;
					koreanIndex--;
				}
			}
			System.out.println(winCount);
		}
	}
}