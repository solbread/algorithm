package com.algorithm.training.binary_search.search_in_rotated_sorted_array;

public class BestSolution3 {
    public int search(int[] nums, int target) {
    	if(nums.length == 0) return -1;
    	int lo = 0, hi = nums.length-1;
    	while(lo < hi) {
    		int mid = (hi-lo) / 2 + lo;
    		if(nums[lo] <= nums[mid]) {
    			if(nums[lo] <= target && nums[mid] >= target) {
    				hi = mid;
    			} else {
    				lo = mid+1;
    			}
    		} else {
    			if(nums[mid] < target && nums[lo] > target) {
    				lo = mid+1;
    			} else {
    				hi = mid;
    			}
    		}
    	}
    	return (nums[lo] == target) ? lo : -1;
    }
    public static void main(String[] args) {
    	BestSolution3 solution = new BestSolution3();
        System.out.println(solution.search(new int[] {}, 5)); //-1
        System.out.println(solution.search(new int[] {1, 3}, 1)); //0
        System.out.println(solution.search(new int[] {1, 3}, 3)); //1
        System.out.println(solution.search(new int[] {3, 1}, 1)); //1
        System.out.println(solution.search(new int[] {0,1,2,3,4,5}, 2)); //2
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 2)); //6
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 3)); //-1
    }
}
