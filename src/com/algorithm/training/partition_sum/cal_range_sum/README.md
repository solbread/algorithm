## Cal Range Sum

**Difficulty:** None

알고리즘 문제해결 전략 598p 예제

주어진 배열 numbers의 i번째 수부터 j번째 수의 구간합을 계산한다.

**Note:**

**Show tag:** \#partition\_#sum

----------------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
n크기의 배열에 0 ~ i번째 숫자의 합을 저장하는 부분합 배열을 만들어 놓은 후, <br/>
i~j까지의 구간합은 partitionSum[j] - partitionSum[i-1]로 O(1)만에 구한다. <br/>
이렇게 부분합을 이용하여 구간합을 구하는 것은 하나의 배열에 대해 여러번의 구간합을 구해야 할 때 유용하게 활용될 수 있다. 