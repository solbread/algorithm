package com.algorithm.contest.google_code_jam_2017.online_round_1a.a_alphabet_cake;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String path = "src/com/algorithm/contest/google_code_jam_2017/online_round_1a/a_alphabet_cake/";
		Scanner in = null;
		BufferedWriter out = null;
		try {
			in = new Scanner(new File(path + "test_input"));
			out = new BufferedWriter(new FileWriter(path + "test_output"));
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				out.write("Case #" + i + ":\n");
				int r = in.nextInt();
				int c = in.nextInt();
				Queue<int[]> queue = new LinkedList<>();
				char[][] cake = new char[r][c];
				for(int j = 0; j < r; j++) {
					String row = in.next();
					for (int k = 0; k < c; k++) {
						cake[j][k] = row.charAt(k);
						if(cake[j][k] != '?') queue.add(new int[]{j, k});
					}
					out.newLine();
				}
				while(!queue.isEmpty()) {
					int[] element = queue.poll();
					int x = element[0], y = element[1];
					char initial = cake[x][y];
					boolean top = (x > 0);
					boolean bottom = (x < (cake.length-1));
					boolean left = (y > 0);
					boolean right = (y < (cake[0].length-1));
					
					if(top && cake[x-1][y]== '?') {
						if(((!left || cake[x][y-1] == initial) && (cake[x-1][y-1] == initial || cake[x-1][y-1]=='?')) 
								|| (!right || cake[x][y+1] == initial ) && ( cake[x-1][y+1] == initial || cake[x-1][y+1]=='?')) {
							cake[x-1][y] = initial;
							queue.add(new int[]{x-1, y});
						} else if((!left || cake[x][y-1]!=initial ) && (!right || cake[x][y+1]!=initial)) {
							cake[x-1][y] = initial;
							queue.add(new int[]{x-1, y});
						}
					}
					if(bottom && cake[x+1][y] == '?') {
						
					}
					if(left && cake[x][y-1] == '?') {
						
					}
					if(right && cake[x][y+1] == '?') {
						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) in.close();
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
