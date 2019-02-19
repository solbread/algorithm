package com.algorithm.training.binary_search.single_element_in_a_sorted_array;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int p = 0, q = nums.length-1;
        while(p<=q) {
            int mid = (p+q)/2;
            if(isNonDuplicate(nums,mid)) {
                return nums[mid];
            } else {
                if(nums[mid]==nums[mid+1]) {
                    if((nums.length-mid-2)%2==0) q = mid-1;
                    else p = mid+2;
                } else {
                    if((mid-1)%2==0) p = mid+1;
                    else q = mid-2;
                }
            }
        }
        return -1;
    }
    private boolean isNonDuplicate(int[] nums, int mid) {
        return ( (mid-1) < 0 || nums[mid]!=nums[mid-1]) 
                && ( (mid+1) >= nums.length || nums[mid]!=nums[mid+1]);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 3, 3, 4, 5, 5};
        System.out.println(solution.singleNonDuplicate(nums));
    }
}
