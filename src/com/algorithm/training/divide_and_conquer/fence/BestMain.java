package com.algorithm.training.divide_and_conquer.fence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class BestMain {
	static int[] boardHeights;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/divide_and_conquer/fence/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			boardHeights = new int[scanner.nextInt()];
			for(int i = 0; i < boardHeights.length; i++) {
				boardHeights[i] = scanner.nextInt();
			}
			int maxWeight = 0;
			Stack<Integer> boards = new Stack<>();
			for(int i = 0; i < boardHeights.length; i++) {
				while(!boards.isEmpty() && boardHeights[boards.peek()] >= boardHeights[i]) {
					int j = boards.pop();
					maxWeight = Math.max(maxWeight, (i-(boards.isEmpty() ? -1 : boards.peek())-1)*boardHeights[j]);
				}
				boards.add(i);
			}
			while(!boards.isEmpty()) {
				int j = boards.pop();
				maxWeight = Math.max(maxWeight, (boardHeights.length-(boards.isEmpty() ? -1 : boards.peek())-1)*boardHeights[j]);
			}
			System.out.println(maxWeight);
		}
	}
}
