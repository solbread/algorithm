package com.algorithm.sort.largest_number;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               return (o2+o1).compareTo(o1+o2);
           }
        });
        
        if(numsStr[0].charAt(0) == '0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String numStr : numsStr) {
            sb.append(numStr);
        }
        return sb.toString();
    }	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int nums[] = {3, 30, 34, 5, 9};
//		int nums[] = {121, 12};
		int nums[] = {0, 0};
		System.out.println(solution.largestNumber(nums));
	}
}
