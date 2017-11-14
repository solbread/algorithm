package com.algorithm.training.hash_table.top_k_frequent_element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {
   public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int i = 0 ;i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0)+1);
        }
        Map<Integer, List<Integer>> frequenceCounter = new HashMap<>();
        Iterator<Integer> keys = counter.keySet().iterator();
        int maxFreqence = 0;
        while(keys.hasNext()) {
            int key = keys.next();
            if(!frequenceCounter.containsKey(counter.get(key))) {
                frequenceCounter.put(counter.get(key), new ArrayList<>());
            }
            frequenceCounter.get(counter.get(key)).add(key);
            maxFreqence = Math.max(maxFreqence, counter.get(key));
        }
        List<Integer> topKFrequentElementList = new ArrayList<>();
        while(k > 0) {
            if(frequenceCounter.get(maxFreqence) != null) {
                topKFrequentElementList.addAll(frequenceCounter.get(maxFreqence));
                k -= frequenceCounter.get(maxFreqence).size();
            }
            maxFreqence--;
        }
        return topKFrequentElementList;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> result = solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        for( int num : result) {
            System.out.print(num + " ");
        }
    }
}
