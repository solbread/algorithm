package com.algorithm.training.hash_table.top_k_frequent_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
    	Map<String,Integer> wordCounter = new HashMap<>();
        Queue<Entry<String, Integer>> sortedWords = new PriorityQueue<>(
        		(a,b) -> ((b.getValue() - a.getValue() == 0) 
        				? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()));
        for(String word : words) {
        	wordCounter.put(word, wordCounter.getOrDefault(word, 0)+1);
        }
        
        for(Entry<String, Integer> entry : wordCounter.entrySet()) {
        	sortedWords.add(entry);
        	if(sortedWords.size() > k) {
        		sortedWords.poll();
        	}
        }
        List<String> topKFrequentList = new ArrayList<>();
        while(!sortedWords.isEmpty()) {
            topKFrequentList.add(0, sortedWords.poll().getKey());
        }
        return topKFrequentList;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"}; // i love
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}; // the is sunny day
        List<String> result1 = solution.topKFrequent(words1, 2);
        for(String str : result1) {
            System.out.print(str + " ");
        }
        System.out.println();
        List<String> result2 = solution.topKFrequent(words2, 4);
        for(String str : result2) {
            System.out.print(str + " ");
        }
    }
}
