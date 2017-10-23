package com.algorithm.training.dynamic_programming.klis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int[] numbers;
	static int[] lisCache;
	static double[] countCache;
	static Map<Integer, int[]> lengthIndexMap;
	static double K_MAX = (double)Integer.MAX_VALUE + 1;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/klis/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			lengthIndexMap = new HashMap<>();
			numbers = new int[scanner.nextInt()];
			lisCache = new int[numbers.length+1];
			countCache = new double[numbers.length+1];
			Arrays.fill(lisCache, -1);
			Arrays.fill(countCache, -1);
			int k = scanner.nextInt();
			for(int i = 0; i < numbers.length; i++) {
				numbers[i] = scanner.nextInt();
				lengthIndexMap.put(i+1, new int[100001]);
				Arrays.fill(lengthIndexMap.get(i+1), -1);
			}
			int maxLength = getMaxLength(-1)-1;
			System.out.println(maxLength);
			List<Integer> resultList = new ArrayList<>();
			getKthLis(maxLength, k, resultList);
			for(int i = 0; i < resultList.size(); i++) {
				System.out.print((i==0 ? "" : " " ) + numbers[resultList.get(i)]);
			}
			System.out.println();
		}
	}
	public static int getMaxLength(int startPoint) {
		if(lisCache[startPoint+1] != -1) return lisCache[startPoint+1];
		int maxLength = 1;
		for(int i = startPoint+1; i < numbers.length; i++) {
			if(startPoint == -1 || numbers[startPoint] < numbers[i]) {
				maxLength = Math.max(maxLength, getMaxLength(i)+1);
			}
		}
		lisCache[startPoint+1] = maxLength;
		if(startPoint != -1) lengthIndexMap.get(maxLength)[numbers[startPoint]] = startPoint;
		return lisCache[startPoint+1];
	}
	public static double getMaxLengthCount(int startPoint) {
		if(getMaxLength(startPoint) == 1) return 1;
		if(countCache[startPoint] != -1) return countCache[startPoint];
		double maxLengthCount = 0;
		for(int i = startPoint+1; i < numbers.length; i++) {
			if((startPoint == -1 || numbers[startPoint] < numbers[i]) 
					&& getMaxLength(startPoint) == (getMaxLength(i)+1)) {
				maxLengthCount = Math.min(K_MAX, (double)maxLengthCount + getMaxLengthCount(i));
			}
		}
		countCache[startPoint] = maxLengthCount;
		return countCache[startPoint];
	}
	public static void getKthLis(int targetLength, int k, List<Integer> kthLis) {
		if(targetLength == 0) return;
		int[] lengthIndex = lengthIndexMap.get(targetLength);
		int prevIndex = (kthLis.size() == 0) ? -1 : kthLis.get(kthLis.size()-1);
		for(int i = 1; i < lengthIndex.length; i++) {
			int index = lengthIndex[i];
			if(index != -1 && prevIndex < index && (prevIndex == -1 || numbers[prevIndex] <= numbers[index])) {
				double currentK = getMaxLengthCount(index);
				if(currentK >= k) {
					kthLis.add(index);
					getKthLis(targetLength-1, k, kthLis);
					break;
				} else {
					k-=currentK;
				}
			}
		}
	}
 }
