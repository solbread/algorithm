## 684. Redundant Connections

**Difficulty:** Medium

https://leetcode.com/problems/redundant-connection/description/

In this problem, a tree is an undirected graph that is connected and has no cycles. <br/>

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. <br/>
The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed. <br/>

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v. <br/>

Return an edge that can be removed so that the resulting graph is a tree of N nodes. <br/>
If there are multiple answers, return the answer that occurs last in the given 2D-array. <br/>
The answer edge [u, v] should be in the same format, with u < v.

```
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]

Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
```

**Show tag:** \#tree \#union_find \#graph

-------------------------------------

**Solution** <br/>
시간복잡도 : O(n), 공간복잡도 : O(n) <br/>
union find 참조 링크 : http://bowbowbow.tistory.com/26 <br/>
input을 순회하면서 union find를 이용해서 parent배열에 해당 index의 부모 노드 index를 저장해 둔 후 <br/>
find함수를 이용해서 추가하려는 간선의 두 점의 맨 위의 부모를 찾아 부모가 같으면 트리구조가 사라지므로 해당 간선을 제거하면 된다. <br/>

완벽하게 이해가 되지 않는 부분이 있는데, <br/>
parents 배열을 채워줄때 edge[1]의 최상위 부모에 edge[0]의 최상위 부모를 넣어준다는 것이다. <br/>
parent[edge[1]]에 edge[0]을 넣어주는게 아닌가 라고 생각했었다. <br/>
이 문제는 무방향이기도 하고 이렇게 하면 {{1,4},{3,4},{1,3},{1,2},{4,5}} 이런 경우에 답이 null로 나와버린다. <br/>
내가 생각하는 이유는 아래와 같다. <br/>
union-find를 이용해서 (u,v)일때 u가 부모 v가 자식으로 가정을 하고 이 문제를 해결하는데 <br/>
원래 트리는 하나의 노드에 대해 부모가 2개가 있으면 안되는데 이는 무방향 그래프이기 때문에 (1,4), (3,4) 같은 경우도 4가 부모이고 1,3이 자식인 트리로 트리구조가 성립된다. <br/>
따라서 이부분을 처리해주기 위해서 위의 로직이 존재하는 것 같다. <br/>
_(이부분에 대한 이해는 추후 더 필요할 것 같다.)_