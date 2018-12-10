package com.algorithm.contest.advent_of_code_2018.day08.puzzle1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public static void main(String[] args) {
		try(FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day08/puzzle1/input");
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			String line = bufferedReader.readLine();
			String numbers[] = line.split(" ");
			int i = 0;
			Deque<int[]> deque = new ArrayDeque<>();
			int sumOfMetadatas = 0;
			while(i < numbers.length) {
				if(deque.isEmpty()) {
					deque.add(new int[] {Integer.parseInt(numbers[i++]), Integer.parseInt(numbers[i++])});
				} else {
					int[] info = deque.peekLast();
					if(info[0] == 0) {
						deque.removeLast();
						for(int j = 0; j < info[1]; j++) {
							sumOfMetadatas += (Integer.parseInt(numbers[i++]));
						}
					} else {
						info[0]--;
						deque.add(new int[] {Integer.parseInt(numbers[i++]), Integer.parseInt(numbers[i++])});
					}
				}
			}
			System.out.println(sumOfMetadatas);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
