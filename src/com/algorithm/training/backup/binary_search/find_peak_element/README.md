## 162. Find Peak Element

**Difficulty:** Medium

https://leetcode.com/problems/find-peak-element/description/

A peak element is an element that is greater than its neighbors. <br/>

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index. <br/>

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine. <br/>

You may imagine that num[-1] = num[n] = -∞. <br/>

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2. <br/>

```
Input: [1,2,3,1]
Output: 2
```

**Note:** Your solution should be in logarithmic complexity.

**Show tag:** \#binary_search \#array

------------------------------------

**Solution** <br/>
시간복잡도 : O(logn) 공간복잡도 : O(1) <br/>
이진탐색을 이용하여 peak element를 찾는다. <br/>
num\[-1\]과 num\[n\]은 -무한대 이며, 여러개의 peak element가 존재하면 아무거나 반환하면 되므로, <br/>
nums\[x-1\] > nums\[x\] 이면 nums\[-1\]이 -무한대이고 nums\[x\]가 nums\[x-1\]보다 작으므로 \[0,x-1\]사이에 peak element가 있다. <br/>
반대로 nums\[x\] < nums\[x+1\]이면 nums\[n\]이 -무한대이고 nums\[x\]가 nums\[x+1\]보다 작으므로 \[x+1,n-1\]사이에 peak element가 있다. <br/>