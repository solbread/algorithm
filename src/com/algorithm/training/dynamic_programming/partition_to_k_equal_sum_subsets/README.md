## 698. Partition to K Equal Sum Subsets

**Difficulty:** Medium

https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/

Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

```
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
```

**Note:**

**Show tag:** \#dynamic\_programming \#recursion \#depth\_first\_search

------------------------------------

**Solution** <br/>
시간복잡도 : O(n^3) 공간복잡도 : O(n) <br/>
_시간복잡도 추출을 잘 모르겠다._
Depth First Search를 이용하여 구현하였다. <br/>
canPartitionSubsets(boolean[] isVisited, int startPoint, int targetSum, int k)는 이미 방문한 지점들은 isVisited 배열에 true로 되어있으며, startPoint에서 시작하여 k개의 targetSum을 가지는 subset을 만들 수 있는지를 반환한다. <br/>
이 재귀호출은 k가 0이될때까지 반복되는데 k가 0이면 모든 지점을 방문했는지를 반환한다. <br/>
우선 startPoint지점의 숫자가 targeSum일 경우에는 startPoint지점만으로 subset을 구성한 후 재귀호출한다.
그 후 해당 메소드는 startPoint에서 시작해서 startPoint보다 크면서 방문하지 않은 index들에 대해 targetSum을 만드는 subset을 구성할 수 있는지 확인한다. <br/>
크게 3가지의 경우로 나눌 수 있다. <br/>
startPoint+1지점부터 방문하지 않은 숫자들을 보는데,
1. nums[startPoint] + nums[i]이 targetSum일 경우 : 두 숫자로 이뤄진 subset을 구성한 후 재귀호출 한다.
2. nums[startPoint] + nums[i]이 targeSum보다 작을 경우 : 두 숫자 + 다른숫자로 이뤄진 subset으로 targetSum을 만들 수 있는지를 재귀호출로 확인한다.
3. nums[startPoint] + nums[i]이 targetSum보다 클 경우 : 두 숫자로는 targetSum의 subset을 만들 수 없으므로 skip한다.

이런 방식으로 구현하였는데, 코드가 깔끔하지 못하기때문에 리펙토링이 필요 할 것 같다.