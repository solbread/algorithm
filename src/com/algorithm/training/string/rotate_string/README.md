## 796. Rotate String

**Difficulty:** Easy

https://leetcode.com/problems/rotate-string/description/

We are given two strings, A and B.  

A shift on A consists of taking string A and moving the leftmost character to the rightmost position.  
For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

```
Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
```

**Note:** A and B will have length at most 100.

**Show tag:** \#string

----------------------------------------

**Solution** <br/>
시간복잡도 : O(n\*n) 공간복잡도 : O(n)  
A를 shift연산을 해서 B가 되는지를 구하는 것이므로  
A를 두번 이어붙인 문자열안에 B가 포함되면 shift 연산으로 B를 만들 수 있으며  
A를 두번 이어붙인 문자열안에 B가 포함되지 않으면 shift 연산으로 B를 만들 수 없다.  

contains 메소드가 내부적으로 n\*n 만큼 소요되므로 시간복잡도는 O(n\*n) 이며,  
n 길이의 문자열을 2번 이어붙이므로 2\*n 만큼의 공간을 사용하여 공간복잡도는 O(n)이다.

