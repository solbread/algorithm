package com.algorithm.training.trie.longest_word_in_dictionary;

public class BestSolution {
    public String longestWord(String[] words) {
        Object[][] trie = new Object[26][2];
        for(String word : words) {
            char[] c = word.toCharArray();
            Object[][] currentTrie = trie;
            for(int i = 0; i < word.length(); i++) {
                if(currentTrie[c[i]-'a'][0] == null) {
                    currentTrie[c[i]-'a'][0] = new Object[26][2];
                }
                if(i == word.length()-1) {
                    currentTrie[c[i]-'a'][1] = true;
                }
                currentTrie = (Object[][])currentTrie[c[i]-'a'][0];
            }
        }
        String longestWord = getLongestWord(trie);
        return longestWord;
    }
    private String getLongestWord(Object[][] trie) {
        String longestWord = null;
        for(int i = 0; i < trie.length; i++) {
            if(trie[i][0] != null && trie[i][1] != null) {
                String currentWord = String.valueOf((char)('a'+i)) + getLongestWord((Object[][])trie[i][0]);
                if(longestWord == null || longestWord.length() < currentWord.length()) {
                    longestWord = currentWord.toString();
                }
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
