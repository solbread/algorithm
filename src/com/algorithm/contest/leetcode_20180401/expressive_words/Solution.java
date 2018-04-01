package com.algorithm.contest.leetcode_20180401.expressive_words;

public class Solution {
    public int expressiveWords(String S, String[] words) {
    	int count = 0;
    	char c[] = S.toCharArray();
    	for(String word : words) {
    		char[] wordChars = word.toCharArray();
    		int i = 0, j = 0;
    		boolean isMatched = true;
    		while(isMatched && i < c.length && j < wordChars.length) {
    			int iCount = 1, jCount = 1;
    			char ci = c[i], wj = wordChars[j];
    			while(++i < c.length && ci == c[i]) {
    				iCount++;
    			}
    			while(++j < wordChars.length && wj == wordChars[j]) {
    				jCount++;
    			}
    			isMatched = ci == wj && (iCount == jCount || iCount >= Math.max(jCount, 3));
    		}
    		if(isMatched && i == c.length && j == wordChars.length) count++;
    	}
    	return count;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.expressiveWords("heeellooo", new String[] {"hello", "hi", "helo"})); //1
		System.out.println(solution.expressiveWords("zzzzzyyyyy", new String[] {"zzyy", "zy", "zyy"})); //3
		System.out.println(solution.expressiveWords("aaaa", new String[] {"aaaaa"})); //0
		System.out.println(solution.expressiveWords("dddiiiinnssssssoooo", new String[] {"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"})); //3
	}
}
