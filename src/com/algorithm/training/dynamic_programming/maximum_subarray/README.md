## 53. Maximum Subarray

**Difficulty:** Easy

https://leetcode.com/problems/maximum-subarray/#/description

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

```
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
```

**Show tag:** \#array \#dynamic\_programming \#divide\_and\_conquer

-------------------------------------

**Solution** <br/>
시간복잡도 : O(n), 공간복잡도 : O(1)
Maximum Subarray Problem에서 가장 빠른 알고리즘으로 알려진 Kadane's Algorithm을 이용하였다. (Kadane's Algorithm에 대한 자세한 설명은 원노트 참조) <br/>
현재 출발 index에서 최대값을 저장하는 currentMax와 전체 array의 max값을 저장하는 maxSum을 사용하여 한번의 for loop만에 해결한다. <br/>
currentMax에 배열의 원소를 누적하다가 currentMax+array[i]보다 array[i]가 더 큰 지점에서 currentMax값을 바꿔준다. <br/>
currentMax+array[i] < arry[i]일떄의 의미는 i-1까지의 subarray보다 i가 더 크다는 것이기 때문에 i부터 새로운 subarray를 만들면 된다. <br/>
maxSum에는 계속해서 currentMax의 최대값을 누적하면서 전체 subarray의 최대값을 찾는 것이다.