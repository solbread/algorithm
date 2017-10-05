## Sum Of Numbers

**Difficulty:** None

Algorithmic Problem Solving Starategies책에 나온 예제 (176p)

1부터 n까지의 합을 구하세요.

**Show tag:** \#exhaustive\_search \#divide_and_conquer

------------------------------------

**Solution : Using Exhaustive Search** <br/>
시간복잡도 : O(n) <br/>
가장 기본적인 방법으로 완전탐색방법을 이용하여 1부터 n까지의 합을 구하였다.

**Solution2 : Using Divide And Conquer** <br/>
시간복잡도 : O(log n) <br/>
분할정복을 이용하여 구하였다. <br/>
n이 짝수일때 <br/>
1부터 n까지의 합은 <br/>
1 + 2 + ... + n <br/>
= 1 + 2 + ... + n/2 + (n/2 + 1) + (n/2 + 2) + ... + n <br/>
= sum(n/2) + n/2 + (n/2 + 1) + (n/2 + 2) + ... + n <br/>
= sum(n/2) + n/2 + (n/2 + 1) + (n/2 + 2) + ... + (n/2 + n/2) <br/>
= sum(n/2) + n/2 \* n/2 + sum(n/2) <br/>
= 2 \* sum(n/2) + n/2 \* n/2 (n은 짝수) <br/>
이와같이 공식을 도출하여 범위를 절반으로 나눠가며 분할정복알고리즘을 이용하여 해결하였다.