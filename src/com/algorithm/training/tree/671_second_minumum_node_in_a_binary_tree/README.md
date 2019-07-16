## 671. Second Minimum Node In a Binary Tree

**Difficulty:** Easy

https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/	

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. <br/>
If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. <br/><br/>

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree. <br/><br/>

If no such second minimum value exists, output -1 instead. <br/><br/>

```
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.

Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
```

**Show tag:** \#tree

-------------------------------------

**Solution** <br/>
시간복잡도 : O(n), 공간복잡도 : O(1) <br/>
자식노드의 value는 부모노드의 value보다 작거나 같으므로, <br/>
루트노드의 value를 가지고있다가 깊이우선탐색으로 루트노드의 value랑 다른 가장 작은 값을 찾아준다. <br/>
루트노드에서 출발해서 양쪽의 자식노드들을 탐색하면서 부모노드의 value와 같으면 탐색을 계속하고, <br/>
부모노드의 value와 다를경우 탐색을 멈춘 후 <br/>
왼쪽자식노드와 오른쪽자식노드 중에 더 작은 value를 반환하면 된다. <br/><br/>

처음에는 자식노드의 value가 부모노드의 value랑 같으면 탐색을 계속해야한다는 부분을 인지하지 못해서 잘못 접근 했었다.