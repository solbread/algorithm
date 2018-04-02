package com.algorithm.training.hash_table.unique_morse_code_words;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morses = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> uniqueMorseRepresentationSet = new HashSet<>();
        for(String word : words) {
        	StringBuilder morseRepresentation = new StringBuilder();
        	for(char c : word.toCharArray()) {
        		morseRepresentation.append(morses[c-'a']);
        	}
        	uniqueMorseRepresentationSet.add(morseRepresentation.toString());
        }
        return uniqueMorseRepresentationSet.size();
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"})); //2
	}
}
