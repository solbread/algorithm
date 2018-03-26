package com.algorithm.training.string.rotate_string;

public class Solution {
    public boolean rotateString(String A, String B) {
        return (A+A).contains(B);
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.rotateString("abcde", "cdeab")); //true
		System.out.println(solution.rotateString("abcde", "abced")); //false
	}
}
