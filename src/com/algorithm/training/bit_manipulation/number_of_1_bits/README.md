## 191. Number of 1 Bits

**Difficulty:** Easy

https://leetcode.com/problems/number-of-1-bits/#/description

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight) <br/>

```
For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
```

**Show tag:** \#bit\_manipulation

----------------------

**Solution** <br/>
맨 오른쪽 비트부터 해당 비트가 1인지 아닌지를 판단하는 방식 (for문이 32번 돌면서 32비트를 확인) <br/>
n과 1을 & 연산을 하면 맨 오른쪽 비트가 1인지 아닌지 확인할 수 있음 (&연산의 결과가 1이라면 1인것이고 0이라면 0인것) <br/>
루프를 돌 때 마다 주어진 n을 1bit씩 오른쪽 shift연산을 하면서 비트가 1인지 아닌지를 확인
