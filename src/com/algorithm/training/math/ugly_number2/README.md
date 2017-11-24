## 264. Ugly Number2

**Difficulty:** Medium

https://leetcode.com/problems/ugly-number-ii/description/

Write a program to find the n-th ugly number. <br/>

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. <br/>
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers. <br/>

Note that 1 is typically treated as an ugly number, and n does not exceed 1690. <br/>

**Note** <br/>

**Show tag:** \#math \#dynamic\_programming \#heap

```
Input: 10
Output: 12
```

-------------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
ugly number는 2와 3과 5의 곱으로 이루어진 수 인데, 작은 순서대로 ugly number를 구하기 위해서 아래와 같은 방법을 사용한다. <br/>
가장 작은 ugly number는 1이므로 1에서 출발하여 1\*2, 1\*3, 1\*5 중에 작은 값을 ugly number에 넣고, 작은 값에 해당하는 factor는 다음으로 작은 ugly number와 곱하도록 하여 다시 비교하는것을 n번 반복한다. <br/>

유의할점은 2\*3 = 3\*2 이므로 곱의 결과가 같은경우를 제거해주기 위해서, 매 반복마다 가장 작은 ugly number를 구한후 해당 ugly number와 같은 결과가 나오는 모든 factor(2or3or5)를 비교 인덱스를 +1 해준다.
