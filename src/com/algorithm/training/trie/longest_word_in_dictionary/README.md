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

**Solution : Using Trie** <br/>
시간복잡도 : O(nlogn) 공간복잡도 : O(longestWord.length) (n=words개수) <br/>
시간복잡도는 정렬에 소요되는 nlogn이며 공간복잡도는 trie구조의 depth가 logestWord의 길이까지 내려가므로 26*logestWord.length이다. <br/>
사전순으로 정렬된 words를 순회하면서 trie구조를 만들어준다. <br/>
우리가 원하는 것은 하나씩 문자를 더해가며 만들 수 있는 words내의 문자열을 구하는 것이므로 trie구조를 만들때 word의 0~length-2 까지의 문자로 구성된 문자열은 이미 trie 구조에 있어야한다.(words를 사전순으로 정렬하여 사용하기때문에 해당 문자를 만들 수 있다면 이미 0~length-2의 문자열이 trie안에 들어있다는 것이 보장된다.) <br/>
따라서 0~length-2까지의 문자열이 trie안에 없다면 skip하고 있다면 마지막 문자를 trie에 추가하고 현재까지의 가장 긴 문자열보다 길다면 문자열을 저장한다. <br/>
현재까지의 가장 긴 문자열과 길이가 같을 경우는 고려하지 않아도 되는데 그 이유는, <br/>
같은 길이의 정답 후보가 여러개가 있다면 사전순으로 앞에 있는 문자열을 반환해야 하는데, 이미 words배열을 정렬하여 사용하므로 제일 처음 등장한 문자열이 사전순으로 앞에 있음이 보장되기 때문이다. <br/>

**Best Solution : Using Trie** <br/>
시간복잡도 : O(n) 공간복잡도 : O(longestWord.length) (n=words개수) <br/>
내가 직접 trie 구조를 이용하여 푼 Solution은 맨 처음에 words배열을 정렬하므로 nlogn의 시간복잡도가 소요되었다. <br/>
그런데 정렬을 제거하여 O(n)만에 해결하는 방법으로 구현하였다. <br/>
참고자료 : https://discuss.leetcode.com/topic/109758/java-solution-with-trie <br/>

trie구조를 만들어주는데 단어의 끝인지를 표시하는 공간을 하나 더 두면서 모든 단어들에 대해 trie 구조를 만든다. <br/>
trie구조가 완성되면 trie구조를 dfs로 탐색하는데, <br/>
해당 문자가 단어의 끝이라면 현재까지 탐색한 문자열을 만들 수 있다는 것이기 때문에 <br/>
길이를 비교를 통해 가장 긴 문자열보다 길다면 문자열을 저장하며, 그 뒤에 문자를 또 붙이기 위해서 탐색을 계속한다. <br/>
해당 문자가 단어의 끝이 아니라면 현재까지 탐색한 문자열을 만들 수 없다는 것이기 때문에 탐색을 중단한다. <br/> 

이 솔루션에서 역시 trie 배열을 알파벳 순으로 dfs 탐색하므로 만들 수 있는 문자열이 현재까지 가장 긴 문자열의 길이와 같을경우는 고려하지 않아도 된다. <br/>


**Best Solution2 : Using Set** <br/>
시간복잡도 : O(nlogn) 공간복잡도 : O(n) (n=words개수) <br/>
시간복잡도는 정렬에 소요되는 nlogn이며 공간복잡도는 set의 크기인 words의 개수이다. <br/>
사전순으로 정렬된 words를 순회하면서 해당 문자열을 만들 수 있다면 set에 넣어주면서 현재까지의 가장 긴 문자열보다 길다면 저장한다. <br/>
해당 문자열을 만들 수 있는지의 확인은 문자열의 길이가 1이거나 문자열의 0~length-1 substring이 set에 이미 포함되어 있으면 만들 수 있다는 것이다. <br/>
현재까지의 가장 긴 문자열과 길이가 같을 경우는 고려하지 않아도 되는데 그 이유는, <br/>
같은 길이의 정답 후보가 여러개가 있다면 사전순으로 앞에 있는 문자열을 반환해야 하는데, 이미 words배열을 정렬하여 사용하므로 제일 처음 등장한 문자열이 사전순으로 앞에 있음이 보장되기 때문이다. <br/>