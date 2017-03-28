## 190. Reverse Bits

https://leetcode.com/problems/reverse-bits/#/description

Reverse bits of a given 32 bits unsigned integer.

```
For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
```

**Follow up** <br/>
If this function is called many times, how would you optimize it?

**Show tag:** \#bit\_manipulation

----------------------------

**Solution : 실패한 코드** <br/>
맨 오른쪽 비트부터 해당 비트가 1인지 아닌지를 판단하여(n&1연산을 이용해) 1이면 Math.pow(2,31-오른쪽몇번째인지)를 result에 누적해서 구해보려고 했는데 치명적인 문제점이 있었음 <br/>
**※** Java에서는 int형이 signed형이기 때문에 맨왼쪽 비트를 부호비트로 사용하기 때문에 Integer.MAX_VALUE값이  2147483647(01111111111111111111111111111111)임 <br/>
따라서 pow(2,31)을 하면 2147483648이 아닌 2147483647가 되므로 제대로된 값을 표현할 수 없음 <br/>
위와 같은 이유로 수학 연산이 아닌 비트연산을 이용해야 함을 깨달음

**Best Solution** <br/>
for문을 32번 반복하며 매 반복마다 result의 비트를 1bit씩 왼쪽 쉬프트해줌 <br/>
또한 for루프마다 n의 가장 오른쪽 비트값을 result에다가 더해줌 <br/>
위와 같이 for문을 실행하면 매 for문마다 result가 1bit씩 왼쪽으로 이동하면서 reverse 됨 <br/>
