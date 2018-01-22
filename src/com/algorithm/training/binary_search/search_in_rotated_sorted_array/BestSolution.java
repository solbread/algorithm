package com.algorithm.training.binary_search.search_in_rotated_sorted_array;

public class BestSolution {
    public int search(int[] nums, int target) {
    	if(nums.length == 0) return -1;
    	int lo = 0, hi = nums.length-1;
    	while(lo < hi) {
    		int mid = (hi - lo) / 2 + lo;
    		int value = nums[mid];
    		if(nums[lo] > nums[mid] && nums[lo] <= target) value = Integer.MAX_VALUE;
    		else if(nums[lo] <= nums[mid] && nums[lo] > target) value = Integer.MIN_VALUE;
    		if(target <= value) {
    			hi = mid;
    		} else {
    			lo = mid+1;
    		}
    	}
    	return nums[lo] == target ? lo : -1;
    }
    public static void main(String[] args) {
    	BestSolution solution = new BestSolution();
        System.out.println(solution.search(new int[] {}, 5)); //-1
        System.out.println(solution.search(new int[] {1, 3}, 1)); //0
        System.out.println(solution.search(new int[] {1, 3}, 3)); //1
        System.out.println(solution.search(new int[] {3, 1}, 1)); //1
        System.out.println(solution.search(new int[] {0,1,2,3,4,5}, 2)); //2
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 2)); //6
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 3)); //-1
    }
}
