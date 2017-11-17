package com.algorithm.training.greedy.trapping_rain_water;

import java.util.Stack;

public class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        boolean isDown = true;
        int i = 0;
        while(i < height.length && height[i] == 0) {
            i++;
        }
        int left = i, trapSize = 0;
        for(i+=1; i < height.length; i++) {
            if(isDown && height[i-1] < height[i]) {
                isDown = false;
            } 
            if(!isDown && (i == height.length-1 || height[i] > height[i+1])) {
                int stdHeight = Math.min(height[left], height[i]);
                while(!stack.isEmpty()) {
                    int curHeight = stack.pop();
                    if(curHeight < stdHeight) {
                        trapSize += (stdHeight - curHeight);
                    }
                }
                left = i;
                isDown = true;
            } else {
                stack.add(height[i]);
            }
        }
        return trapSize;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{}));
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(solution.trap(new int[]{5,4,1,2}));
    }
}
