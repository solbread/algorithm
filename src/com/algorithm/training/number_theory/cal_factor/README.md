## Cal Factor

**Difficulty:** Easy

알고리즘 문제해결 전략 497p 예제

주어진 자연수 n의 소인수분해 결과를 반환한다.

**Note:**

**Show tag:** \#number\_#theory

----------------------------------------------

**Solution** <br/>
시간복잡도 : O(루트n) 공간복잡도 : O(1) <br/>
2부터 루트n까지 반복순회하면서 n의 약수를 찾을때마다 n을 더이상 이 숫자로 나눌 수 없을 떄까지 나눈다. <br/>
소인수분해는 n을 소수의 곱으로 나타내는 것이지만 이 코드에서는 2부터 루트n까지의 모든 숫자로 나눠주는데 이렇게 해도 상관 없는 이유는 아래와 같다.<br/>
i가 합성수라면 이미 n은 i의 소인수들로 최대한 나눠진 뒤이기 때문에 n이 i로 나눠떨어질리가 없기 때문이다. <br/>
위와 같은 이유로 2부터 루트n까지의 순회를 다 끝내고 남은 n이 1이 아니라면, 소수이기 때문에 마지막에 리스트에 추가해주는 작업도 필요하다.