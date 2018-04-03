## 169. Majority Element

**Difficulty:** Easy

https://leetcode.com/problems/majority-element/description/

Given an array of size n, find the majority element. <br/>
The majority element is the element that appears more than ⌊ n/2 ⌋   times. <br/>

You may assume that the array is non-empty and the majority element always exist in the array.

```
Input: [1,2,2]
Outout: 2
```

**Note:**

**Show tag:** \#array \#divide\_and\_conquer \#bit\_manipulation

-------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
가장 단순하게 num이 몇번나왔는지를 세는 map을 두고, <br/>
숫자들의 등장횟수를 세다가 n/2초과하여 등장하는 숫자가 나오면 return하였다. <br/>

**Best Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(1) <br/>
n/2초과하여 등장하는 major가 반드시 존재한다고 문제에서 보장했다는 사실을 이용한 풀이이다. <br/>
major를 우선 nums[0]이라고 가정하여 초기값을 nums[0]으로 두고 major의 개수를 세는 count변수에 1을 초기화한다. <br/>
major는 n/2를 초과하여 등장해야하므로 nums[0]이 major라면 nums[1] 혹은 nums[2] 중에는 반드시 nums[0]과 같은 값이 있어야 한다. <br/>
따라서 count를 세는데 현재 major값과 nums[i]가 같으면 count++, 다르면 count--를 해주면서, <br/>
count가 0이되면 major값을 변경해주면서 n번반복하였을때 major에 저장된 값이 결과값이다. <br/>

