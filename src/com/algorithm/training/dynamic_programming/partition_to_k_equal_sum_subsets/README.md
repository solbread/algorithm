## 698. Partition to K Equal Sum Subsets

**Difficulty:** Medium

https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/

Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

```
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
```

**Note:**

**Show tag:** \#dynamic\_programming \#recursion \#depth\_first\_search

------------------------------------

**Solution** <br/>
시간복잡도 : O(n^3) 공간복잡도 : O(n) <br/>
_시간복잡도 추출을 잘 모르겠다._
Depth First Search를 이용하여 구현하였다.