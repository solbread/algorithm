package com.algorithm.training.stack.largest_rectangle_in_histogram;

import java.util.Stack;

public class BestSolution {
    public int largestRectangleArea(int[] height) {
    	int largeRecangleArea = 0;
    	Stack<Integer> stack = new Stack<>();
    	for(int i = 0; i <= height.length; i++) {
    		if(stack.isEmpty() || (i != height.length && height[stack.peek()] <= height[i])) {
    			stack.add(i);
    		} else {
    			int h = height[stack.pop()];
    			int w = i - ((stack.isEmpty()) ? 0 : stack.peek()+1);
    			largeRecangleArea = Math.max(largeRecangleArea, h*w);
    			i--;
    		}
    	}
    	return largeRecangleArea;
    }
    public static void main(String[] args) {
    	BestSolution solution = new BestSolution();
		int height[] = {2, 1, 5, 6, 2, 3}; //output:10
//		int height[] = {5,5,1,7,1,1,5,2,7,6}; //output:12
		System.out.println(solution.largestRectangleArea(height));
	}
}
