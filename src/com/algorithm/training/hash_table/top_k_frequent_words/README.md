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
1. You may assume k is always valid, 1 ¡Â k ¡Â number of unique elements.
2. Input words contain only lowercase letters.

**Show tag:** \#hash\_table \#heap \#trie

-------------------------------------

**Solution** <br/>
