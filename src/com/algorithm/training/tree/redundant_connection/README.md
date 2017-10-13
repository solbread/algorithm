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
parent[edge[1]]에 edge[0]을 넣어주는게 아닌가 라고 생각했는데, <br/>
이 문제는 무방향이기도 하고 이렇게 하면 {{1,4},{3,4},{1,3},{1,2},{4,5}} 이런 경우에 답이 null로 나와버린다. <br/>
_(이부분에 대한 이해는 추후 더 필요할 것 같다.)_