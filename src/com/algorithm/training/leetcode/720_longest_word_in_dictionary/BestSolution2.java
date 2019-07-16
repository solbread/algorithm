package com.algorithm.training.trie.longest_word_in_dictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BestSolution2 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> check = new HashSet<>();
        String longestWord = "";
        for(String word : words) {
            if(word.length() == 1 || check.contains(word.substring(0, word.length()-1))) {
                check.add(word);
                if(longestWord.length() < word.length()) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }
	public static void main(String[] args) {
	    BestSolution2 solution = new BestSolution2();
		System.out.println(solution.longestWord(new String[]{"w","wo","wor","worl", "world"})); //world
		System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"})); //apple
		System.out.println(solution.longestWord(new String[]{"a", "b"})); //a
		System.out.println(solution.longestWord(new String[]{"abb", "b", "a", "abbc", "ab"})); //abbc
		System.out.println(solution.longestWord(new String[]{"r","kt","jtgt","j","jtg","rdwy","chkext","c","l","zo","lnp","k","jt","chke","ktui","rd","jtgtha","ch","chkex"})); //jtgt
	}
}
