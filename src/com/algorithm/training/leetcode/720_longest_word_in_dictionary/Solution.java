package com.algorithm.training.trie.longest_word_in_dictionary;

import java.util.Arrays;

public class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Object[] trie = new Object[26];
        String longestWord = null;
        for(String word : words) {
            char[] c = word.toCharArray();
            Object[] currentTrie = trie;
            for(int i = 0; i < word.length(); i++) {
                if(i < word.length()-1 && currentTrie[c[i]-'a'] == null) {
                    break;
                } else if(i == word.length()-1) {
                    currentTrie[c[i]-'a'] = new Object[26];
                    if(longestWord == null || longestWord.length() < word.length()) {
                        longestWord = word; 
                    }
                }
                currentTrie = (Object[])currentTrie[c[i]-'a'];
            }
        }
        return longestWord;
    }
	public static void main(String[] args) {
	    Solution solution = new Solution();
		System.out.println(solution.longestWord(new String[]{"w","wo","wor","worl", "world"})); //world
		System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"})); //apple
		System.out.println(solution.longestWord(new String[]{"a", "b"})); //a
		System.out.println(solution.longestWord(new String[]{"abb", "b", "a", "abbc", "ab"})); //abbc
		System.out.println(solution.longestWord(new String[]{"r","kt","jtgt","j","jtg","rdwy","chkext","c","l","zo","lnp","k","jt","chke","ktui","rd","jtgtha","ch","chkex"})); //jtgt
	}
}
