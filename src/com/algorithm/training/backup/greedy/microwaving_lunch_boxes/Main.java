package com.algorithm.training.greedy.microwaving_lunch_boxes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/greedy/microwaving_lunch_boxes/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int heatTime[] = new int[scanner.nextInt()];
			Queue<Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (b.getKey() - a.getKey()));
			for(int i = 0; i < heatTime.length; i++) {
				heatTime[i] = scanner.nextInt();
			}
			for(int i = 0; i < heatTime.length; i++) {
				heap.add(new AbstractMap.SimpleEntry<>(scanner.nextInt(), heatTime[i]));
			}
			int minTime = 0, remainedTime = 0;
			while(!heap.isEmpty()) {
				Entry<Integer, Integer> lunchbox = heap.poll();
				int totalTime = lunchbox.getKey() + lunchbox.getValue();
				if(remainedTime < totalTime) {
					minTime += (totalTime - remainedTime);
					remainedTime = totalTime;
				}
				remainedTime -= lunchbox.getValue();
			}
			System.out.println(minTime);
		}
	}
}