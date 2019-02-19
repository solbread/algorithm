package com.algorithm.training.combinatorial_search.allergy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static long[] canEatFoodList;
	static int foodNumber, minFoodCount;
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/com/algorithm/training/combinatorial_search/allergy/test"))));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		int cases = Integer.parseInt(bufferedReader.readLine());
		StringTokenizer stringTokenizer;
		while(cases-- > 0) {
			minFoodCount = 50;
			stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
			Map<String, Integer> friendMap = new HashMap<>();
			int friendNubmer = Integer.parseInt(stringTokenizer.nextToken());
			foodNumber = Integer.parseInt(stringTokenizer.nextToken());
			stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
			for(int i = 0; i < friendNubmer; i++) {
				friendMap.put(stringTokenizer.nextToken(), i);
			}
			canEatFoodList = new long[friendNubmer];
			for(int i = 0; i < foodNumber; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
				stringTokenizer.nextToken();
				while(stringTokenizer.hasMoreTokens()) {
					canEatFoodList[friendMap.get(stringTokenizer.nextToken())] |= (1<<i);
				}
			}
			main.setMinFoodCount(0, 0, 0);
			System.out.println(minFoodCount);
		}
	}
	
	public void setMinFoodCount(int friendNumber, int makeFood, int currentFoodCount) {
		if(friendNumber >= canEatFoodList.length) {
			minFoodCount = Math.min(minFoodCount, currentFoodCount);
			return;
		}
		if( (makeFood & canEatFoodList[friendNumber]) > 0) {
			setMinFoodCount(friendNumber+1, makeFood, currentFoodCount);
			return;
		} 
		if(currentFoodCount+1 >= minFoodCount) return;
		long canEatFood = canEatFoodList[friendNumber];
		for(int i = 0; i < foodNumber; i++) {
			if((canEatFood & (1<<i)) > 0) {
				setMinFoodCount(friendNumber+1, makeFood|(1<<i), currentFoodCount+1);
			}				
		}
	}
}
