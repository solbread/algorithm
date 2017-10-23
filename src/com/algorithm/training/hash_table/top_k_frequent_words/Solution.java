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
        Queue<Entry<String, Integer>> wordCounter = new PriorityQueue<>();
        for(String word : words) {
            
        }
        List<String> topKFrequentList = new ArrayList<>();
        while(k-- > 0) {
            topKFrequentList.add(wordCounter.poll().getKey());
        }
        return topKFrequentList;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
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
