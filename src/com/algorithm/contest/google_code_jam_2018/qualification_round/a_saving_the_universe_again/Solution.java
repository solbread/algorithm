package com.algorithm.contest.google_code_jam_2018.qualification_round.a_saving_the_universe_again;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution  {
	public static void main(String[] args) {
		Solution main = new Solution();
		String path = "src/com/algorithm/contest/google_code_jam_2018/qualification_round/a_saving_the_universe_again/";
		Scanner in = null;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//			in = new Scanner(new File(path + "test"));
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				int damage = in.nextInt();
				char program[] = in.next().toCharArray();
				if(main.countShot(program) > damage) {
					System.out.println("Case #" + i + ": IMPOSSIBLE");	
				} else {
					int swapCount = 0;
					while(main.getTotalDamage(program) > damage) {
						for(int j = 0; j < program.length-1; j++) {
							if(program[j] < program[j+1]) {
								program[j] = 'S';
								program[j+1] = 'C';
								swapCount++;
								break;
							}
						}
					}
					System.out.println("Case #" + i + ": " + swapCount);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) in.close();
		}
	}

	private int countShot(char[] program) {
		int count = 0;
		for(char c : program) {
			if (c == 'S') count++;
		}
		return count;
	}

	private int getTotalDamage(char[] program) {
		int damage = 1, totalDamage = 0;
		for(char c : program) {
			if(c == 'C') {
				damage *= 2;
			} else {
				totalDamage += damage;
			}
		}
		return totalDamage;
	}
}

/*
Case #1: 1
Case #2: 0
Case #3: IMPOSSIBLE
Case #4: 2
Case #5: 0
Case #6: 5
 */
