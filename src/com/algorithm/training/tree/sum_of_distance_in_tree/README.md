## 834. Sum of Distances in Tree

**Difficulty:** Hard

https://leetcode.com/problems/sum-of-distances-in-tree/description/

An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.  

The ith edge connects nodes edges\[i\]\[0\] and edges\[i\]\[1\] together.  

Return a list ans, where ans\[i\] is the sum of the distances between node i and all other nodes.

```
Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: 
Here is a diagram of the given tree:
  0
 / \
1   2
   /|\
  3 4 5
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
```

**Show tag:** \#tree \#depth\_first\_search

-------------------------------------

**Best Solution** <br/>
시간복잡도 : O(n), 공간복잡도 : O(n)  
참고자료  
* https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C++JavaPython-Pre-order-and-Post-order-DFS-O(N)
* https://leetcode.com/problems/sum-of-distances-in-tree/discuss/132133/Intuition-of-O(n)-solution-based-on-%22undirected%22-tree
풀이  
1. countSubNodes(int root, boolean[] visit)
   * root의 자기자신 노드를 포함한 자식노드 개수를 구하며, root노드에서 자식노드로의 총 distance를 구하는 메소드
   * count\[root\] = SUM(count\[i\]) + 1
   * sum\[root\] = SUM(sum\[i\] + count\[i\])
   * 이 메소드를 이용하여 countOfSubNodes 배열을 채우며 0번재 node에서 자식노드로의 distance를 구함
2. sumDistance(int root, boolean[] visit)
   * root에서 각 node들까지의 distance들의 합을 구하는 메소드
   * sum\[i\] = sum\[root\] - count\[i\] + N - count\[i\]
     * i 노드에서 전체 nodes까지의 distance들의 합은 : root노드에서 전체 nodes들에 대한 distance의 합과 같은 sum\[root\]에서 i노드를 포함한 i노드의 자식노드 개수만큼 1씩 거리가 줄어들며, 나머지 노드 개수만큼 1씩 거리가 증가 (i노드의 자식노드의 개수는 count\[i\]이며, 나머지 노드의 개수는 N - count\[i\])
   * 이 메소드를 이용하여 sumOfDistance 배열을 채우며 이것은 결과값이 됨 
