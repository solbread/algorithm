package com.algorithm.training.string.repeat_string_match;

public class Solution {
    public int repeatedStringMatch(String A, String B) {
        boolean isMatched = false;
        int repeatCount = 1, aIndex = 0, bIndex = 0;
        while(bIndex < B.length()) {
            if(aIndex == A.length()) {
                if(!isMatched) return -1;
                repeatCount++;
                aIndex = 0;
                isMatched = false;
            }
            if(B.charAt(bIndex) == A.charAt(aIndex)) {
                aIndex++;
                bIndex++;
                isMatched = true;
            } else {
                aIndex++;
            }
        }
        return repeatCount;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedStringMatch("abcd", "cdabcdab")); //3
        System.out.println(solution.repeatedStringMatch("abd", "cccc")); //-1
        System.out.println(solution.repeatedStringMatch("a", "aa")); //2
	}
}
