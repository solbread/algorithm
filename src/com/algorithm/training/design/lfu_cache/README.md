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

**Solution : Unsolved Solution** <br/>
3개의 저장소를 이용해서 get과 put을 구현하려고 하였다. <br/>
1. datas : 첫번째로는 data를 저장하는 map, <br/>
2. counter : data의 key를 key로 가지고 data가 몇번 호출되었고 몇번쨰로 호출되었는지를 저장하는 entry를 value로 가지는 map, <br/>
3. sortedMetaData : data의 key를 key로 가지고 data가 몇번 호출되었고 몇번째로 호출되었는지를 저장하는 entry를 value로 가지는 entry를 저장하는 heap이 있다. <br/>

* get
	1. sortedMetaData에서 해당 데이터를 제거
	2. counter에 새로운 정보를 put
	3. sortedMetaData에 새로운 정보를 add
	4. 몇번째로 호출되었는지를 의미하는 변수를 +1
	5. datas에서 해당 key를 반환
* put
	1. 넣고자하는 data의 key가 이미 datas에 없거나 datas의 사이즈가 capacity일 경우에는 sortedMetaData에서 poll한 data를 제거해준다.
	2. 넣고자하는 data의 key가 이미 datas에 있는 경우에는 기존 data를 제거해준다.
	3. data를 넣는다.
	
위의 방법으로 해결하려고 하였지만 구현에 실패하였다. <br/>