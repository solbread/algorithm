package com.algorithm.training.greedy.strjoin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/greedy/strjoin/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			Queue<Integer> queue = new PriorityQueue<>((a, b) -> a-b);
			int strNumber = scanner.nextInt();
			for(int i = 0; i < strNumber; i++) {
				queue.add(scanner.nextInt());
			}
			int minCost = 0;
			while(queue.size() > 1) {
				int currentCost = queue.poll() + queue.poll();
				minCost += currentCost;
				queue.add(currentCost);
			}
			System.out.println(minCost);
		}
	}
}