package com.algorithm.training.stack.asteroid_collision;

import java.util.Arrays;

public class Solution2 {
    public int[] asteroidCollision(int[] asteroids) {
    	int[] remainedAsteroids = new int[asteroids.length];
    	int index = 0;
        for(int asteroid :asteroids) {
        	if(asteroid > 0) {
        		remainedAsteroids[index++] = asteroid;
        	} else {
        		while(index > 0 && remainedAsteroids[index-1] > 0 && remainedAsteroids[index-1] < -asteroid) {
        			index--;
        		}
        		if(index == 0 || remainedAsteroids[index-1] < 0) remainedAsteroids[index++] = asteroid;
        		else if(remainedAsteroids[index-1] == -asteroid) index--;
        	}
        }
        return Arrays.copyOfRange(remainedAsteroids, 0, index);
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {5,10,-5}))); //5,10
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {8,-8}))); // {}
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {10,2,-5}))); //10
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {-2,-1,1,2}))); //2,-1,1,2
	}
}
