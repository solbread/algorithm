package com.algorithm.training.greedy.trapping_rain_water;

import java.util.Stack;

public class BestSolution2 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int trapSize = 0, i = 0;
        while(i < height.length) {
            if(stack.isEmpty() || height[stack.peek()] > height[i]) {
                stack.add(i++);
            } else {
                int bot = stack.pop();
                trapSize += (stack.isEmpty() ? 0 
                        : (i-stack.peek()-1)*(Math.min(height[i], height[stack.peek()])-height[bot]));
            }
        }
        return trapSize;
    }
    
    public static void main(String[] args) {
        BestSolution2 solution = new BestSolution2();
        System.out.println(solution.trap(new int[]{}));
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(solution.trap(new int[]{5,4,1,2}));
        System.out.println(solution.trap(new int[]{5,2,1,2,1,5}));
    }
}
