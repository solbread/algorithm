package com.algorithm.training.dynamic_programming.graduation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int[] cache;
	static int mustSubjectNumber, maxSubjectPerSemester;
	static Map<Integer, Integer> prevSubjectList;
	static Map<Integer, Integer> semesterSubjectList;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/graduation/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int subjectNumber = scanner.nextInt();
			mustSubjectNumber = scanner.nextInt();
			int semester = scanner.nextInt();
			maxSubjectPerSemester = scanner.nextInt();
			prevSubjectList = new HashMap<>();
			semesterSubjectList = new HashMap<>();
			for(int i = 0; i < subjectNumber; i++) {
				int prevSubjectNumber = scanner.nextInt();
				int prevSubjectMask = 0;
				for(int j = 0; j < prevSubjectNumber; j++) {
					prevSubjectMask += (1 << i);
				}
				prevSubjectList.put(i, prevSubjectMask);
			}
			for(int i = 0; i < semester; i++) {
				int semesterSubjectNumber = scanner.nextInt();
				int semesterSubjectMask = 0;
				for(int j = 0; j < semesterSubjectNumber; j++) {
					semesterSubjectMask += (1<<i);
				}
				semesterSubjectList.put(i, semesterSubjectMask);
			}
			System.out.println(main.getMinSemester(0, 0, maxSubjectPerSemester));
		}
	}
	public int getMinSemester(int listen, int currentSemester, int remainedSubjectPerSemester) {
		//cache
		if(semesterSubjectList.size() == currentSemester+1 && remainedSubjectPerSemester == 0) return semesterSubjectList.size()+1;
		int minSemester = semesterSubjectList.size()+1;
		int currentSemesterSubjects = semesterSubjectList.get(currentSemester);
		for(int i = 0; i < 10; i++) {
			if((currentSemesterSubjects & (1<<i)) == 0 
					&& ((listen & prevSubjectList.get(i)) == prevSubjectList.get(i))) {
				minSemester = Math.min(minSemester, getMinSemester(listen + (1<<i), 
						(remainedSubjectPerSemester == 1) ? currentSemester+1 : currentSemester, 
						(remainedSubjectPerSemester == 1) ? maxSubjectPerSemester : remainedSubjectPerSemester-1));
			}
		}
	return minSemester;
	}
}
