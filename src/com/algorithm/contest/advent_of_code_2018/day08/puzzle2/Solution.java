package com.algorithm.contest.advent_of_code_2018.day08.puzzle2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public static void main(String[] args) {
		try(FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day08/puzzle2/input");
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			String line = bufferedReader.readLine();
			String numbers[] = line.split(" ");
			int i = 0;
			Deque<int[][]> deque = new ArrayDeque<>();
			int sumOfMetadatas = 0;
			while(i < numbers.length) {
				if(deque.isEmpty()) {
					int childNumber = Integer.parseInt(numbers[i++]);
					int metaNumber = Integer.parseInt(numbers[i++]);
					deque.add(new int[childNumber+1][3]);
					deque.peekLast()[0][0] = childNumber;
					deque.peekLast()[0][1] = metaNumber;
					deque.peekLast()[0][2] = childNumber;
				} else {
					int[][] info = deque.peekLast();
					if(info[0][0] == 0) {
						int[][] removedNode = deque.removeLast();
						int curSum = 0;
						for(int j = 0; j < info[0][1]; j++) {
							int meta = Integer.parseInt(numbers[i++]);
							if(removedNode[0][2] == 0) {
								curSum += meta;
							} else if(meta <= removedNode[0][2]){
								curSum += removedNode[meta][0];
							}
						}
						sumOfMetadatas = curSum;
						int[][] parent = deque.peekLast();
						for(int j = 1; parent != null && j < parent.length; j++) {
							if(parent[j][0] == 0) {
								parent[j][0] = curSum;
								break;
							}
						}
					} else {
						info[0][0]--;
						int childNumber = Integer.parseInt(numbers[i++]);
						int metaNumber = Integer.parseInt(numbers[i++]);
						deque.add(new int[childNumber+1][3]);
						deque.peekLast()[0][0] = childNumber;
						deque.peekLast()[0][1] = metaNumber;
						deque.peekLast()[0][2] = childNumber;
					}
				}
			}
			System.out.println(sumOfMetadatas);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
