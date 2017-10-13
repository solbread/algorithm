package com.algorithm.training.string.repeat_string_match;

public class BestSolution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder repeatedA = new StringBuilder();
        int repeatedCount = 0;
        while(repeatedA.length() < B.length()) {
            repeatedA.append(A);
            repeatedCount++;
        }
        if(repeatedA.toString().contains(B)) return repeatedCount;
        if(repeatedA.append(A).toString().contains(B)) return ++repeatedCount;
        return -1;
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


