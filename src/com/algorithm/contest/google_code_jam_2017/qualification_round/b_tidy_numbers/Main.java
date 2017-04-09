package com.algorithm.contest.google_code_jam_2017.qualification_round.b_tidy_numbers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Scanner in = new Scanner(new BufferedReader(new
		// InputStreamReader(System.in)));
		String path = "src/com/algorithm/contest/google_code_jam_2017/qualification_round/b_tidy_numbers/";
		Scanner in = null;
		BufferedWriter out = null;
		try {
			in = new Scanner(new File(path + "test_input"));
			out = new BufferedWriter(new FileWriter(path + "test_output"));
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				StringBuilder inputNumber = new StringBuilder(in.next());
				for(int j = inputNumber.length()-1; j > 0; j--) {
					if(inputNumber.charAt(j-1) > inputNumber.charAt(j)) {
						inputNumber.setCharAt(j-1, (char)(inputNumber.charAt(j-1)-1));
						int length = inputNumber.length();
						inputNumber.delete(j, length);
						for(int k = j; k < length; k++) {
							inputNumber.append('9');
						}
					}
				}
				int zeroIndex = 0;
				for(int j = 0; j < inputNumber.length() && inputNumber.charAt(j)=='0'; j++) {
					zeroIndex++;
				}
				out.write("Case #" + i + ": " + inputNumber.substring(zeroIndex));
				out.newLine();
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
