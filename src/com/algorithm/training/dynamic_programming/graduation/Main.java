package com.algorithm.training.dynamic_programming.graduation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int[][] cache;
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
	    if(currentSemester > semesterSubjectList.size()) return semesterSubjectList.size()+1;
	    if(cache[listen][currentSemester] != -1) return cache[listen][currentSemester];
	    int minSemester = semesterSubjectList.size()+1;
	    int semesterSubjects = semesterSubjectList.get(currentSemester);
	    for(int subset = semesterSubjects; subset != 0; subset = (semesterSubjects & (subset-1))) {
	        int subjectCount = countSubject(subset);
	        if(subjectCount <= maxSubjectPerSemester && canListen(listen, subset)) {
	            if(subjectCount >= reaminedSubjectCount) {
	                return 1;
	            } else {
	                minSemester = Math.min(minSemester, 1 + getMinSemester(listen | subset, currentSemester+1, reaminedSubjectCount - subjectCount));
	            }
	        }
	    }
	    if(minSemester == semesterSubjectList.size()+1) minSemester = getMinSemester(listen, currentSemester+1, reaminedSubjectCount);
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
	private boolean canListen(int listen, int currentSubject) {
        if((listen & currentSubject) == 0) {
            for(int i = 0; i < prevSubjectList.size(); i++) {
                if((currentSubject & (1 << i)) > 0) {
                    if((listen & prevSubjectList.get(i)) != prevSubjectList.get(i)) {
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
