## 283. Move Zeroes

**Difficulty:** Easy

https://leetcode.com/problems/move-zeroes/description/

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements. <br/>

```
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
```

**Note**  
1. You must do this in-place without making a copy of the array.
2. Minimize the total number of operations.

**Show tag:** \#array \#two\_pointers

----------------------------------------

**Solution**  
시간복잡도 : O(n) 공간복잡도 : O(1)  
left와 right라는 두개의 pointer를 가지고 구현을 하였다.  
0인것을 뒤로 보내고, 0이 아닌 배열의 요소들의 순서는 유지되어야 하므로,  
left가 0인것을 찾고 right가 left보다 큰 index중에 0이 아닌 가장 작은 index를 찾아서 두 index의 element를 교환해주는 방식으로 구현하였다.  
우선 left는 nums\[left\]가 0인 index가 될 때까지 오른쪽으로 진행한다.  
left가 오른쪽으로 진행하다가 nums\[left\]가 0인 index가 되면 right가 오른쪽으로 진행하며 nums\[right\]가 0이 아닌 index를 찾아서 nums\[left\]와 nums\[right\]를 교환해준다.  
이 때 right는 left 혹은 left+1부터 시작해야 하며, 이를 처리해주는 부분이 나의 코드에서는 ```right = ++left;``` 와 같다.  
위처럼 nums\[left\]가 0이 아닐때 right도 같이 이동시켜주어서 nums\[left\]가 0일 떄, right가 자연스럽게 left부터 시작하게 해 준다.  
위의 코드는 left 혹은 right가 배열의 끝에 도달할때 까지 반복되며 매 반복마다 left혹은 right의 값이 증가하게 되므로 최대 2\*n만큼 반복하게 된다.