package com.algorithm.training.dynamic_programming.minimum_swaps_to_makes_sequences_increasing;

public class Solution {
    public int minSwap(int[] A, int[] B) {
        return calMinSwap(0, A, B);
    }
    
    private int calMinSwap(int idx, int[] A, int[] B) {
    	int minSwap = 111110;
    	
    	if(idx == A.length) return 0;
    	
    	if(idx == 0 || (A[idx-1] < A[idx] && B[idx-1] < B[idx])) {
    		minSwap = Math.min(minSwap, calMinSwap(idx+1, A, B));
    	}
    	
    	if(idx == 0 || (A[idx-1] < B[idx] && B[idx-1] < A[idx])) {
    		swap(idx, A, B);
    		minSwap = Math.min(minSwap, calMinSwap(idx+1, A, B)+1);
    		swap(idx, A, B);
    	}
    	
    	return minSwap;
    }
    
    private void swap(int idx, int[] A, int[] B) {
    	int tmp = A[idx];
    	A[idx] = B[idx];
    	B[idx] = tmp;
    }
    
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minSwap(new int[] {3,5,6,9,14,15,15,18,17,20}, new int[] {3,4,5,8,10,14,17,16,19,19})); //2
		System.out.println(solution.minSwap(new int[] {3,3,8,9,10}, new int[] {1,7,4,6,8})); //1
		System.out.println(solution.minSwap(new int[] {1,3,5,4}, new int[] {1,2,3,7})); //1
	}
}
