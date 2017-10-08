## LIS (Longest Increasing Sequence)

**Difficulty:** Easy

https://algospot.com/judge/problem/read/LIS

어떤 정수 수열에서 0개 이상의 숫자를 지우면 이 수열의 부분 수열 (subsequence) 를 얻을 수 있다. <br/>
예를 들어 10 7 4 9 의 부분 수열에는 7 4 9, 10 4, 10 9 등이 있다. <br/>
단, 10 4 7 은 원래 수열의 순서와 다르므로 10 7 4 9 의 부분 수열이 아니다. <br/>

어떤 부분 수열이 순증가할 때 이 부분 수열을 증가 부분 수열 (increasing subsequence) 라고 한다. <br/>
주어진 수열의 증가 부분 수열 중 가장 긴 것의 길이를 계산하는 프로그램을 작성하라. <br/>

어떤 수열의 각 수가 이전의 수보다 클 때, 이 수열을 순증가 한다고 한다. <br/>

입력 <br/>
입력의 첫 줄에는 테스트 케이스의 수 C (<= 50) 가 주어진다. 각 테스트 케이스의 첫 줄에는 수열에 포함된 원소의 수 N (<= 500) 이 주어진다. 그 다음 줄에 수열이 N개의 정수가 주어진다. 각 정수는 1 이상 100,000 이하의 자연수이다.

출력 <br/>
각 테스트케이스마다 한 줄씩, 주어진 수열의 가장 긴 증가 부분 수열의 길이를 출력한다.	

```
Input:
3
4
1 2 3 4
8
5 4 3 2 1 6 7 8 
8
5 6 7 8 1 2 3 4

Output: 
4
4
4
```

**Note:**

**Show tag:** \#dynamic\_programming

------------------------------------

**Main** <br/>
시간복잡도 : O(n^2) 공간복잡도 : O(n^2)
가능한 순증가 부분 수열을 모두 구하면서 가장 긴 길이의 수열을 찾는 방식으로 구현하였다. <br/>
prevPoint와 currentPoint를 이용해서 prevPoint점의 숫자가 currentPoint지점의 숫자보다 작으면, <br/>
해당 currentPoint지점의 숫자를 부분수열에 포함시키는 것과 포함시키지 않는 경우 모두 재귀 호출한다. <br/>
만약 prevPoint점의 숫자가 currentPoint지점의 숫자보다 크거나 같다면 currentPoint지점의 숫자는 포함하지 않는 경우만 재귀호출을 하면 된다.

**Main2** <br/>
시간복잡도 : O(n^2) 공간복잡도 : O(n) <br/>
Algorithmic Problem Solving Strategies 책을 보고 Main 코드를 개선하였다. <br/>
내가 구현한 Main 코드는 prevPoint랑 currentPoint를 이용하였지만 사실은 prevPoint를 알 필요가 없다. <br/>
getMaxLength(int startPoint)를 startPoint에서 시작했을때 가장 긴 순증가 부분수열의 length라고 정의를 하면 된다. <br/>
함수 내부에서 for문으로 startPoint+1지점부터 숫자들을 순회하며 해당 숫자가 startPoint지점의 숫자보다 클 경우, 해당 함수를 재귀호출 하여 해당지점을 부분수열에 포함시켜본다. <br/>
해당 지점을 부분수열에 포함시키지 않을 수도 있는데, 이는 반복문을 통해서 해결이 된다. <br/>

**Main3** <br/>
시간복잡도 : O(n^2) 공간복잡도 : O(n) <br/>
Main2의 코드를 반복문을 이용한 dp 구현으로 변경한것이다. <br/>
dp[i] 배열의 의미는 i번째 원소를 마지막 원소로 가지는 순증가 부분수열의 최대길이 값이다. <br/>
처음에는 dp[dp.length-1]이 무조건 최대길이라고 생각했는데, <br/>
이렇게 해버리면 마지막원소가 무조건 최대길이인 순증가 부분 수열에 포함된다고 전제해버리는 것이었다. <br/>
그래서 dp[0]~dp[dp.length-1]까지 중에 max값을 리턴하는 것으로 수정하였더니 통과하였다.