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

**Best Solution : Using DFS** <br/>
시간복잡도 : O(n\*m) 공간복잡도 : O(n\*m) (n=matrix행의수 m=matrix열의수) <br/>
참고 자료 : https://discuss.leetcode.com/topic/62379/java-bfs-dfs-from-ocean <br/>

n\*m 배열의 두개에 각각 pacific을 갈 수 있는지 여부와 atlantic을 갈 수 있는지의 여부를 저장한 후, 
pacific도 갈 수 있고 atlantic도 갈 수 있는 점들을 반환하면 된다. <br/>

n을 matrix의 행의수, m을 matrix 열의수라고 정의하면 <br/>
matrix\[\]\[0\]과 matrix\[0\]\[]\은 pacific이며 <br/>
matrix\[\]\[m-1\]과 matrix\[n-1\]\[\]은 atlantic이다. <br/>
위의 점들에서 출발하여 해당 점에서 위/아래/좌/우로 이동하는데 해당 지점보다 물결이 더 높을 경우만 이동하여 이동가능하다면, <br/>
이동하여 또 이동한 지점에서 탐색하고 탐색하는 방식으로 더이상 탐색할 수 없을 때까지 깊이우선탐색을 진행한다. <br/>
이런 방식으로 태평양에 갈 수 있는 지점들을 표시하는 pacific배열과 대서양에 갈 수 있는 지점들을 표시하는 atlantic배열을 완성하여 최종적인 답을 구한다. 

**Best Solution2 : Using BFS** <br/>
시간복잡도 : O(n\*m) 공간복잡도 : O(n\*m) (n=matrix행의수 m=matrix열의수) <br/>
참고 자료 : https://discuss.leetcode.com/topic/62379/java-bfs-dfs-from-ocean <br/>

위의 Best Solution과 동일한 아이디어인데 DFS를 BFS로 옮긴것이다. <br/>
BFS를 구현하기 위하여 Queue를 사용하여 <br/>
matrix\[\]\[0\]과 matrix\[0\]\[]\은 pacificQueue에 넣고, <br/>
matrix\[\]\[m-1\]과 matrix\[n-1\]\[\]은 atlanticQueue에 넣은 상태에서 시작한다. <br/>
큐에서 하나의 지점을 꺼내서 위/아래/좌/우 중에 움직일 수 있는 지점이 있다면 해당 지점을 pacific/atlantic 배열에 표시하고 큐에 넣는 방식으로 넓이우선탐색을 진행한다.

