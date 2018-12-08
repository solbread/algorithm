package com.algorithm.contest.google_code_jam_2018.online_round_1c.a_a_whole_new_word;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution main = new Solution();
		String path = "src/com/algorithm/contest/google_code_jam_2018/online_round_1c/a_a_whole_new_word/";
		Scanner in = null;
		try {
//			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			in = new Scanner(new File(path + "test"));
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				StringBuilder sb = new StringBuilder();
				int n = in.nextInt();
				int length = in.nextInt();
				int trie[][] = new int[length][26];
				for (int j = 0; j < n; j++) {
					String str = in.next();
					trie[0][str.charAt(0) - 'a'] = 0;
					for (int k = 1; k < length; k++) {
						trie[k][str.charAt(k) - 'a'] |= (1 << str.charAt(k - 1) - 'a');
					}
				}
				for (int j = 0; j < n; j++) {
					int prevChar = -1;
					for(int k = 0; k < 26; k++) {
					}
				}

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