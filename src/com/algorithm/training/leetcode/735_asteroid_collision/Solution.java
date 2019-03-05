package com.algorithm.training.stack.asteroid_collision;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid :asteroids) {
        	if(asteroid > 0) {
        		 stack.add(asteroid);
        	} else {
        		while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
        			stack.pop();
        		}
        		if(stack.isEmpty() || stack.peek() < 0) stack.add(asteroid);
        		else if(stack.peek() == -asteroid) stack.pop();
        	}
        }
        int[] ret = new int[stack.size()];
        int index = ret.length-1;
        while(!stack.isEmpty()) ret[index--] = stack.pop();
        return ret;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {5,10,-5}))); //5,10
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {8,-8}))); // {}
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {10,2,-5}))); //10
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {-2,-1,1,2}))); //2,-1,1,2
	}
}
