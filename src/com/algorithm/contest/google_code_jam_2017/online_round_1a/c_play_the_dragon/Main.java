package com.algorithm.contest.google_code_jam_2017.online_round_1a.c_play_the_dragon;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Scanner in = new Scanner(new BufferedReader(new
		// InputStreamReader(System.in)));
		String path = "src/com/algorithm/contest/google_code_jam_2017/online_round_1a/c_play_the_dragon/";
		Scanner in = null;
		BufferedWriter out = null;
		try {
			in = new Scanner(new File(path + "test_input"));
			out = new BufferedWriter(new FileWriter(path + "test_output"));
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				String s = in.next();
				out.write("Case #" + i + ": " + s);
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
