package com.algorithm.contest.google_code_jam_2018.qualification_round.c_go_gopher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution main = new Solution();
		String path = "src/com/algorithm/contest/google_code_jam_2018/qualification_round/b_trouble_sort/";
		Scanner in = null;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//			in = new Scanner(new File(path + "test"));
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				int n = in.nextInt();
				int array[] = new int[n];
				for(int j = 0; j < n; j++) {
					array[j] = in.nextInt();
				}
				int subArray1[] = new int[(int)Math.ceil(array.length/2.0)];
				int subArray2[] = new int[array.length/2];
				for(int j = 0; j < array.length; j++) {
					if(j%2 == 0) {
						subArray1[j/2] = array[j];
					} else {
						subArray2[j/2] = array[j];
					}
				}
				Arrays.sort(subArray1);
				Arrays.sort(subArray2);
				int sortedIndex = n;
				for(int j = 0; j < subArray2.length; j++) {
					if(subArray1[j] > subArray2[j]) {
						sortedIndex = j*2;
						break;
					} else if(j+1 < subArray1.length && subArray1[j+1] < subArray2[j]) {
						sortedIndex = j*2 + 1;
						break;
					}
				}
				System.out.println("Case #" + i + ": " + (sortedIndex == n ? "OK" : sortedIndex));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) in.close();
		}
	}
}

/*
Case #1: OK
Case #2: 1
*/