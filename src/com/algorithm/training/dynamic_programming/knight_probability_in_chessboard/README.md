## 688. Knight Probability in Chessboard

**Difficulty:** Medium

https://leetcode.com/problems/knight-probability-in-chessboard/description/

On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. <br/>
The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1). <br/>

A chess knight has 8 possible moves it can make, as illustrated below. <br/>
Each move is two squares in a cardinal direction, then one square in an orthogonal direction. <br/>
 
(그림생략) <br/>

Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there. <br/>

The knight continues moving until it has made exactly K moves or has moved off the chessboard. <br/>
Return the probability that the knight remains on the board after it has stopped moving.

```
Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
```

**Note:**

**Show tag:** \#dynamic\_programming

------------------------------------

**Solution : Unsolved Solution** <br/>
시간복잡도 : O(k\*n\*n) <br/>
재귀호출을 이용해서 해결해보려고 했는데 확률을 구하는 부분에서 실패하였다. <br/>
메모리제이션을 적용하기도 전에 포기한 솔루션 <br/>

**Best Solution** <br/>
시간복잡도 : O(k\*\*n) 공간복잡도 : O(n) <br/>
dp\[i\]\[j\]를 (i,j)에서 출발해서 체스판에 도달할 수 있는 경우의 수로 정의하여 <br/>
n^2 반복하여 dp\[i\]\[j\]를 채워나가는 것을 k번 반복한다. <br/>
k번째 dp\[i\]\[j\]에는 k-1번째까지 채워나갔던 dp\[i+xDistance\]\[j+yDistance\]의 값들을 다 더해주면 된다. <br/>

주의할 점은 dp배열은 int형으로 하면 범위가 초과하기 떄문에 double형으로 지정해주어야 한다는 것이다. <br/>
_(이부분의 이해가 부족하다.)_