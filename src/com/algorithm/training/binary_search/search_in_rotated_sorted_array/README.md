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