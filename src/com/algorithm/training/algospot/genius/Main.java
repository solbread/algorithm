package com.algorithm.training.dynamic_programming.genius;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int music[][];
	static double playProbability[][];
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/genius/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			music = new int[scanner.nextInt()][2];
			int nextMinutes = scanner.nextInt();
			int likeMusicCount = scanner.nextInt();
			playProbability = new double[music.length][music.length];
			for(int i = 0; i < music.length; i++) {
				music[i][0] = scanner.nextInt();
			}
			for(int i = 0; i < playProbability.length; i++) {
				for(int j = 0; j < playProbability[i].length; j++) {
					playProbability[i][j] = scanner.nextDouble();
				}
			}
			for(int i = 0; i < likeMusicCount; i++) {
				int likeMusicNumber = scanner.nextInt();
				music[likeMusicNumber][1] = 1;
			}
		}
	}
}
