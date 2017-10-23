## 692. Top K Frequent Words

**Difficulty:** Medium

https://leetcode.com/problems/top-k-frequent-words/description/

Given a non-empty list of words, return the k most frequent elements. <br/>

Your answer should be sorted by frequency from highest to lowest. <br/>
If two words have the same frequency, then the word with the lower alphabetical order comes first.

```
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
    
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
with the number of occurrence being 4, 3, 2 and 1 respectively.
```

**Note:**
1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements
2. Input words contain only lowercase letters.

**Show tag:** \#hash\_table \#heap \#trie

-------------------------------------

**Solution** <br/>
시간복잡도 : O(nlogk) 공간복잡도 : O(n) <br/>
우선 map을 이용해서 각 단어의 빈도수를 센 다음에 <br/>
map의 entry를 heap에 넣어서 상위 k개의 문자를 추출한다. <br/>
heap의 comparator를 재정의하여 빈도수를 1순위로 문자의 사전순을 2순위로 정렬해서 heap에서 꺼내면 된다. <br/>

처음에는 map을 만들고 모든 entry를 heap에 넣었는데 이렇게 하면 n개의 원소에 대해 map에서 접근하여 heap에 넣을 때 logn의 정렬연산이 소요되므로 O(nlogn)의 시간복잡도를 갖게 된다. <br/>
그런데 어차피 필요한것은 k번째까지의 문자열이므로 heap에 map의 모든 entry를 넣지 않고, heap을 오름차순이 아닌 내림차순으로 정렬 후 k size가 넘어가면 poll을 이용하여 맨 위의 요소를 제거해버리면 k번째까지의 entry만 저장되는것이 유지된다. <br/>
위와 같은 방법은 정렬할 때 logk만큼 소요되므로 시간복잡도를 O(nlogk)로 줄일 수 있다. <br/>