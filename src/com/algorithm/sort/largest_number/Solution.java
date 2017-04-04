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
               if(o1.length() > o2.length()) {
                   char c = o2.charAt(0);
                   for(int i = 0; i < o1.length() - o2.length(); i++) {
                       o2+=String.valueOf(c);
                   }
               }
               else if(o1.length() < o2.length()) {
                   char c = o1.charAt(0);
                   for(int i = 0; i < o2.length() - o1.length(); i++) {
                       o1+=String.valueOf(c);
                   }                   
               }
               return o2.compareTo(o1);
           }
        });
        StringBuilder sb = new StringBuilder();
        for(String numStr : numsStr) {
            sb.append(numStr);
        }
        return sb.toString();
    }	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int nums[] = {3, 30, 34, 5, 9};
		System.out.println(solution.largestNumber(nums));
	}
}
