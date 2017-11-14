package com.algorithm.training.hash_table.top_k_frequent_element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution2 {
   public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int i = 0 ;i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0)+1);
        }
        @SuppressWarnings("unchecked")
		List<Integer>[] frequenceCounter = new List[nums.length];
        Iterator<Integer> keys = counter.keySet().iterator();
        while(keys.hasNext()) {
            int key = keys.next();
            if(frequenceCounter[counter.get(key)] == null) {
                frequenceCounter[counter.get(key)] = new ArrayList<>();
            }
            frequenceCounter[counter.get(key)].add(key);
        }
        List<Integer> topKFrequentElementList = new ArrayList<>();
        for(int i = frequenceCounter.length-1; i >= 0; i--) {
        	if(frequenceCounter[i] != null) {
        		topKFrequentElementList.addAll(frequenceCounter[i]);
        		if(topKFrequentElementList.size() == k) break;
        	}
        }
        return topKFrequentElementList;
    }
    
    public static void main(String[] args) {
    	Solution2 solution = new Solution2();
        List<Integer> result = solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        for( int num : result) {
            System.out.print(num + " "); // 1 2
        }
    }
}
