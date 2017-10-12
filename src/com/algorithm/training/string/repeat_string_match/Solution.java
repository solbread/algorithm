package com.algorithm.training.string.repeat_string_match;

public class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        for(int i = 0; i < Math.ceil((B.length()-1)/(double)A.length()); i++) {
            sb.append(A);
        }
        if(!sb.toString().contains(B)) return -1;
        int repeatCount = 1, aIndex = 0, bIndex = 0;
        while(bIndex < B.length()) {
            if(aIndex == A.length()) {
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
        System.out.println(solution.repeatedStringMatch("abacababacab", "abcdabcdabcdabcd")); //-1
	}
}


