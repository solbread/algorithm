package com.algorithm.training.dynamic_programming.restore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
			subStrings = new String[scanner.nextInt()];
			cache = new String[(int)Math.pow(2, subStrings.length)][subStrings.length];
			Arrays.fill(cache[(1<<subStrings.length)-1], "");
			mergeCache = new String[subStrings.length][subStrings.length];
			for(int i = 0; i < subStrings.length; i++) {
				subStrings[i] = scanner.next();
			}
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
	private String merge(int i, int j) {
		if(mergeCache[i][j] != null) return mergeCache[i][j];
		String string1 = subStrings[i], string2 = subStrings[j];
		int currentI = string1.length()-1, resultJ = 0;;
		while(currentI > 0) {
			if(string1.charAt(currentI) == string2.charAt(0)) {
				if(string1.length()-currentI <= string2.length() && string1.substring(currentI, string1.length()).equals(string2.substring(0, string1.length()-currentI))) {
					resultJ = string1.length()-currentI;
				} else if(string1.substring(currentI, string1.length()).contains(string2)) {
					resultJ = string2.length();
					break;
				}
			}
			currentI--;
		}
		mergeCache[i][j] = string2.substring(resultJ, string2.length());
		return mergeCache[i][j];
	}
}
