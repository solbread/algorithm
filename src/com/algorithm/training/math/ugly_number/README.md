## 263. Ugly Number

**Difficulty:** Easy

https://leetcode.com/problems/ugly-number/description/

Write a program to check whether a given number is an ugly number. <br/>

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. <br/>
For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7. <br/>

Note that 1 is typically treated as an ugly number. <br/>

**Note** <br/>

**Show tag:** \#math

```
Input: 14
Output: false
```

-------------------------------------------

**Solution : Using Recursion** <br/>
시간복잡도 : O(logn) 공간복잡도 : O(1) <br/>
재귀호출할때마다 n은 최소 2로 나눠지므로 최악의경우 시간복잡도는 logn이 아닐까 생각한다. <br/>
주어진 숫자가 2 혹은 3 혹은 5로 나눠 떨어지지 않는다면 ugly number가 아니므로 false를 리턴한다. <br/>
만약 2 혹은 3 혹은 5로 나눠떨어진다면 나눈 몫을 계속 재귀호출하면서 1 or 2 or 3 or 5가 될떄까지 반복한다.

**Solution2 : Using Iterator** <br/>
시간복잡도 : O(logn) 공간복잡도 : O(1) <br/>
주어진 숫자를 2, 3, 5 순으로 더이상 나눠떨어지지 않을떄까지 나눈다. <br/>
마지막 결과 숫자가 1이 아니라면 ugly number가 아닌것이고 1이라면 ugly number인 것이다. 
