package com.algorithm.training.dynamic_programming.restore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static int cache[][];
	public static int mergeCache[][];
	public static String subStrings[];
	public static void main(String[] args) {
		Main2 main = new Main2();
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
			cache = new int[(int)Math.pow(2, subStrings.length)][subStrings.length];
			for(int subCache[] : cache) Arrays.fill(subCache, -1);
			Arrays.fill(cache[(1<<subStrings.length)-1], 0);
			mergeCache = new int[subStrings.length][subStrings.length];
			for(int subCache[] : mergeCache) Arrays.fill(subCache, -1);
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
	    String shortString = "";
	    for(int i = 0; i < subStrings.length; i++) {
	        if( (visit & (1 << i)) == 0) {
	            if(getMaxOverlapLength(visit, startIndex) ==  getOverlapLength(startIndex, i) + getMaxOverlapLength(visit + (1<<i), i)) {
	                return subStrings[i].substring(getOverlapLength(startIndex, i)) + getShortString(visit + (1<<i), i);
	            }
	        }
	    }
	    return shortString;
	}

	public int getMaxOverlapLength(int visit, int startIndex) {
	    if(cache[visit][startIndex] != -1) return cache[visit][startIndex];
	    int getOverlapLength = 0;
        for(int i = 0; i < subStrings.length; i++) {
            if( (visit & (1 << i)) == 0) {
                getOverlapLength = Math.max(getOverlapLength, getOverlapLength(startIndex, i) + getMaxOverlapLength(visit + (1<<i), i));
            }
        }
	    cache[visit][startIndex] = getOverlapLength;
	    return cache[visit][startIndex];
	}
	private int getOverlapLength(int idx1, int idx2) {
		if(mergeCache[idx1][idx2] != -1) return mergeCache[idx1][idx2];
		String string1 = subStrings[idx1], string2 = subStrings[idx2];
		char[] stringArr1 = string1.toCharArray(), stringArr2 = string2.toCharArray();
		int overlapCount = 0;
		for(int i = 0; i < stringArr1.length; i++) {
			int tmpI = i, j = 0;
			for(j = 0; tmpI < stringArr1.length && j < stringArr2.length; j++) {
				if(stringArr1[tmpI] != stringArr2[j]) break;
				tmpI++;
			}
			if(tmpI == stringArr1.length) {
				overlapCount = Math.max(overlapCount, j);
			}
		}
		mergeCache[idx1][idx2] = overlapCount;
		return mergeCache[idx1][idx2];
	}
}
