package com.algorithm.training.stack.brackets2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/stack/brackets2/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			String str = scanner.next();
			Stack<Character> stack = new Stack<>();
			boolean isMathched = true;
			for(char c : str.toCharArray()) {
				if(!isMathched) break;
				switch (c) {
				case ')':
					if(stack.isEmpty() || stack.pop() != '(') {
						isMathched = false;
					}
					break;
				case '}':
					if(stack.isEmpty() || stack.pop() != '{') {
						isMathched = false;
					}
					break;
				case ']':
					if(stack.isEmpty() || stack.pop() != '[') {
						isMathched = false;
					}
					break;
				default:
					stack.add(c);
					break;
				}
			}
			System.out.println(isMathched ? "YES" : "NO");
		}
	}
}