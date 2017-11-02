## 713. Subarray Product Less Than K

**Difficulty:** Easy

https://leetcode.com/problems/subarray-product-less-than-k/description/

Your are given an array of positive integers nums. <br/>
Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

```
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
```

**show tag:** \#array \#two_pointers

----------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(1) <br/>
두개의 포인터는 0에서 출발하여 multi에 누적해서 각 숫자들을 누적해서 곱해간다. <br/>
[10,5,2,6]의 배열에서 i=0, j=2일경우 [10,5,2]인데 이 경우 10이 맨 처음에 오는 subarray의 개수는 범위의 크기 즉, j-i+1이다. (10 / 10,5 / 10,5,2) <br/>
이를 이용해서 포인터 i, j를 이용해서 답에 접근한다. (i가 앞포인터, j가 뒷포인터로 정의) <br/>
반복문은 뒷포인터인 j가 nums배열을 다 순회할때까지 반복하면 된다. <br/>
(j가 nums.length에 도달했을 경우에는 i~j범위의 모든 sub array 개수를 count해주고 탐색을 종료한다.) <br/>

j를 증가시키면서 누적해서 곱을 진행하는데, <br/>
누적곱이 k보다 커질 경우 i인덱스에서 시작했을 경우에는 j-1인덱스까지만 누적곱이 k이하이므로 i에서 시작하는 j-1까지의 subarray의 개수를 더해준 후 i인덱스를 증가시킨다. <br/>
그런데 i인덱스를 증가시키더라도 여전히 누적곱이 k보다 클 수 있으므로 위의 작업을 누적곱이 k보다 작아질때까지 반복한다. <br/>

(구현시 놓쳤던 부분)
1. i는 j보다 커질수 없음을 유념해서 구현해야 한다. (누적곱에는 j까지의 숫자들이 들어가있으므로 i를 늘려줄때 계속 j를 넘어가도록 증가시키면 안된다.)
2. j가 nums배열을 다 순회하여 남은 i~j 범위의 모든 sub array 개수를 카운트해줄때 사용하는 공식에서 int 범위초과가 발생하므로 해당부분은 casting이 필요하다.