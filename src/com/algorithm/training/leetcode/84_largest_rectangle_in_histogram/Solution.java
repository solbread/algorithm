package com.algorithm.training.stack.largest_rectangle_in_histogram;

import java.util.PriorityQueue;
import java.util.Queue;

@Deprecated
public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height==null || height.length==0) return 0;
        int largestArea = height[0], start = 0, end = height.length-1;
        
        Queue<Integer> queue = new PriorityQueue<>();
        for(int heightVal : height) {
        	queue.add(heightVal);
        }
        while(start!=end) {
            if(height[start] > height[end]) {
                largestArea = Math.max(largestArea, height[start]);
                largestArea = Math.max(largestArea, queue.peek()*(end-start+1));
                queue.remove(height[end]);
                end--;
            } else {
                largestArea = Math.max(largestArea, height[end]);
                largestArea = Math.max(largestArea, queue.peek()*(end-start+1));
                queue.remove(height[start]);
                start++;
            }
        }
        return largestArea;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
//		int height[] = {2, 1, 5, 6, 2, 3}; //output:10
		int height[] = {5,5,1,7,1,1,5,2,7,6}; //output:12
		System.out.println(solution.largestRectangleArea(height));
	}
}
