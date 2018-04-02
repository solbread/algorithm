## 801. Minimum Swaps To Make Sequences Increasing

**Difficulty:** Medium

https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/

We have two integer sequences A and B of the same non-zero length.  

We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.  

At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)  

Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.  

```
Example:
Input: A = [1,3,5,4], B = [1,2,3,7]
Output: 1
Explanation: 
Swap A[3] and B[3].  Then the sequences are:
A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
which are both strictly increasing.
```

**Show tag:** \#dynamic\_programming

**Note:**  
* A, B are arrays with the same length, and that length will be in the range [1, 1000].
* A[i], B[i] are integer values in the range [0, 2000].

-------------------------------------

**Solution : Using Recursion** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n)  
처음에는 calMinSwap(int idx, int\[\] A, int\[\] B)라는 함수를 만들어서, A와 B배열의 idx이후의 요소에서 minSwap값을 구하는 방식으로 접근하였다.  
이렇게해도 답은 구해졌지만 TLE가 발생하여 어떻게하면 시간복잡도를 줄일 수 있을까? 라는 생각을 하다가 해당 메소드가 중복호출됨을 발견하였고, 중복호출을 줄이기 위해 메모리제이션을 해야겠다고 결정하였다.  
해당 메소드는 A랑 B라는 배열을 파라미터로 사용하고 있었지만, 사실 해당 메소드내부에서 사용하는 값은 A와 B배열 각각의 idx-1, idx번째의 값이기 때문에 배열전체를 받을 파라미터로 사용할 이유가 없다는 것을 알게되었다  
idx-1번째의 값은 swap이 되었는지 되지않았는지에 따라서 값이 달라지므로 배열 A와B를 파라미터에서 제거하고 0또는 1을 가지는 isSwapped라는 변수를 이용해서 idx-1번째 값이 swap되었는지 되지않았는지를 나타내도록 하였다.  
이렇게해서 2\*n 공간을 가지는 cache에 메모리제이션을 할 수 있게 되었고 해당 메소드 역시 2\*n번 호출하여 답을 구할 수 있게 되었다.

*또한 사용하는 값이 idx-1과 idx이기 떄문에 cache를 2\*n만큼 사용할 필요가 없으며, A\[idx-1\], A\[idx\], B\[idx-1\], B\[idx\]를 담을 4개의 공간만 있으면 되기때문에 공간복잡도를 O(1)로 줄일 수 있다. 이부분에 대한 구현은 생략하고 아래에서 반복을 이용한 dp 구현으로 대체한다*

**Solution2 : Using Iterator**  
시간복잡도 : O(n) 공간복잡도 : O(1)  
Solution은 재귀호출을 이용하였다면 반복문을 이용한 dp로 수정한 솔루션이다  
참고 링크 : https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119830/Python-14-line-O(1)-space-O(n)-time-DP-solution  
![picture explanation](picture explanation.png)

cache\[i\]\[0\]은 i-1과 i를 swap하지 않았을때의 minSwapCount를 의미하며,  
cache\[i\]\[1\]은 i-1과 i를 swap했을 때의 minSwapCount이다.  
문제에서는 swap을 하거나 하지 않을 수 있으며, 만족하는 경우가 있음이 보장되므로 각 loop마다 아래의 조건이 하나이상 충족된다.
1. A\[i-1\] < A\[i\] && B\[i-1\] < B\[i\]
	1. i-1과 i를 swap하지 않았을 경우의 cache\[i\]\[0\] 값은 min(cache\[i\]\[0\], cache\[i-1\]\[0\])
	2. i-1과 i를 swap했을 경우에의 cache\[i\]\[1\] 값은 min(cache\[i\]\[1\], cache\[i-1\]\[1\]+1)
2. B\[i-1\] < A\[i\] && A\[i-1\] < B\[i\]
	1. i-1과 i를 swap하지 않았을 경우의 cache\[i\]\[0\] 값은 min(cache\[i\]\[0\], cache\[i-1\]\[1\])
	2. i-1과 i를 swap했을 경우의 cache\[i\]\[1\] 값은 min(cache\[i\]\[1\], cache\[i-1\]\[0\]+1)

위의 조건으로 dp를 구현하면 되며, dp에서 사용되는 값은 A\[i-1\], A\[i\], B\[i-1\], B\[i\]이므로 2\*n 크기의 cache배열을 사용할 필요가 없으므로 해당 부분은 4크기의 배열만 사용하여 메모리제이션하도록 윈도우기법을 이용해서 최적화가 가능하다.  
최적화는 prevMinSwap과 currentMinSwap을 이용하여 하였다.  
prevMinSwap\[0\]는 이전 index에서 swap을 하지 않았을때의 minSwapCount이며, prevMinSwap\[1\]는 이전 index에서 swap을 했을 때의 minSwapCount이다.  
현재 index에서 swap을 하지 않을때의 minSwapCount(currentMinSwap\[0\])와 swap을 할 때의 minSwapCount(currentMinSwap\[1\])를 구하여 prevMinSwap에 넣어주면서 최종적인 결과를 얻는다.  
