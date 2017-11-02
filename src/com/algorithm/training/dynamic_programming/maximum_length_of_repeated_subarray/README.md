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

**Best Solution** <br/>
참고자료 : https://discuss.leetcode.com/topic/108722/concise-java-dp-same-idea-of-longest-common-substring <br/>
dp\[i\]\[j\]에는 A의 0~i 원소들과 B의 0~j 원소들에 대해 만들 수 있는 겹치는 subarray의 최대길이로 정의한다. <br/>
그래서 A\[i\]랑B\[j\]가 같다면 dp\[i\]\[j\]에는 dp\[i-1\]\[j-1\]+1이 들어가게 된다. <br/>
dp배열중에 최대값이 답이된다. <br/>
