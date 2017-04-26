package com.algorithm.training.string.next_greater_element3;

import java.util.Arrays;

public class Solution {
    public int nextGreaterElement(int n) {
        int nextGreaterNumber = -1;
        String number = String.valueOf(n);
        for(int i = number.length()-2; i >= 0; i--) {
        	if(number.charAt(i) < number.charAt(number.length()-1)) {
        		StringBuilder sb = new StringBuilder();
        		if(i > 0) sb.append(number.substring(0, i));
        		char[] remainder = number.substring(i, number.length()).toCharArray();
        		Arrays.sort(remainder);
        		for(int j = remainder.length-1; j >= 0; j--) {
        			sb.append(remainder[j]);
        		}
        		try {
					nextGreaterNumber = Integer.parseInt(sb.toString());
				} catch (Exception e) {
					// TODO: handle exception
				}
        	}
        	break;
        }
        return nextGreaterNumber;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.nextGreaterElement(1234));
	}
}
