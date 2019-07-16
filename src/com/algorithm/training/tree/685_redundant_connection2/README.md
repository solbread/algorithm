## 685. Redundant Connection II

**Difficulty:** Hard

https://leetcode.com/problems/redundant-connection-ii/description/

In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents. <br/>

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. <br/>
The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. <br/>
Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. <br/>
If there are multiple answers, return the answer that occurs last in the given 2D-array.

```
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]

Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
```

**Show tag:** \#tree \#depth\_first\_search \#union\_find \#graph

-------------------------------------

**Solution** <br/>
시간복잡도 : O(n), 공간복잡도 : O(n) <br/>
참조한 곳 링크 <br/>
https://discuss.leetcode.com/topic/105100/most-posted-answers-are-wrong <br/>
https://discuss.leetcode.com/topic/105108/c-java-union-find-with-explanation-o-n/2 <br/>

이 그래프는 방향이 존재하는데 트리의 구조를 해치는 경우는 세가지 경우이다. <br/>
1. 하나의 노드에 대해 부모노드가 2개가 존재할 경우 : 뒤에 추가되는 간선을 제거
2. 루프가 발생할 경우 : 루프를 발생시키는 간선을 제거
3. 1번과 2번이 동시에 발생할 경우 : 부모노드가 2개인 노드에 대한 2개의 간선에 대해서 처음에 추가된 간선을 제거 (해당 간선이 1번과 2번에 동시에 해당되므로)

먼저 하나의 노드에 대해 부모노드가 2개가 존재하는 경우를 찾은 다음에 <br/>
루프가 있는지를 탐색한다. <br/>
그래서 위의 1번, 2번, 3번의 경우에 따라 처리해주면 된다. <br/>

주의할점은 부모노드가 2개가 존재하는 노드가 있을 경우 루프를 탐색할 때, <br/>
뒤에 추가되는 간선에 대해서 부모노드를 제외하고 판단한다. <br/>
해당 간선의 경우에는 애초에 루프를 발생시킬수는 없기 때문이다.