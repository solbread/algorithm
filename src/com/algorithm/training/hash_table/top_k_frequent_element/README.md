## 347. Top K Frequent Elements

**Difficulty:** Medium

https://leetcode.com/problems/top-k-frequent-elements/description/

Given a non-empty array of integers, return the k most frequent elements.

```
For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].
```

**Note:**
1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
2. Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

**Show tag:** \#hash\_table \#heap \#bucket\_sort

-------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
O(n)이 소요되는 3단계로 나누어서 문제를 해결한다. <br/>
1. 배열을 순회하며 각 숫자의 등장 횟수를 map에 count한다.
2. count한 map을 순회하며 등장횟수별로 숫자의 리스트를 map에 저장한다. (등장횟수는 최대 n이므로 n 크기의 배열에다가 숫자리스트를 저장해도 된다.)
3. 등장횟수가 제일 높은 list부터 결과 list에 넣어준다.

**Best Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
Solution이랑 똑같은 로직으로 리펙토링만 진행하였다. <br/>
각 숫자의 빈도수는 최대 n번이므로 빈도수를 저장하는 map의 인덱스는 0~n까지 가질 수 있다. <br/>
따라서 map이 아닌 배열로 심플하게 구현가능하다.
