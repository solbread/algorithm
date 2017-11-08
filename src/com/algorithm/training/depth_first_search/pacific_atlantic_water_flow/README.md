## 417. Pacific Atlantic Water Flow

**Difficulty:** Medium

https://leetcode.com/problems/pacific-atlantic-water-flow/description/

Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges. <br/>

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower. <br/>

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean. <br/>

```
Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
```

**Note:** <br/>
* The order of returned grid coordinates does not matter.
* Both m and n are less than 150.

**Shot tag:** \#depth\_fisrt\_search \#breadth\_first\_search

------------------------------------

**Solution** <br/>
시간복잡도 : ? 공간복잡도 : O(n*m) <br/>
_시간복잡도를 모르겠다_ <br/>
canFlow(int i, int j)를 (i,j)에서 시작하였을 때 흘러갈 수 있는 바다를 반환하는 메소드로 정의한다. <br/>
반환값은 1, 2, 3이 될 수 있는데 1이면 태평양으로 2면 대서양으로 3이면 둘다로 흘러갈 수 있는것으로 정의한다. (비트마스크 01, 10, 11을 이용) <br/>
canFlow()는 최대 4방향으로 움직 일 수 있으므로 각각의 방향마다 matrix를 벗어나지 않고, 아직 방문하지 않았고, 물의 높이가 같거나 작은지를 판단하여 이동할 수 있다면 재귀호출을 한다. <br/>
이런 방식으로 dfs를 이용하여 모든 경우의수를 다 따져보아서 태평양과 대서양 모두로 흘러갈 수 있는지를 확인한다. <br/>
path가 3이되면 태평양과 대서양 모두로 흘러갈 수 있다는 것이기 때문에 더이상 호출을 중단하고 리턴해주어 불필요한 호출을 막는다.
