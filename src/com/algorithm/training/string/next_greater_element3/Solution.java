package com.algorithm.training.string.next_greater_element3;

import java.util.Arrays;

public class Solution {
    public int nextGreaterElement(int n) {
        int nextGreaterNumber = -1;
        String number = String.valueOf(n);
        for(int i = number.length()-2; i >= 0; i--) {
        	if(number.charAt(i) < number.charAt(i+1)) {
        		StringBuilder sb = new StringBuilder();
        		if(i > 0) sb.append(number.substring(0, i));
        		char[] remainder = number.substring(i, number.length()).toCharArray();
        		char targetChar= remainder[1];
        		for(int j = 2; j < remainder.length; j++) {
        			if(remainder[j] > number.charAt(i) && remainder[j] < targetChar) {
        				targetChar = remainder[j];
        			}
        		}
        		sb.append(targetChar);
        		Arrays.sort(remainder);
        		for(int j = 0; j < remainder.length; j++) {
        			if(remainder[j]==targetChar) {
        				targetChar = 'n';
        				continue;
        			}
        			sb.append(remainder[j]);
        		}
        		try {
					nextGreaterNumber = Integer.parseInt(sb.toString());
				} catch (Exception e) {
					// TODO: handle exception
				}
        		break;
        	}
        }
        return nextGreaterNumber;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.nextGreaterElement(1200000)); //output:2000001
		System.out.println(solution.nextGreaterElement(1)); //output:-1
		System.out.println(solution.nextGreaterElement(12222333)); //output:12223233
		System.out.println(solution.nextGreaterElement(12443322)); //output:13222344
	}
}
