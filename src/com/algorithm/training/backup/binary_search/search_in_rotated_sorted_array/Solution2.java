package com.algorithm.training.binary_search.search_in_rotated_sorted_array;

public class Solution2 {
    public int search(int[] nums, int target) {
    	if(nums.length == 0 ) return -1;
    	int lo = 0, hi = nums.length-1;
    	while(lo < hi) {
    		int mid = (hi-lo) /2 + lo;
    		if(nums[hi] < nums[mid]) {
    			lo = mid + 1;
    		} else {
    			hi = mid;
    		}
    	}
    	int smallestIdx = lo;
    	lo = 0;
    	hi = nums.length-1;
    	while(lo < hi) {
    		int mid = (hi - lo) / 2 + lo;
    		int realMid = (mid + smallestIdx) % nums.length;
    		if(nums[realMid] < target) {
    			lo = mid + 1;
    		} else {
    			hi = mid;
    		}
    	}
    	int ret = (hi+smallestIdx) % nums.length;
    	return nums[ret] == target ? ret : -1;
    }
    public static void main(String[] args) {
    	Solution2 solution = new Solution2();
        System.out.println(solution.search(new int[] {}, 5)); //-1
        System.out.println(solution.search(new int[] {0,1,2,3,4,5}, 2)); //2
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 2)); //6
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 3)); //-1
    }
}
