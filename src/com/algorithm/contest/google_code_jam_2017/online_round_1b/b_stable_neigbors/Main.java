package com.algorithm.contest.google_code_jam_2017.online_round_1b.b_stable_neigbors;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Scanner in = new Scanner(new BufferedReader(new
		// InputStreamReader(System.in)));
		String path = "src/com/algorithm/contest/google_code_jam_2017/online_round_1b/b_stable_neigbors/";
		Scanner in = null;
		BufferedWriter out = null;
		try {
			in = new Scanner(new File(path + "test_input"));
			out = new BufferedWriter(new FileWriter(path + "test_output"));
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				int color[] = new int[7];
				StringBuilder result = new StringBuilder();
				for(int j = 0; j < 7; j ++) {
					color[j] = in.nextInt();
				}
				if(color[2]+1 > color[5] || color[4]+1 > color[1] || color[6]+1 > color[3]) {
					result.append("IMPOSSIBLE");
				} else {
					color[5] = color[5]-color[2];
					color[1] = color[1]-color[4];
					color[3] = color[3]-color[6];
					for(int j = 0; j < color[2]; j++) {
						result.append("OB");
					}
					if(color[1]== color[3] && color[1]==0) {
						result = new StringBuilder("IMPOSSIBLE");
					} else {
						if(color[1] > color[3]) {
							result.append("R");
							for(int j = 0; j < color[4]; j ++) {
								result.append("GR");
							}
						} else {
							result.append("Y");
							for (int j = 0; j < color[6]; j ++) {
								result.append("VY");
							}
						}
					}
				}
				System.out.println();
				out.write("Case #" + i + ": " + result.toString() + "\n");
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
}
