package com.algorithm.contest.google_code_jam_2017.online_round_1b.c_pony_express;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int horse[][];
	static int route[][];
	public static void main(String[] args) {
		// Scanner in = new Scanner(new BufferedReader(new
		// InputStreamReader(System.in)));
		String path = "src/com/algorithm/contest/google_code_jam_2017/online_round_1b/c_pony_express/";
		Scanner in = null;
		BufferedWriter out = null;
		try {
			in = new Scanner(new File(path + "test_input"));
			out = new BufferedWriter(new FileWriter(path + "test_output"));
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				int n = in.nextInt();
				int q = in.nextInt();
				horse = new int[n][2];
				for(int j = 0; j < horse.length; j ++) {
					horse[j][0] = in.nextInt();
					horse[j][1] = in.nextInt();
				}
				route = new int[n][n];
				for(int j = 0; j < horse.length; j ++) {
					for(int k = 0; k < horse[0].length; k++) {
						route[j][k] = in.nextInt();
					}
				}
				out.write("Case #" + i + ":");
				for (int j = 0; j < q; j++) {
					int strat = in.nextInt();
					int end = in.nextInt();
					out.write(" " + dp(strat, end));
				}
				out.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static public float dp (int start, int end) {
		float minTime = -1;
		int a = (start < end) ? 1 : -1;
		for(int i = 0; i < route[0].length; i=i+a) {
			if(route[start][i]!=-1) {
				
			}
		}
		return minTime;
	}
}
