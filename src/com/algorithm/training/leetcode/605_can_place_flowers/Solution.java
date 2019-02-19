package com.algorithm.training.array.can_place_flowers;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
        	if((i==0 || flowerbed[i-1]==0) && flowerbed[i]==0 && (i==flowerbed.length-1 || flowerbed[i+1]==0)) {
        		flowerbed[i] = 1;
        		n--;
        	}
        	if(n <= 0) return true;
        }
        return false;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] flowerbed = {1,0,0,0,1,0,0};
		System.out.println(solution.canPlaceFlowers(flowerbed, 2));
	}
}
