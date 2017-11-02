package com.algorithm.training.dynamic_programming.maximum_length_of_repeated_subarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSolution3 {
    public int findLength(int[] A, int[] B) {
    	Map<Integer, List<Integer>> dictionary = new HashMap<>();
    	for(int i = 0; i < A.length; i++) {
    		List<Integer> list = dictionary.getOrDefault(A[i], new ArrayList<>());
    		list.add(i);
    		dictionary.put(A[i], list);
    	}
    	int maxLength = 0;
    	for(int i = 0; i < B.length; i++) {
    		if(dictionary.get(B[i]) != null) {
    			for(int index : dictionary.get(B[i])) {
    				int tmpI = i+1, count = 1;
    				if(A.length - index < maxLength) break;
    				for(int j = index + 1; tmpI < B.length && j < A.length; j++, tmpI++) {
    					if(A[j] == B[tmpI]) count++;
    					else break;
    				}
    				maxLength = Math.max(maxLength, count);
    			}
    		}
    	}
    	return maxLength;
    }
    public static void main(String[] args) {
        BestSolution3 solution = new BestSolution3();
        System.out.println(solution.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7})); //3
        System.out.println(solution.findLength(new int[]{0,0,0,0,0,0,1,0,0,0}, new int[]{0,0,0,0,0,0,0,1,0,0})); //9
        System.out.println(solution.findLength(new int[]{0,1,1,1}, new int[]{1,0,1,0,1})); //2
        System.out.println(solution.findLength(new int[]{1,0,0,0,1}, new int[]{1,0,0,1,1})); //3
    }
}
