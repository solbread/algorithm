## is prime

**Difficulty:** Easy

알고리즘 문제해결 전략 496p 예제

주어진 자연수 n이 소수인지 판별한다.

**Note:**

**Show tag:** \#dynamic\_programming

----------------------------------------------

**Solution** <br/>
시간복잡도 : O(루트n) 공간복잡도 : O(1) <br/>
2이하는 예외처리를 해주고 for루프로 1부터 루트n까지 순회하면서 나눠떨어지면 false를 리턴하고, <br/>
나눠떨어지는게 없으면 true를 리턴한다.


