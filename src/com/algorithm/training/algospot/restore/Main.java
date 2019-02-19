package com.algorithm.training.dynamic_programming.restore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static String cache[][];
	static String mergeCache[][];
	static String subStrings[];
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/restore/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
		    int subStringsLength = scanner.nextInt();
		    List<String> subStringList = new ArrayList<>();
		    List<String> removedContainedStringList = new ArrayList<>();
		    for(int i = 0; i < subStringsLength; i++) {
		        subStringList.add(scanner.next());
		    }
		    for(int i = 0; i < subStringList.size(); i++) {
		        boolean isContainedString = false;
		        for (int j = 0; j < subStringList.size(); j++) {
		            if(i <= j  && subStringList.get(j).equals(subStringList.get(i))) continue;
		            if(subStringList.get(j).contains(subStringList.get(i))) isContainedString = true;
		        }
		        if(!isContainedString) removedContainedStringList.add(subStringList.get(i));
		    }
		    subStrings = removedContainedStringList.toArray(new String[removedContainedStringList.size()]);
			cache = new String[(int)Math.pow(2, subStrings.length)][subStrings.length];
			Arrays.fill(cache[(1<<subStrings.length)-1], "");
			mergeCache = new String[subStrings.length][subStrings.length];
			String shortString = null;
			for(int i = 0; i < subStrings.length; i++) {
				String ret = subStrings[i] + main.getShortString(1 << i, i);
				if(shortString == null || shortString.length() > ret.length()) {
					shortString = ret;
				}
			}
			System.out.println(shortString);
		}
	}
	public String getShortString(int visit, int startIndex) {
		if(cache[visit][startIndex] != null) return cache[visit][startIndex];
		String shortString = null;
		for(int i = 0; i < subStrings.length; i++) {
			if( (visit & (1 << i)) == 0) {
				String tmp = merge(startIndex, i);
				tmp += getShortString(visit + (1<<i), tmp.equals("") ? startIndex : i);
				if(shortString == null || shortString.length() > tmp.length()) {
					shortString = tmp;
				}
			}
		}
		cache[visit][startIndex] = shortString;
		return cache[visit][startIndex];
	}
	private String merge(int idx1, int idx2) {
		if(mergeCache[idx1][idx2] != null) return mergeCache[idx1][idx2];
		String string1 = subStrings[idx1], string2 = subStrings[idx2];
		char[] stringArr1 = string1.toCharArray(), stringArr2 = string2.toCharArray();
		mergeCache[idx1][idx2] = string2;
		for(int i = 0; i < stringArr1.length; i++) {
			int tmpI = i, j = 0;
			for(j = 0; tmpI < stringArr1.length && j < stringArr2.length; j++) {
				if(stringArr1[tmpI] != stringArr2[j]) break;
				tmpI++;
			}
			if(tmpI == stringArr1.length) {
				mergeCache[idx1][idx2] = string2.substring(j);
				break;
			}
		}
		return mergeCache[idx1][idx2];
	}
}
