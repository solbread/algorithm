## 460. LFU Cache

**Difficulty:** Hard

https://leetcode.com/problems/lfu-cache/description/

Design and implement a data structure for Least Frequently Used (LFU) cache. <br/>
It should support the following operations: get and put. <br/>

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. <br/>
put(key, value) - Set or insert the value if the key is not already present. <br/>
When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. <br/>
For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

```
LFUCache cache = new LFUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
```

**Note** <br/>

**Shot tag:** \#design

----------------------

**Solution** <br/>
