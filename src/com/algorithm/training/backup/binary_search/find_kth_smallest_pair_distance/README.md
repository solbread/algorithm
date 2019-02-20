## 719. Find K-th Smallest Pair Distance

**Difficulty:** Hard

https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/

Given an integer array, return the k-th smallest distance among all the pairs. <br/>
The distance of a pair (A, B) is defined as the absolute difference between A and B.

```
Input:
nums = [1,3,1]
k = 1
Output: 0 
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
```

**Note:**
1. 2 <= len(nums) <= 10000.
2. 0 <= nums[i] < 1000000.
3. 1 <= k <= len(nums) * (len(nums) - 1) / 2.


**Show tag:** \#bynary\_search \#array \#heap

-------------------------------------

**Solution : Unsolved Solution(Time Limit Exceed)** <br/>
시간복잡도 : O(n\*n) 공간복잡도 : O(n\*n) <br/>
key는 두 수의 차이로 하고 value는 해당 차이를 가지는 숫자쌍의 개수로 하는 map을 만들어서 n\*n의 반복문을 통해 모든 숫자쌍에 대해  차이를 계산하며 map에 count한다. <br/>
map을 만들면 map을 순회하며 k번째로 작은 차이가 몇인지를 판단한다.

**Best Solution** <br/>
시간복잡도 : O(nlogn) 공간복잡도 : O(1) <br/>
_정확한 시간복잡도는 잘 모르겠다. 아래 자료에 보면 nlogn이라고 한다. 그런데 내생각에는 countPairs에서 nlogn이고, smallestDistancePair에서 logn이니까 n\*logn\*log이 아닌가 싶다._ <br/>
참고자료 : https://discuss.leetcode.com/topic/108734/java-solution-binary-search/9 <br/>
이진탐색을 이용하여 Solutoin의 시간복잡도와 공간복잡도를 개선하였다. <br/>
숫자쌍의 k번째로 작은 차이를 구하기 위해서 이진 탐색을 이용하는데, left에는 가장 작은 차이를 right에는 가장 큰 차이를 셋해놓고 시작한다. <br/>
nums배열을 nlogn의 시간에 정렬하면 초기 left와 right값을 간단하게 구할 수 있다. <br/>
그 후 이진탐색을 이용하여 mid의 값보다 작은 차이를 갖는 숫자쌍의 개수를 얻어서 이 개수가 k보다 작으면, k번째 차이는 mid값보다 더 크다는 것이기 때문에 left를 mid+1로 옮겨준다. <br/>
반대로 k보다 크거나 같으면 k번째 차이는 mid값이거나 mid값보다 더 작을 수 있다는 것이기 때문에 right를 mid로 옮겨준다. <br/>
이를 반복하여 최종적으로 k번째 차이를 구할 수 있다. <br/>

이 때 mid값보다 작은 차이를 갖는 순서쌍의 개수는 countPairs메소드를 이용하여 구하는데, 이 역시 이진탐색을 이용하여 구한다. <br/>
countPairs(int[] nums, int k)를 nums배열에서 k이하의 차이를 가지는 숫자쌍의 개수로 정의한다. <br/>
nums배열은 정렬되어있으므로 k이하의 차이를 가지는 숫자쌍의 개수는 nums에서 nums[i]+k보다 큰 숫자가 등장하는 인덱스 - i - 1을 해주면 된다. <br/>
따라서 이진탐색을 이용하여 upperbound를 구한 후 이를 이욯애서 숫자쌍의 개수를 누적해주면 된다.