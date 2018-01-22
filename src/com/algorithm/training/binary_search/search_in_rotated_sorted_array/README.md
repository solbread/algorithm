## 33. Search in Rotated Sorted Array

**Difficulty:** Medium

https://leetcode.com/problems/single-element-in-a-sorted-array/#/description

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. <br/>

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). <br/>

You are given a target value to search. <br/>
If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array. <br/>

```
Input: [4,5,6,7,0,1,2], 2
Output: 6
```

**Note:** Your solution should run in O(log n) time and O(1) space.

**Show tag:** \#binary_search \#array

------------------------------------

**Solution** <br/>
시간복잡도 : O(logn) 공간복잡도 : O(1) <br/>
이진탐색을 2번 진행하므로 시간복잡도는 logn이다. <br/>
1. 이진탐색을 이용하여 가장 적은 값의 index를 찾는다.
	* mid 값을 기준으로 가장 적은 값이 왼쪽에 있다면 mid부터 hi까지의 숫자들은 오름차순으로 정렬이 되어있기 때문에 nums[hi] > nums[mid]
	* mid 값을 기준으로 가장 적은 값이 오른쪽에 있다면 nums[hi] < nums[mid]
2. 가장 적은 값의 index를 찾았으면 우리가 찾고자하는 target이 해당 index를 기준으로 오른쪽 배열에 있는지 왼쪽 배열에 있는지를 찾아서 두번째 이진탐색의 lo와 hi값을 설정해준다.
	* 이 시점에서 lo랑 hi에는 nums 배열에서 가장 적은 값의 index가 저장되어 있음
	* target이 오른쪽에 있다면 [index, nums.length-1]까지의 범위를 이진탐색
	* target이 왼쪽에 있다면 [0, index]까지의 범위를 이진탐색
3. 2번에서 설정한 lo랑 hi범위에서 target과 같은 숫자를 찾는다.

**Solution** <br/>
시간복잡도 : O(logn) 공간복잡도 : O(1) <br/>
Solution1과 동일한데 Solution1의 2번 과정 이후가 조금 다르다. <br/>
이진 탐색을 이용하가여 가장 적은 값의 index를 구한 후(smallestIdx) target이 이 index를 기준으로 왼쪽에 있는지 오른쪽에 있는지를 판단하지 않고, <br/>
nums배열을 lo = 0, hi = nums.length-1의 범위로 하여 이진탐색을 통해 target을 찾아준다. <br/>
찾을 때 index에 (index+smallestIdx)%nums.length 연산을 해주어 마치 해당 배열을 smallestIdx가 0 index인 배열처럼 이용하여 이진탐색을 통해 target을 찾는 것이다.

**Best Solution** <br/>
시간복잡도 : O(logn) 공간복잡도 : O(1) <br/>

-------------------------------------------------
참고자료 : https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/ <br/>
Explanation
Let's say nums looks like this: [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] <br/>

Because it's not fully sorted, we can't do normal binary search. But here comes the trick: <br/>
* If target is let's say 14, then we adjust nums to this, where "inf" means infinity:
[12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]
* If target is let's say 7, then we adjust nums to this:
[-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

And then we can simply do ordinary binary search. <br/>

Of course we don't actually adjust the whole array but instead adjust only on the fly only the elements we look at. And the adjustment is done by comparing both the target and the actual element against nums[0]. <br/>

-------------------------------------------------------

target이 속해있는 범위가 정확하게 정해지면 그 나머지는 어차피 볼 필요가 없기 때문에 INF 혹은 -INF로 처리하는 방식이다. <br/>
1. nums\[lo\] > nums\[mid\] && nums\[lo\] <= target
	* 이 경우에는 [lo, mid]에 가장 적은 값이 속해있으며 [lo, smallestIdx]에 target이 들어있으므로 nums[mid]를 INF로 처리하여 mid를 기준으로 왼쪽에 target이 있음을 표시한다.
2. nums\[lo\] <= nums\[mid\] && nums\[lo\] > target
	* 이 경우에는 (mid, hi]에 가장 적은 값이 속해있으며 [smallestIdx, hi]에 target이 들어있으므로 nums[mid]를 -INF로 처리하여 mid를 기준으로 오른쪽에 target이 있음을 표시한다.

1번과 2번의 조건에 의해 target의 위치가 확실하게 정해지는 경우에는 nums[mid] 값을 INF 혹은 -INF로 처리한 후, <br/>
일반적인 이진탐색을 하여 target을 찾는다.

**Best Solution2** <br/>
시간복잡도 O(logn) 공간복잡도 O(1) <br/>
참고자료 : https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/ <br/>

한번의 이진탐색을 통해 taret을 찾아내는 솔루션이다. <br/>
1. [lo, mid]가 오름차순으로 정렬되어 있다면 (smallestIdx가 (mid, hi]에 있다면)
	1. [lo, mid] 사이에 target이 있으면 hi = mid
	2. [lo, mid] 사이에 target이 없다면 lo = mid+1
2. [lo, mid]가 오름차순으로 정렬되어 있지 않다면 (smallestIdx가 [lo, mid]에 있다면, 즉 [mid, hi]가 오름차순으로 정렬 되어 있다면)
	1. (mid, hi] 사이에 target이 있다면 lo = mid+1
	2. (mid, hi] 사이에 target이 없다면 hi = mid
	
위와 같은 방법으로 lo와 hi를 바꿔주면서 원하는 target을 찾는다.

**Best Solution3** <br/>
시간복잡도 O(logn) 공간복잡도 O(1) <br/>
BestSolution2랑 모든부분이 동일하며 2-1의 target이 (mid, hi]사이에 있는지 판단해주는 부분의 조건문만 다르다. <br/>
기존에는 nums[mid] < target이면서 nums[hi] >= target으로 조건을 사용했는데, <br/>
nums[mid] < target이면서 nums[lo] > target으로 조건을 변경하였다. <br/>
의미는 둘다 동일하나 이렇게 바꾼 이유는 아래의 Best Solution4처럼 더 간결한 코드로 나타내기 위해서이다. <br/>

**Best Solution4** <br/>
시간복잡도 O(logn) 공간복잡도 O(1) <br/>
Best Solution3을 exclusive-or 연산자를 이용하여 하나의 조건문을 이용하여 lo랑 hi를 조정하도록 수정한 솔루션이다. <br/>

* hi = mid가 되는 경우
	1. nums[lo] <= target <= nums[mid] <br/>
	2.             target <= nums[mid] < nums[lo] <br/>
	3.                       nums[mid] < nums[lo] <= target <br/>
	
(nums[lo] <= target), (target <= nums[mid]), (nums[mid] < nums[lo]) 세가지의 조건 중 두개가 true일 경우 hi=mid가 된다. <br/>

_여기서부터 잘 모르겠다_ <br/>
위의 내용을 exclusive or을 이용하여 표현하면 아래와 같이 된다. (2가지 모두 같은 표현이다. 코드에는 위에껄로 사용)
* nums\[lo\] <= nums\[mid\] ^ nums\[lo\] <= target ^ nums\[mid\] >= target
* nums\[lo\] > target ^ nums\[lo\] > nums\[mid\] ^ target > nums\[mid\]
