package com.algorithm.training.queue.ites;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static long currentSeed = 1983;
	public static final long MOD_VALUE = (long)Math.pow(2, 32);
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/queue/ites/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			currentSeed = 1983;
			Queue<Integer> queue = new LinkedList<>();
			int targetSum = scanner.nextInt();
			int signalNumber = scanner.nextInt();
			int ret = 0;
			int currentSum = main.getSignal();
			queue.add(currentSum);
			for(int i = 1; i < signalNumber; i++) {
				int signal = main.getSignal();
				queue.add(signal);
				currentSum += signal;
				while(currentSum > targetSum) {
					currentSum -= queue.poll();
				}
				if(currentSum == targetSum) ret++;
			}
			System.out.println(ret);
		}
	}
	public int getSignal() {
		int signal = (int)(currentSeed % 10000) + 1;
		currentSeed = (currentSeed * 214013 + 2531011) % MOD_VALUE;
		return signal;
	}
}