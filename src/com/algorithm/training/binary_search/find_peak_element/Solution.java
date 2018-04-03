package com.algorithm.training.binary_search.find_peak_element;

public class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while(lo < hi) {
        	int mid = (hi-lo)/2 + lo;
        	if(nums[mid-1] > nums[mid]) {
        		hi = mid-1;
        	} else {
        		lo = mid;
        	}
        }
        return lo;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement(new int[] {3,2,5,7,5,8})); //0 or 3 or 5
        System.out.println(solution.findPeakElement(new int[] {1,2,3,7,5,4})); //3
        System.out.println(solution.findPeakElement(new int[] {1,2,3,1})); //2
    }
}
