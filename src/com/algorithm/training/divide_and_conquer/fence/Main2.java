package com.algorithm.training.divide_and_conquer.fence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {
	static int[] boardHeights;
	public static void main(String[] args) {
		Main2 main = new Main2();
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
			System.out.println(main.getMaxWeight(0, boardHeights.length-1));
		}
	}
	
	public int getMaxWeight(int head, int tail) {
		int maxWeight = -1, mid = (head+tail)/2, left = mid, right = mid, minHeight = boardHeights[mid];
		if(head == tail) return boardHeights[left];
		maxWeight = Math.max(getMaxWeight(head, mid), getMaxWeight(mid+1, tail));
		while(left > head || right < tail) {
			if(left <= head || (right < tail && boardHeights[left-1] <= boardHeights[right+1])) {
				minHeight = Math.min(minHeight, boardHeights[++right]);
			} else {
				minHeight = Math.min(minHeight, boardHeights[--left]);
			}
			maxWeight = Math.max(maxWeight, (right-left+1) * minHeight);
		}
		return maxWeight;
	}
}
