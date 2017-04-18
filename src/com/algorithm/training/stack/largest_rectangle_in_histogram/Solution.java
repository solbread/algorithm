package com.algorithm.training.stack.largest_rectangle_in_histogram;

public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height==null || height.length==0) return 0;
        int largestArea = height[0], start = 0, end = height.length-1;
        while(start!=end) {
            if(height[start] > height[end]) {
                largestArea = Math.max(largestArea, height[start]);
                largestArea = Math.max(largestArea, height[end]*(end-start+1));
                end--;
            } else {
                largestArea = Math.max(largestArea, height[end]);
                largestArea = Math.max(largestArea, height[start]*(end-start+1));
                start++;
            }
        }
        return largestArea;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int height[] = {2, 1, 5, 6, 2, 3};
		System.out.println(solution.largestRectangleArea(height)); //output:10
	}
}
