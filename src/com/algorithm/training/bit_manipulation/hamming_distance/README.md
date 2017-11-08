## 461. Hamming Distance

**Difficulty:** Easy

https://leetcode.com/problems/hamming-distance/description/

The Hamming distance between two integers is the number of positions at which the corresponding bits are different. <br/>
Given two integers x and y, calculate the Hamming distance.

```
Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
```

**Note:** 0 ≤ x, y < 231. <br/>

**Show tag:** \#bit\_manipulation

----------------------

**Solution** <br/>
시간복잡도 : O(1) 공간복잡도 O(1) <br/>
두 수의 다른 bit를 세는 것이므로 XOR 연산을 통해 다른 비트만 1이 되도록 하여 1인 bit 개수를 세면 된다.