package com.algorithm.training.dynamic_programming.graduation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static int[][] cache;
	static int mustSubjectNumber, maxSubjectPerSemester;
	static int[] prevSubjectList, semesterSubjectList;
	public static void main(String[] args) {
		Main2 main = new Main2();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/graduation/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			prevSubjectList = new int[scanner.nextInt()];
			mustSubjectNumber = scanner.nextInt();
			semesterSubjectList = new int[scanner.nextInt()];
			maxSubjectPerSemester = scanner.nextInt();
			for(int i = 0; i < prevSubjectList.length; i++) {
				int prevSubjectNumber = scanner.nextInt();
				for(int j = 0; j < prevSubjectNumber; j++) {
					prevSubjectList[i] |= (1 << scanner.nextInt());
				}
			}
			for(int i = 0; i < semesterSubjectList.length; i++) {
				int semesterSubjectNumber = scanner.nextInt();
				for(int j = 0; j < semesterSubjectNumber; j++) {
					semesterSubjectList[i] |= (1 << scanner.nextInt());
				}
			}
			cache = new int[(int)Math.pow(2, prevSubjectList.length)][semesterSubjectList.length];
			for(int[] subCache : cache) Arrays.fill(subCache, -1);
			int minSemester = main.getMinSemester(0, 0);
			System.out.println(minSemester >= semesterSubjectList.length + 1 ? "IMPOSSIBLE" : minSemester);
		}
	}

	public int getMinSemester(int listen, int currentSemester) {
		if(countSubject(listen) >= mustSubjectNumber) return 0;
		if(currentSemester >= semesterSubjectList.length) return semesterSubjectList.length+1;
		if(cache[listen][currentSemester] != -1) return cache[listen][currentSemester];
		int minSemester = semesterSubjectList.length+1;
		int canListen = semesterSubjectList[currentSemester] & ~listen;
		for(int i = 0; i < prevSubjectList.length; i++) {
			if((canListen & (1<<i)) > 0 && (listen & prevSubjectList[i]) != prevSubjectList[i])
				canListen &= ~(1<<i);
		}
		for(int subset = canListen; subset > 0; subset=((subset-1)&canListen)) {
			if(countSubject(subset) > maxSubjectPerSemester) continue;
			minSemester = Math.min(minSemester, 1 + getMinSemester(listen|subset, currentSemester+1));
		}
		minSemester = Math.min(minSemester, getMinSemester(listen, currentSemester+1));
		cache[listen][currentSemester] = minSemester;
		return minSemester;
	}

	private int countSubject(int currentSubjectSet) {
	    int count = 0;
	    for(int i = 0; i < prevSubjectList.length; i++) {
	        if((currentSubjectSet & (1<<i)) > 0) count++;
	    }
	    return count;
	}
}
