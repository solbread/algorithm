package com.algorithm.training.two_pointers.trapping_rain_water;

public class BestSolution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1, maxLeft = 0, maxRight = 0, trapSize = 0;
        while(left<= right) {
            if(height[left] <= height[right]) {
                if(height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    trapSize += (maxLeft - height[left]);
                }
                left++;
            } else {
                if(height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    trapSize += (maxRight - height[right]);
                }
                right--;
            }
        }
        return trapSize;
    }
    
    public static void main(String[] args) {
        BestSolution2 solution = new BestSolution2();
        System.out.println(solution.trap(new int[]{})); //0
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); //6
        System.out.println(solution.trap(new int[]{5,4,1,2})); //1
        System.out.println(solution.trap(new int[]{5,2,1,2,1,5})); //14
    }
}
