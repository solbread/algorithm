package com.algorithm.contest.google_code_jam_2017.qualification_round.a_oversized_pancake_flipper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String path = "src/com/algorithm/contest/google_code_jam_2017/qualification_round/a_oversized_pancake_flipper/";
		Scanner in = null;
		BufferedWriter out = null;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//			in = new Scanner(new File(path + "A-large.in"));
			out = new BufferedWriter(new FileWriter(path + "large_output"));
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				StringBuilder pancakes = new StringBuilder(in.next());
				int k = Integer.parseInt(in.next());
				int cnt = 0;
				for(int j = 0; j < pancakes.length()-k+1; j++) {
					if(pancakes.charAt(j)== '-') {
						for(int n = j; n < j+k; n++) {
							pancakes.setCharAt(n, (pancakes.charAt(n)=='-') ? '+' : '-');
						}
						cnt++;
					}
				}
				boolean isHappy = true;
				for(int j = pancakes.length()-k; j < pancakes.length(); j++) {
					if(pancakes.charAt(j)!='+') {
						isHappy = false;
					}
				}
				if(isHappy) {
					out.write("Case #" + i + ": " + cnt + "\n");
				} else {
					out.write("Case #" + i + ": IMPOSSIBLE\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) in.close();
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
