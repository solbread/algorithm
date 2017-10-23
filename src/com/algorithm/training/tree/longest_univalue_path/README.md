## 687. Longest Univalue Path

**Difficulty:** Easy

https://leetcode.com/problems/longest-univalue-path/description/

Given a binary tree, find the length of the longest path where each node in the path has the same value. <br/>
This path may or may not pass through the root.

```
Input:
              5
             / \
            4   5
           / \   \
          1   1   5
Output: 2

Input:
              1
             / \
            4   5
           / \   \
          4   4   5
Output: 2
```

**Note:** The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

**Show tag:** \#tree \#recursion

-------------------------------------

**Solution** <br/>
시간복잡도 : O(n^2) 공간복잡도 : O(1) (n:노드의개수) <br/>
가장 긴 패스를 가지는 주어진 트리의 서브트리를 구한다고 하면 <br/>
서브트리의 루트에서는 왼쪽과 오른쪽 모두로 내려가도 되지만 그 아래의 자식노드부터는 둘중에 하나로만 내려가야 한다. <br/>
그래서 root에서 시작하는 최대경로를 구하는 longestUnivaluePath(TreeNode root)와 자식노드에서 내려가는 서브최대경로를 구하는 getLongestSubPath(TreeNode root)로 나눠서 호출한다. <br/>
longestUnivaluePath메소드에서는 아래의 세개의 값을 비교하여 max값으로 결과값을 사용한다. <br/>
1. root의값과 왼쪽자식값과 오른쪽자식값을 비교하여 같다면 각각 getLongestSubPath 메소드를 호출한 결과값을 누적
2. root의 왼쪽자식값을 루트로 하여 longestUnivaluePath 메소드를 재귀호출 한 결과값
3. root의 오른쪽자식값을 루트로 하여 longestUnivaluePath 메소드를 재귀호출 한 결과값

getLongestSubPath에서는  subRoot의 값과 왼쪽자식값을 비교하여 같다면 count를 해주고, getLongestSubPath를 한번더 재귀호출 해준다. <br/>
이를 오른쪽 자식에 대해서도 똑같이 해주어 두개의 값을 구해서 둘 중 max값이 최대 경로이므로 반환해주면 된다.