package com.algorithm.training.divide_and_conquer.fence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
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
			int maxWeight = -1;
			for(int i = 0; i < boardHeights.length; i++) {
				int left = i, right = left, currentMinHeight = boardHeights[i];
				maxWeight = Math.max(maxWeight, boardHeights[i]);
				while(left > 0 || right < boardHeights.length-1) {
					if((left <= 0 && right < boardHeights.length-1) || (right < boardHeights.length -1 && boardHeights[left-1] < boardHeights[right+1])) {
						right++;
						currentMinHeight = Math.min(currentMinHeight, boardHeights[right]);
					} else if((left > 0 && right >= boardHeights.length-1) || (left > 0 && boardHeights[left-1] >= boardHeights[right+1])) {
						left--;
						currentMinHeight = Math.min(currentMinHeight, boardHeights[left]);
					}
					maxWeight = Math.max(maxWeight, Math.max(Math.max(boardHeights[left], boardHeights[right]), currentMinHeight * (right - left + 1)));
				}
				
			}
			System.out.println(maxWeight);
		}
	}
}
