package com.algorithm.training.combinatorial_search.allergy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2 {
	static List<List<Integer>> canEatFoodList;
	static boolean[] makeFood, makeFoodForFriend;
	static int minFoodCount;
	public static void main(String[] args) throws IOException {
		Main2 main = new Main2();
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
			int foodNumber = Integer.parseInt(stringTokenizer.nextToken());
			
			makeFoodForFriend = new boolean[friendNubmer];
			makeFood = new boolean[foodNumber];
			canEatFoodList = new ArrayList<>();
			stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
			for(int i = 0; i < friendNubmer; i++) {
				friendMap.put(stringTokenizer.nextToken(), i);
				canEatFoodList.add(new ArrayList<>());
			}
			for(int i = 0; i < foodNumber; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
				stringTokenizer.nextToken();
				while(stringTokenizer.hasMoreTokens()) {
					canEatFoodList.get(friendMap.get(stringTokenizer.nextToken())).add(i);
				}
			}
			main.setMinFoodCount(0);
			System.out.println(minFoodCount);
		}
	}
	
	public void setMinFoodCount(int currentFoodCount) {
		if(finishCookingForAllFriend()) {
			minFoodCount = Math.min(minFoodCount, currentFoodCount);
		}
		if(currentFoodCount >= minFoodCount) return;
		
		int targetFriend = -1;
		for(int i = 0; i < canEatFoodList.size(); i++) {
			if(!makeFoodForFriend[i] && (targetFriend == -1 || canEatFoodList.get(i).size() < canEatFoodList.get(targetFriend).size())) {
				targetFriend = i;
			}
		}
		
		List<Integer> foodList = canEatFoodList.get(targetFriend);
		makeFoodForFriend[targetFriend] = true;
		if(mustMakeFood(foodList)) {
			for(int food : foodList) {
				makeFood[food] = true;
				setMinFoodCount(currentFoodCount+1);
				makeFood[food] = false;
			}
		} else {
			setMinFoodCount(currentFoodCount);
		}
		makeFoodForFriend[targetFriend] = false;
	}
	
	private boolean finishCookingForAllFriend() {
		for(boolean makeFood : makeFoodForFriend) {
			if(!makeFood) return false;
		}
		return true;
	}
	
	private boolean mustMakeFood(List<Integer> foodList) {
		for(int food : foodList) {
			if(makeFood[food]) return false;
		}
		return true;
	}
}
