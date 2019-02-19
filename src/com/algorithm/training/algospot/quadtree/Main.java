package com.algorithm.training.divide_and_conquer.quadtree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static char[] originPicture;
	static int index;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/divide_and_conquer/quadtree/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			originPicture = scanner.next().toCharArray();
			index = 0;
			System.out.println(main.zipPicture());
		}
	}
	
	private String zipPicture() {
		switch (originPicture[index++]) {
		case 'w':
		case 'b':
			return String.valueOf(originPicture[index-1]);
		default:
			String s1 = zipPicture();
			String s2 = zipPicture();
			String s3 = zipPicture();
			String s4 = zipPicture();
			return "x" + s3 + s4 + s1 + s2;
		}
	}
}
