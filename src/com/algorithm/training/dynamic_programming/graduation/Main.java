package com.algorithm.training.dynamic_programming.graduation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int[][] cache;
	static int maxSubjectPerSemester;
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
			int mustSubjectNumber = scanner.nextInt();
			int semester = scanner.nextInt();
			maxSubjectPerSemester = scanner.nextInt();
			prevSubjectList = new HashMap<>();
			semesterSubjectList = new HashMap<>();
			for(int i = 0; i < subjectNumber; i++) {
				int prevSubjectNumber = scanner.nextInt();
				int prevSubjectMask = 0;
				for(int j = 0; j < prevSubjectNumber; j++) {
					prevSubjectMask += (1 << scanner.nextInt());
				}
				prevSubjectList.put(i, prevSubjectMask);
			}
			for(int i = 1; i <= semester; i++) {
				int semesterSubjectNumber = scanner.nextInt();
				int semesterSubjectMask = 0;
				for(int j = 0; j < semesterSubjectNumber; j++) {
					semesterSubjectMask += (1 << scanner.nextInt());
				}
				semesterSubjectList.put(i, semesterSubjectMask);
			}
			cache = new int[(int)Math.pow(2, subjectNumber)][semester+1];
			for(int[] subCache : cache) Arrays.fill(subCache, -1);
			int minSemester = main.getMinSemester(0, 1, mustSubjectNumber);
			System.out.println(minSemester == semesterSubjectList.size() + 1 ? "IMPOSSIBLE" : minSemester);
		}
	}
	public int getMinSemester(int listen, int currentSemester, int reaminedSubjectCount) {
	    if(reaminedSubjectCount <= 0) return 0;
	    if(currentSemester > semesterSubjectList.size()) return semesterSubjectList.size()+1;
	    if(cache[listen][currentSemester] != -1) return cache[listen][currentSemester];
	    int minSemester = semesterSubjectList.size()+1;
	    int semesterSubjects = semesterSubjectList.get(currentSemester);
	    for(int subset = semesterSubjects; subset != 0; subset = (semesterSubjects & (subset-1))) {
	        int subjectCount = countSubject(subset);
	        if(subjectCount <= maxSubjectPerSemester && canListen(listen, subset)) {
	            minSemester = Math.min(minSemester, 1 + getMinSemester(listen | subset, currentSemester+1, reaminedSubjectCount - subjectCount));
	        }
	    }
	    minSemester = Math.min(minSemester, getMinSemester(listen, currentSemester+1, reaminedSubjectCount));
	    cache[listen][currentSemester] = minSemester;
	    return cache[listen][currentSemester];
	}
	private int countSubject(int currentSubjectSet) {
	    int count = 0;
	    for(int i = 0; i < prevSubjectList.size(); i++) {
	        if((currentSubjectSet & (1<<i)) > 0) count++;
	    }
	    return count;
	}
	private boolean canListen(int listen, int currentSubjects) {
        if((listen & currentSubjects) == 0) { //모든 과목을 들을 수 있는지 확인
            for(int i = 0; i < prevSubjectList.size(); i++) {
                if((currentSubjects & (1 << i)) > 0) {  //이번학기에 개설된 과목이면
                    if((listen & prevSubjectList.get(i)) != prevSubjectList.get(i)) { // 해당과목의 선이수과목을 다 들었는지 확인
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
	}
}
