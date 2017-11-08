## 720. Longest Word in Dictionary

**Difficulty:** Easy

https://leetcode.com/problems/longest-word-in-dictionary/description/

Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. <br/.
If there is more than one possible answer, return the longest word with the smallest lexicographical order. <br/>

If there is no answer, return the empty string.

```
Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
```

**Note:** <br/>
* All the strings in the input will only contain lowercase letters.
* The length of words will be in the range [1, 1000].
* The length of words[i] will be in the range [1, 30].

**Show tag:** \#trie \#hash\_table

-----------------------------------------------

**Solution**
시간복잡도 : O(nlogn) 공간복잡도 : O(longestWord.length) <br/>
시간복잡도는 정렬에 소요되는 nlogn이며 공간복잡도는 trie구조의 depth가 logestWord의 길이까지 내려가므로 26*logestWord.length이다. <br/>
사전순으로 정렬된 words를 순회하면서 trie구조를 만들어준다. <br/>
우리가 원하는 것은 하나씩 문자를 더해가며 만들 수 있는 words내의 문자열을 구하는 것이므로 trie구조를 만들때 word의 0~length-2 까지의 문자로 구성된 문자열은 이미 trie 구조에 있어야한다.(words를 사전순으로 정렬하여 사용하기때문에 해당 문자를 만들 수 있다면 이미 0~length-2의 문자열이 trie안에 들어있다는 것이 보장된다.) <br/>
따라서 0~length-2까지의 문자열이 trie안에 없다면 skip하고 있다면 마지막 문자를 trie에 추가하고 현재까지의 가장 긴 문자열보다 길다면 문자열을 저장한다. <br/>
현재까지의 가장 긴 문자열과 길이가 같을 경우는 고려하지 않아도 되는데 그 이유는, <br/>
같은 길이의 정답 후보가 여러개가 있다면 사전순으로 앞에 있는 문자열을 반환해야 하는데, 이미 words배열을 정렬하여 사용하므로 제일 처음 등장한 문자열이 사전순으로 앞에 있음이 보장되기 때문이다. <br/>
