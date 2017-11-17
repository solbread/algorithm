package com.algorithm.training.greedy.trapping_rain_water;

public class Solution {
    public int trap(int[] height) {
        boolean isDown = true;
        int i = 0;
        while(i < height.length && height[i] == 0) {
            i++;
        }
        int left = i, trapSize = 0, currentTrapSize = 0;
        for(i+=1; i < height.length; i++) {
            if(isDown && height[i-1] < height[i]) {
                isDown = false;
            } 
            if(!isDown && (i == height.length-1 || height[i] > height[i+1])) {
                if(height[left] > height[i]) {
                    currentTrapSize -= (height[left] - height[i]) * (i - left - 1);
                }
                trapSize += currentTrapSize;
                currentTrapSize = 0;
                left = i;
                isDown = true;
            }
            if(height[left] > height[i]) {
                currentTrapSize += (height[left] - height[i]);
            }
        }
        return trapSize;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{}));
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
