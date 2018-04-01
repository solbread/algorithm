package com.algorithm.contest.leetcode_20180401.soup_serving;

public class Solution {
	int[][] servings = {{-100, 0}, {-75, -25}, {-50, -50}, {-25, -75}};
	double[][] cache;
    public double soupServings(int N) {
    	cache = new double[N+1][N+1];
    	for(int i = 0; i < cache.length; i++) {
    		for(int j = 0; j < cache.length; j++) {
    			cache[i][j] = -1.0;
    		}
    	}
    	return soupServings(N, N);
    }
    private double soupServings(int A, int B) {
    	if(cache[A][B] != -1.0) return cache[A][B];
    	double p = 0;
    	for(int[] serving : servings) {
    		int afterA = A + serving[0];
    		int afterB = B + serving[1];
    		if(afterA <= 0 && afterB > 0) {
    			p+=1;
    		} else if(afterA <= 0 && afterB <= 0) {
    			p+= 0.5;
    		} else if(afterB <= 0) {
    			p += 0;
    		} else {
    			p += soupServings(afterA, afterB);
//    			p += (Math.round(soupServings(afterA, afterB)*Math.pow(10, 6))/Math.pow(10, 6));
    		}
    	}
    	cache[A][B] = p * 0.25;
    	return cache[A][B];
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.soupServings(50)); //0.625
		System.out.println(solution.soupServings(800));
		System.out.println(solution.soupServings(660295675));
	}
}
