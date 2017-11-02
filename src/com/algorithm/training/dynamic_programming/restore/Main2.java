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
		            if(i==j) continue;
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
//			int shortLength = 601;
//          for(int i = 0; i < subStrings.length; i++) {
//              int ret = subStrings[i].length() + main.getShortStringLength(1 << i, i);
//              shortLength = Math.min(shortLength, ret);
//          }
//          System.out.println(shortLength);
		}
	}
	public String getShortString(int visit, int startIndex) {
	    String shortString = "";
	    for(int i = 0; i < subStrings.length; i++) {
	        if( (visit & (1 << i)) == 0) {
	            int tmp = subStrings[i].length() - merge(startIndex, i);
	            if(getShortStringLength(visit, startIndex) == tmp + getShortStringLength(visit + (1<<i), i)) {
	                return subStrings[i].substring(merge(startIndex, i), subStrings[i].length()) + getShortString(visit + (1<<i), i);
	            }
	        }
	    }
	    return shortString;
	}

	public int getShortStringLength(int visit, int startIndex) {
	    if(cache[visit][startIndex] != -1) return cache[visit][startIndex];
	    int shortStringLength = 601;
        for(int i = 0; i < subStrings.length; i++) {
            if( (visit & (1 << i)) == 0) {
                int tmp = subStrings[i].length() - merge(startIndex, i);
                tmp += getShortStringLength(visit + (1<<i), i);
                shortStringLength = Math.min(shortStringLength, tmp);
            }
        }
	    cache[visit][startIndex] = shortStringLength;
	    return cache[visit][startIndex];
	}
	private int merge(int i, int j) {
		if(mergeCache[i][j] != -1) return mergeCache[i][j];
		String string1 = subStrings[i], string2 = subStrings[j];
		char[] stringArr1 = string1.toCharArray(), stringArr2 = string2.toCharArray();
		int index1 = 0, index2 = 0;
		while(index1 < string1.length() && index2 < string2.length()) {
			if(stringArr1[index1] == stringArr2[index2]) {
				index1++; index2++;
			} else {
				index1++; index2=0;
			}
		}
		mergeCache[i][j] = index2;
		return mergeCache[i][j];
	}
}
