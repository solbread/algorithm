## 718. Maximum Length of Repeated Subarray

**Difficulty:** Medium

https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/

Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 
```
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
```

**Note:**

**Show tag:** \#dynamic\_programming

------------------------------------

**Solution** <br/>
시간복잡도 : O(n\*m) 공간복잡도 : O(n\*m) (n=A의길이 m=B의길이) <br/>
getFindMaxLength(int aIdx, int bIdx)를 aIndx에서 시작하는 A배열과 bIndex에서 시작하는 B배열의 겹치는 subarray의 최대길이를 반환하는 메소드로 정의한다 <br/>
만약 A[aIdx] == B[bIdx]이면 겹치는 subarray의 길이와, index를 하나씩 이동하여 getFindMaxLength메소드를 재귀호출 한 것 중 max값을 반환하고, <br/>
만약 A[aIdx] != B[bIdx]이면 index를 하나씩 이동한 getFindMaxLength메소드의 결과중 max값을 반환하면 된다. <br/>