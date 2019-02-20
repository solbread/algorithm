## 802. Find Eventual Safe States

**Difficulty:** Medium

https://leetcode.com/problems/find-eventual-safe-states/description/

In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  
If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.  

Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  
More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.  

Which nodes are eventually safe?  
Return them as an array in sorted order.  

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  
The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.  

```
Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Here is a diagram of the above graph.
```

(omit picture)

**Note:** <br/>
* graph will have length at most 10000.
* The number of edges in the graph will not exceed 32000.
* Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].

**Shot tag:** \#depth\_fisrt\_search \#graph

------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n)  
각 노드에서 출발해서 dfs를 이용하여 방문할 수 있는 경로를 모두 방문하며 순환이 있는지 판단한다  
처음에는 memorization을 사용하지 않고 구현을 해서 tle가 발생했는데,  
각 노드에서 출발했을때 순환이 있는지를 저장해놓는 방식으로 변경하여 시간복잡도를 O(n)으로 줄였고, tle도 해결하였다   

