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

**Solution : Using Two-Pass Algorithm** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
무제에서 원한 해결 방안은 아니지만, 가장 단순하고 간단한 방법이다. <br/>
n번의 루프를 이용하여 HashMap에 0, 1, 2의 count를 저장 한 후에, <br/>
n번의 루프를 이용하여 0부터 count만큼 nums배열에 넣어주는 방법이다. <br/>

**Best Solution : Using One-Pass Algorithm** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
각각의 index 변수에 해당 숫자가 등장가는 가장 마지막 index를 저장해두어, <br/>
0이 등장하면 모든 index를 1씩 늘리고 값을 셋팅해주며, <br/>
1이 등장하면 2와 1의 index를 1씩 늘리고 증가한 index에 값을 셋팅해주며, <br/>
2가 등장하면 2의 index를 1 늘리고 증가한 index에 값을 셋팅해준다. <br/>
해당 soluton은 nums 배열을 순회하며 nums 배열의 값에 따라 적당한 자리에 해당 값을 넣어주고, 해당 값이 들어감에 따라 다른 숫자들도 한 칸씩 이동해주면서 sort 하는 방식이다. <br/>
(0s을 [0,index0], 1s을 (index0,index1], 2s을 (index1, index2]에 저장해둔 다음에 들어오는 숫자에 따라서 해당 set의 마지막 index를 늘려주는 방식으로 숫자 set을 통채로 옮기는 방식이다.) <br/>

주의할 점은 0이나 1이 등장했을 때 index를 늘리고 증가한 index에 값을 셋팅해주는 것을 큰 수에서 작은 수 순서로 해야한다는 것이다. <br/>
이는 아직 숫자가 등장하지 않았을 경우때문이다. <br/>
예를 들면 0이 1번, 1이 0번, 2가 0번 등장했더라면 index0 = 0, index1 = 0, index2 = 0일 텐데, 여기서 또 0이 들어왔다면 index0 = 1, index1 = 1, index2 = 1이 된다. 그런데 0부터 값을 셋팅하면 최종적으로 num[1]에 들어가는 숫자는 2가 되어버리는데 이는 잘못된것이므로 큰수에서 작은수 순서대로 해야한다. <br/>

**Best Solution2 : Using One-Pass Algorithm** <br/>
시간복잡도 : O(n) 공간복잡도 : O(1) <br/>
lo는 숫자 0을 넣어줄  index이며 hi는 숫자2를 넣어줄 index를 의미한다. <br/>
즉 0s은 [0, lo), 1s은 [lo, index], 2s은 (hi, nums.length-1]이 된다. <br/>
index를 기준으로 [0, index] 까지는 0과 1로 color sort가 된 상태이기 때문에 1s의 범위는 lo부터 index까지가 된다. (ㅣlo > index 일 경우에는 아직 숫자1이 등장하지 않은 것이다.) <br/>
배열을 순회하면서,
1. nums[index]가 0일 경우
	* lo와 index의 숫자를 swap한다.
	* lo는 숫자 0이 들어갈 index이므로 lo는 아직 숫자 1이 등장하지 않았다면 index=lo 일 것이고, 숫자1이 등장하였다면 lo에는 1이 들어가 있을 것이다. 따라서 swap하더라도 [0, lo]까지는 sort된 배열을 유지한다.
2. nums[index]가 2일 경우
	* hi와 index의 숫자를 swap한다.
	* 숫자2는 배열의 맨 뒤에 위치해야 하기 때문에 뒤로 보낸다.
	* 이 경우에는 hi 위치에 있는 숫자가 index 위치로 오기 때문에 index를 증가시키지 않고 해당 자리에 있는 숫자를 한번더 본다.
3. nums[index]가 1일 경우
	* 그냥 index만 1 증가시킨다.

위와 같은 방법으로 color sort를 진행하고, while문의 반복조건문 지정에 주의해야 한다. <br/>
index를 기준으로 [0, index], (hi, nums.length-1]를 정렬된 상태로 유지하면서 sort를 하는 방식이기 때문에 index가 hi보다 커지지 않도록 해야한다.