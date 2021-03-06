package com.algorithm.training.design.lfu_cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.AbstractMap;

public class LFUCache {
    Map<Integer, Integer> datas;
    Map<Integer, Entry<Integer, Integer>> counter;
    Queue<Entry<Integer, Entry<Integer, Integer>>> sortedMetaData;
    int usingIndex, capacity;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.usingIndex = 0;
        datas = new HashMap<>(capacity);
        counter = new HashMap<>(capacity);
        sortedMetaData = new PriorityQueue<>((a, b) -> 
            ( (a.getValue().getKey() - b.getValue().getKey() == 0) 
                    ? a.getValue().getValue() - b.getValue().getValue() : a.getValue().getKey() - b.getValue().getKey() ));
    }
    
    public int get(int key) {
        if(!datas.containsKey(key)) return -1;
        sortedMetaData.remove(new AbstractMap.SimpleEntry<>(key, counter.get(key)));
        counter.put(key, new AbstractMap.SimpleEntry<>(counter.get(key).getKey()+1, usingIndex));
        sortedMetaData.add(new AbstractMap.SimpleEntry<>(key, counter.get(key)));
        this.usingIndex++;
        return datas.get(key);
    }

    public void put(int key, int value) {
        if(this.capacity == 0) return;
        if(!this.datas.containsKey(key) && this.datas.size() == capacity) {
            Entry<Integer, Entry<Integer, Integer>> removedData = sortedMetaData.poll();
            datas.remove(removedData.getKey());
            counter.remove(removedData.getKey());
        } 
        if(datas.containsKey(key)) {
            sortedMetaData.remove(new AbstractMap.SimpleEntry<>(key, counter.get(key)));
            counter.remove(key);
            datas.remove(key);
        }
        datas.put(key, value);
        counter.put(key, new AbstractMap.SimpleEntry<>(0, usingIndex));
        sortedMetaData.add(new AbstractMap.SimpleEntry<>(key, counter.get(key)));
        usingIndex++;
    }
    
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        System.out.println(cache.get(2)); // -1
        cache.put(2, 6);
        System.out.println(cache.get(1)); // -1
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1)); // 2
        System.out.println(cache.get(2)); // 6
        
        cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2)); //2
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println(cache.get(2)); //2
        
        cache = new LFUCache(0);
        cache.put(0, 0);
        System.out.println(cache.get(0)); //-1
        
        cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));;      // returns 3.
        cache.put(4, 4);                        // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
