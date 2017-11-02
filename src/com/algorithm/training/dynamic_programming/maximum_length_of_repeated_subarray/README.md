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

**Show tag:** \#dynamic\_programming \#array \#hash\_table \#binary\_search

------------------------------------

**Solution** <br/>
시간복잡도 : O(n\*m) 공간복잡도 : O(n\*m) (n=A의길이 m=B의길이) <br/>
getFindMaxLength(int aIdx, int bIdx)를 aIndx에서 시작하는 A배열과 bIndex에서 시작하는 B배열의 겹치는 subarray의 최대길이를 반환하는 메소드로 정의한다 <br/>
만약 A[aIdx] == B[bIdx]이면 겹치는 subarray의 길이와, index를 하나씩 이동하여 getFindMaxLength메소드를 재귀호출 한 것 중 max값을 반환하고, <br/>
만약 A[aIdx] != B[bIdx]이면 index를 하나씩 이동한 getFindMaxLength메소드의 결과중 max값을 반환하면 된다. <br/>

** Best Solution (Using DP) ** <br/>
시간복잡도 : O(n\*m) 공간복잡도 : O(n\*m) (n=A의길이 m=B의길이) <br/>
참고자료 : https://discuss.leetcode.com/topic/108722/concise-java-dp-same-idea-of-longest-common-substring <br/>
dp\[i\]\[j\]에는 A의 0~i 원소들과 B의 0~j 원소들에 대해 만들 수 있는 겹치는 subarray의 최대길이로 정의한다. <br/>
그래서 A\[i\]랑B\[j\]가 같다면 dp\[i\]\[j\]에는 dp\[i-1\]\[j-1\]+1이 들어가게 된다. <br/>
dp배열중에 최대값이 답이된다. <br/>

**Best Solution2 (Refactoring Best Solution)** <br/>
시간복잡도 : O(n\*m) 공간복잡도 : O(m) (n=A의길이 m=B의길이) <br/>
참고자료 : https://discuss.leetcode.com/topic/108777/dp-o-n-2-with-o-n-space <br/> 
Best Solution의 답안을 공간복잡도를 줄이는 방향으로 리팩토링한 것이다. <br/>
Best Solution의 코드를 보면 dp\[\]\[\]의 max값을 찾게되는데 dp\[1\]\[\] dp\[2\]\[\] dp\[n\]\[\]순으로 채워지게 된다. <br/>
또한 각 dp\[i\]\[\] 는 dp\[i-1\]\[\]를 이용해서 구하게 되므로 2차원배열을 써서 모든 i에 대해 저장할 필요 없이 직전 행의 값들(i-1행)만 알고 있으면 되므로 1차원 배열로 줄일 수 있다. <br/>
i-1행의 dp 배열에 i행의 값들로 순차적으로 새로 채워나가면서 꼭 필요한 정보를 저장하면 된다. <br/>
변경할 때 주의할점은 2가지가 있다. <br/>
1. 열의 순회를 원래는 1에서 m까지 하였는데, dp\[i\]\[j\]를 채우기 위해서는 dp\[i-1\]\[j-1\]값을 알아야 하는데, dp[j]로 줄였을 때 1에서 m방향으로 해버리면 dp[j-1]의 값은 이미 i행에 대한 값으로 덮어씌워져버린 상태이기 떄문에 i-1행에 대한 값을 알 수 없으므로 열의 순회를 m에서 1로 거꾸로 바꿔준다. <br/>
2. 또한 dp[j]에는 i번째 행에 대한 값들로 매번 셋팅되어야 한다. A[i-1]==B[j-1]일때만 값을 넣어주지 말고 0으로라도 넣어줘야한다. <br/>


**Best Solution3 (Using HashMap)** <br/>
시간복잡도 : O(n*min(n,m)) 공간복잡도 : O(n) (n=A의길이 m=B의길이) <br/>
_시간복잡도와 공간복잡도 잘 모르겠다._ <br/>
참고자료 : https://discuss.leetcode.com/topic/108725/simple-java-solution-using-hashmap <br/>
맵을 이용하여 구현하였다. <br/>
먼저 A배열을 순회하며 원소값을 key로 가지고 index를 value list에 추가하여 map을 만든다. <br/>
그 후 B배열을 순회하면서 해당 원소가 map에 있는지를 확인하고 있다면 index를 담고있는 list를 순회하며 만들 수 있는 겹치는 subarray의 길이를 계산한다. <br/>
반복하여 계산하며 최대값을 구한다.