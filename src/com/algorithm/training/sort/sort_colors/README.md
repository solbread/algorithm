## 75. Sort Colors

**Difficulty:** Medium

https://leetcode.com/problems/sort-colors/description/

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue. <br/>

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively. <br/>

```
Input : [0, 2, 1, 1]
Output : [ 0, 1, 1, 2]
```

**Note:** You are not suppose to use the library's sort function for this problem.

**Show tag:** \#sort \#array \#two\_pointers

**Follow up:** <br/>
A rather straight forward solution is a two-pass algorithm using counting sort. <br/>
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's. <br/>
Could you come up with an one-pass algorithm using only constant space?

-----------------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
무제에서 원한 해결 방안은 아니지만, 가장 단순하고 간단한 방법이다. <br/>
n번의 루프를 이용하여 HashMap에 0, 1, 2의 count를 저장 한 후에, <br/>
n번의 루프를 이용하여 0부터 count만큼 nums배열에 넣어주는 방법이다. <br/>

**Best Solution : Using Two-Pass algorithm** <br/>
시간복잡도 : O(n) 공간복잡도 : O(1) <br/>