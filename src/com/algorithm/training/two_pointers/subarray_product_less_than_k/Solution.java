package com.algorithm.training.two_pointers.subarray_product_less_than_k;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int subArrayCount = 0, i = 0, j = 0, multi = 1;
        while(j <= nums.length) {
            if(j == nums.length) {
                subArrayCount +=  ((j-i)*(j-i+1) / 2);
            } else {
                multi *= nums[j];
                if(multi >= k) {
                    subArrayCount += (j-i);
                    multi /= nums[i];
                    i++;
                }
            }
            j++;
        }
        return subArrayCount;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
	}
}
