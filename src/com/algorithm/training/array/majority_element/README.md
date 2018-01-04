## 169. Majority Element

**Difficulty:** Easy

https://leetcode.com/problems/majority-element/description/

Given an array of size n, find the majority element. <br/>
The majority element is the element that appears more than ⌊ n/2 ⌋   times. <br/>

You may assume that the array is non-empty and the majority element always exist in the array.

```
Input: [1,2,2]
Outout: 2
```

**Note:**

**Show tag:** \#array \#divide\_and\_conquer \#bit\_manipulation

-------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
가장 단순하게 num이 몇번나왔는지를 세는 map을 두고, <br/>
숫자들의 등장횟수를 세다가 n/2초과하여 등장하는 숫자가 나오면 return하였다. <br/>



