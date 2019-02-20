## 797. All Paths From Source to Target

**Difficulty:** Medium

https://leetcode.com/problems/all-paths-from-source-to-target/description/

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order. <br/>

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

```
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
```

**Note:**  
* The number of nodes in the graph will be in the range [2, 15].
* You can print different paths in any order, but you should keep the order of nodes inside one path.

**Show tag:** \#dfs

-----------------------------------------

**Solution**  
시간복잡도 : O(n\*m) 공간복잡도 : O(1) <br/>
dfs를 이용하여 모든 경우를 다 따져보고 0번재 node에서 n-1번째 node까지 갈 수 있으면 모든 path를 저장하는 list에 해당 path를 추가해주는 방식으로 구현하였다. <br/>
