package com.algorithm.contest.google_code_jam_2017.qualification_round.c_bathroom_stalls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		String path = "src/com/algorithm/contest/google_code_jam_2017/qualification_round/c_bathroom_stalls/";
		Scanner in = null;
		BufferedWriter out = null;
		try {
//			in = new Scanner(new File(path + "C-small-1-attempt2.in"));
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			out = new BufferedWriter(new FileWriter(path + "small_output2"));
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				int n = Integer.parseInt(in.next());
				int k = Integer.parseInt(in.next());
				Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
					public int compare(int[] o1, int[] o2) {
						if (o1[0] == o1[0]) {
							return o1[1] >= o2[1] ? 1 : -1;
						} else {
							return o1[0] >= o2[0] ? 1 : -1;
						}
					};
				});
				main.addSplitedN(n, queue);
				k--;
				while (k > 1) {
					int[] tmp = queue.poll();
					main.addSplitedN(tmp[0], queue);
					k --;
				}
				int[] tmp = (k == 0) ? queue.poll() : main.addSplitedN(queue.poll()[0], queue);
				out.write("Case #" + i + ": " + Math.max(tmp[0], tmp[1]) + " " + Math.min(tmp[0], tmp[1]) + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public int[] addSplitedN(int n, Queue<int[]> queue) {
		n--;
		int a = (n % 2 == 0) ? n / 2 : (n / 2) + 1;
		int b = n / 2;
		queue.add(new int[]{a, b});
		queue.add(new int[]{b, a});
		return new int[] {a, b};
	}
}
