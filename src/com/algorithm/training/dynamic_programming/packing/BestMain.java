package com.algorithm.training.dynamic_programming.packing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BestMain {
	static String[] itemNames;
	static int[] itemWeights;
	static int[] itemScores;
	static int[][] cache;
	public static void main(String[] args) {
		BestMain main = new BestMain();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/packing/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int itemNumber = scanner.nextInt();
			int weightLimit = scanner.nextInt();
			cache = new int[weightLimit+1][itemNumber];
			for(int[] subCache : cache) Arrays.fill(subCache, -1);
			itemNames = new String[itemNumber];
			itemWeights = new int[itemNumber];
			itemScores = new int[itemNumber];
			for(int i = 0; i < itemNumber; i++) {
				itemNames[i] = scanner.next();
				itemWeights[i] = scanner.nextInt();
				itemScores[i] = scanner.nextInt();
			}
			int maxScore = main.getMaxScore(weightLimit, 0);
			List<String> packedItemList = main.getPackedItemList(weightLimit, 0);

			System.out.println(maxScore + " " + packedItemList.size());
			for(String packedItem : packedItemList) {
				System.out.println(packedItem);
			}
		}
	}
	public int getMaxScore(int remainedWeight, int targetItem) {
		if(targetItem == itemNames.length) return 0;
		if(cache[remainedWeight][targetItem] != -1) return cache[remainedWeight][targetItem];
		int maxScore = 0;
		if(remainedWeight >= itemWeights[targetItem]) {
			maxScore = itemScores[targetItem] + getMaxScore(remainedWeight - itemWeights[targetItem], targetItem+1);
		}
		maxScore = Math.max(maxScore, getMaxScore(remainedWeight, targetItem+1));
		return maxScore;
	}
	
	public List<String> getPackedItemList(int weightLimit, int targetItem) {
		List<String> packedItemList = new ArrayList<>();
		if(targetItem == itemNames.length) return packedItemList;
		if(getMaxScore(weightLimit, targetItem) == getMaxScore(weightLimit, targetItem+1)) {
			packedItemList.addAll(getPackedItemList(weightLimit, targetItem+1));
		} else {
			packedItemList.add(itemNames[targetItem]);
			packedItemList.addAll(getPackedItemList(weightLimit-itemWeights[targetItem], targetItem+1));
		}
		return packedItemList;
	}
}
