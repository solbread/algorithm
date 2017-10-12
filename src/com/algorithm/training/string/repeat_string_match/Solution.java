package com.algorithm.training.string.repeat_string_match;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int repeatedStringMatch(String A, String B) {
        Set<String> remainedNumbers = new HashSet<>();
        int repeatCount = 1, aIndex = 0, bIndex = 0;
        while(bIndex < B.length()) {
            if(aIndex == A.length()) {
                if(!remainedNumbers.add(B.substring(bIndex))) return -1;
                repeatCount++;
                aIndex = 0;
            }
            bIndex = (B.charAt(bIndex) == A.charAt(aIndex)) ? bIndex+1 : 0;
            aIndex++;
        }
        return repeatCount;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedStringMatch("abcd", "cdabcdab")); //3
        System.out.println(solution.repeatedStringMatch("abd", "cccc")); //-1
        System.out.println(solution.repeatedStringMatch("a", "aa")); //2
        System.out.println(solution.repeatedStringMatch("abcabcabcabc", "abac")); //-1
        System.out.println(solution.repeatedStringMatch("abacababacab", "abcdabcdabcdabcd"));
	}
}


