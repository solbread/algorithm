## 542. 01 Matrix

https://leetcode.com/problems/01-matrix/

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell. <br/>
The distance between two adjacent cells is 1.

```
input <br/>
0 0 0 <br/>
0 1 0 <br/>
0 0 0 <br/>
output <br/>
0 0 0 <br/>
0 1 0 <br/>
0 0 0 <br/>
```

**Note** <br/>
1. The number of elements of the given matrix will not exceed 10,000. <br/>
2. There are at least one 0 in the given matrix. <br/>
3. The cells are adjacent in only four directions: up, down, left and right. <br/>

**Shot tag:** \#depth\_fisrt\_search \#breadth\_first\_search

----------------------

**Best Solution** <br/>
0과 1로 이루어진 행렬이므로 0인 cell은 답도 0임 <br/>
처음에 for문으로 행렬을 돌면서 1인 cell만 Integer.MAX_VALUE로 바꿔서 어떤 수랑 비교해도 크도록 함 <br/>
또한 값이 0인 cell의 좌표(i,j)를 큐에 넣어둬서 후에 이 좌표들을 기준으로 탐색하도록 해줌 <br/>
행렬을 다 돈 후에는 queue에서 하나씩 꺼내면서 해당 좌표의 위,아래,좌,우를 보고 해당 좌표의 value와 위,아래,좌,우의 값에서 1더한 값중 최소값으로 셋해주면서 이동하면 됨. -> MIN(matrix[i-1][j]+1, matrix[i+1][j]+1, matrix[i][j-1]+1, matrix[i][j+1]+1, matrix[i][j]) <br/>
만약에 새로운 최소값으로 셋 하면 다시 큐에 넣어주면서 큐가 빌때까지 반복 