## NUMBERGAME

**Difficulty:** Easy

https://algospot.com/judge/problem/read/NUMBERGAME

n개의 정수를 일렬로 늘어놓은 게임판을 가지고 현우와 서하가 게임을 합니다. <br/>
게임은 현우부터 시작해서 번갈아가며 진행하며, 각 참가자는 자기 차례마다 두 가지 일 중 하나를 할 수 있습니다. <br/>

* 게임판의 왼쪽 끝에 있는 숫자나 오른쪽 끝에 있는 숫자 중 하나를 택해 가져갑니다. 가져간 숫자는 게임판에서 지워집니다. 
* 게임판에 두 개 이상의 숫자가 있을 경우, 왼쪽 끝에서 2개, 혹은 오른쪽 끝에서 2개를 지웁니다. 

게임은 모든 숫자가 다 없어졌을 때 끝나며, 각 사람의 점수는 자신이 가져간 숫자들의 합입니다. <br/>
현우와 서하는 점수가 더 낮은 쪽이 점수 높은 쪽에 한 점 차이마다 백 원씩 주기로 내기를 했습니다. <br/>
두 사람 모두 최선을 다할 때, 두 사람의 최종 점수 차이는 얼마일까요?

입력 <br/>
입력의 첫 줄에는 테스트 케이스의 수 C (C <= 50) 이 주어집니다. 각 테스트 케이스의 첫 줄에는 게임판의 길이 n (1 <= n <= 50) 이 주어지며, 그 다음 줄에 n 개의 정수로 게임판의 숫자들이 순서대로 주어집니다. 각 숫자는 -1,000 에서 1,000 사이의 정수입니다.

출력 <br/>
각 테스트 케이스마다 한 줄로, 두 사람이 최선을 다했을 때 현우가 서하보다 몇 점 더 얻을 수 있는지를 출력합니다.

```
Input:
3 
5 
-1000 -1000 -3 -1000 -1000 
6 
100 -1000 -1000 100 -1000 -1000 
10 
7 -5 8 5 1 -4 -8 6 7 9 

Output: 
-1000
1100
7
```

**Note:**

**Show tag:** \#dynamic\_programming \#minimax\_algorithm

------------------------------------

**Solution** <br/>
시간복잡도 : O(n\*n) 공간복잡도 : O(n\*n) <br/>
게임의 상태는 보드판에서 남은 숫자들 중 가장 왼쪽 숫자와 가장 오른쪽 숫자의 위치를 사용한다. <br/>
getScoreDiff(int left, int right)는 현재 게임판에 남은 수들이 left~right일 때 (이번 차례인 참가자의 점수) - (다른 참가자의 점수)의 최대치를 반환한다. <br/>
각 턴마다 플레이어가 할 수 있는 동작은 최대 아래의 4가지이므로 모든 경우의수를 호출하여 점수차의 최대값을 구한다.
1. 맨 왼쪽의 수 하나를 가지고 지운다.
2. 맨 오른쪽의 수 하나를 가지고 지운다.
3. (보드에 남은 수가 2개 이상일 경우) 왼쪽의 수 2개를 지운다.
4. (보드에 남은 수가 2개 이상일 경우) 오른쪽의 수 2개를 지운다.

**미니맥스 알고리즘**
이 알고리즘은 인공지능 과목에서 배우는 미니맥스 알고리즘(minimax algorithm)과 본질적으로 동일하다. <br/>
재귀 함수의 정의를 다음과 같이 바꿔본다. <br/>
play(state, player) = 현재 게임판에 남은 수들이 state라고 가정하고, 이번 차례가 player라고 할 때 (현우점수-서하점수) <br/>
그러면 현우는 play()의 반환값을 가능한 최대화하고, 서하는 최소화 하는 쪽으로 게임을 한다. <br/>
게임 트리의 각 층마다 번갈아가면서 최대화/최소화 한다는 의미에서 이 알고리즘을 미니맥스라고 부른다. <br/>
이 경우 player에 따라 반환 값이 달라지고, state만 가지고는 이번 차례가 누군지 알아낼 수 없기 때문에 부분 문제의 수가 두 배 늘어난다.