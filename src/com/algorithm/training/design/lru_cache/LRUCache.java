package com.algorithm.training.design.lru_cache;

public class LRUCache {
    public LRUCache(int capacity) {
        
    }
    
    public int get(int key) {
        return 0;
    }
    
    public void put(int key, int value) {
        
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
    }
}
