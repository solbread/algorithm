package com.algorithm.contest.google_code_jam_2017.online_round_1b.a_steed_2_cruise_control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		 Scanner in = new Scanner(new BufferedReader(new
//		 InputStreamReader(System.in)));
		String path = "src/com/algorithm/contest/google_code_jam_2017/online_round_1b/a_steed_2_cruise_control/";
		Scanner in = null;
		BufferedWriter out = null;
		try {
			in = new Scanner(new File(path + "A-large.in"));
			out = new BufferedWriter(new FileWriter(path + "large_output"));
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				int d = Integer.parseInt(in.next());
				int n = Integer.parseInt(in.next());
				float maxTime = -1;
				for(int j = 0; j < n; j ++) {
					int init = Integer.parseInt(in.next());
					int speed = Integer.parseInt(in.next());
					maxTime = Math.max(maxTime, (float)(d-init)/speed);
				}
				out.write("Case #" + i + ": " + d/maxTime);
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
}
