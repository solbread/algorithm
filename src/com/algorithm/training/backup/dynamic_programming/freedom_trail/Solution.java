package com.algorithm.training.dynamic_programming.freedom_trail;

import java.util.Arrays;

public class Solution {
	char[] ring, key;
	int[][][] cache;
    public int findRotateSteps(String ring, String key) {
    	this.ring = ring.toCharArray();
    	this.key = key.toCharArray();
    	cache = new int[key.length()][ring.length()][3];
    	for(int[][] rows : cache) for(int[] row : rows) Arrays.fill(row, -1);
    	return getMinStepCount(0, 0, 0);
    }
    private int getMinStepCount(int keyIdx, int ringIdx, int direction) {
    	if(keyIdx == key.length) return 0;
    	if(cache[keyIdx][ringIdx][direction] != -1) return cache[keyIdx][ringIdx][direction];
    	int minStepCount = Integer.MAX_VALUE;
    	int clockwiseNextIdx = (ringIdx+1) % ring.length;
    	int anticlockwiseNextIdx = (ringIdx-1+ring.length) % ring.length;
    	if(ring[ringIdx] == key[keyIdx]) {
    		minStepCount = Math.min(getMinStepCount(keyIdx + 1, ringIdx, 0), getMinStepCount(keyIdx + 1, ringIdx, 0)) + 1;
    	} else {
    		if(direction == 0) {
    			minStepCount = Math.min(getMinStepCount(keyIdx, clockwiseNextIdx, 1), getMinStepCount(keyIdx, anticlockwiseNextIdx, 2)) + 1;
    		} else {
    			minStepCount = getMinStepCount(keyIdx, direction == 1 ? clockwiseNextIdx : anticlockwiseNextIdx, direction) + 1;
    		}
    	}	
    	cache[keyIdx][ringIdx][direction] = minStepCount;
    	return cache[keyIdx][ringIdx][direction];
    	
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findRotateSteps("godding", "gd")); //4
		System.out.println(solution.findRotateSteps("aaaaa", "aaaaa")); //5
	}
}
