package com.algorithm.training.stack.asteroid_collision;

import java.util.Arrays;
import java.util.LinkedList;

public class BestSolution {
	public int[] asteroidCollision(int[] asteroids) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i < asteroids.length; i++) {
			if(asteroids[i] > 0 || list.isEmpty() || list.getLast() < 0) {
				list.add(asteroids[i]);
			} else if(list.getLast() <= -asteroids[i]) {
				if(list.pollLast() < -asteroids[i]) {
					i--;
				}
			}
		}
		return list.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {5,10,-5}))); //5,10
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {8,-8}))); // {}
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {10,2,-5}))); //10
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {-2,-1,1,2}))); //2,-1,1,2
	}
}
