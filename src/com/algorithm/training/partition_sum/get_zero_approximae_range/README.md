## Get Zero Approximate Range

**Difficulty:** None

알고리즘 문제해결 전략 601p 예제

양수와 음수가 모두 포함된 배열이 주어질 때, <br/>
그 합이 0에 가장 가까운 부분합을 찾아라.

```
Input:
[-14, 7, 2, 3, -8, 4, -6, 8, 9, 11]

Output: 
1
(numbers[2]~numbers[5])
```

**Note:**

**Show tag:** \#partition\_#sum

----------------------------------------------

**Solution** <br/>
시간복잡도 : O(nlogn) 공간복잡도 : O(n) <br/>
부분합을 저장하는 배열이 있을 경우 i~j 구간의 부분합은 partitionSum[j]-partitionSum[i-1]로 구하기 때문에, <br/>
부분합이 0에 가깝다는 것은 partitionSum[j]와 partitionSum[i-1]의 차이가 가장 적다는 의미이다. <br/>
따라서 부분합의 배열을 구한 후 이를 정렬시켜 인접한 원소끼리 비교하여 가장 차이가 적은 구간의 부분합을 반환한다.

유의할 점은 i~j구간에서 i가 0일경우의 부분합은 partitionSum[j]라는 것이다. <br/>
따라서 정렬된 부분합의 배열을 순회할 때 partitionSum[j]과 partitionSum[i-1]차이랑, partitionSum[j]의 절대값 중에 작은것을 구해야 한다.
