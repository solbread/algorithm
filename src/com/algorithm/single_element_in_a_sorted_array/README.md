## 540. Single Element in a Sorted Array

https://leetcode.com/problems/single-element-in-a-sorted-array/#/description

Given a sorted array consisting of only integers where every element appears twice except for one element which appears once.
Find this single element that appears only once.

`
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
`

**Note:** Your solution should run in O(log n) time and O(1) space.

**show tag:** \#binary_search

------------------------------------

**Solution**
문제의 조건인 시간복잡도 O(logn)과 공간복잡도 O(1)에 맞춰서 풀이함 <br/>
p와 q 두개의 지점을 두고 p=0, q=배열의끝지점 에서 시작함 <br/>
mid지점을 구해서 해당 지점에서 왼쪽구역으로 갈지 오른쪽구역으로 갈지를 정하며 이진탐색을 함 <br/>
구역을 정하는 방법은 정렬이 되어있으며 똑같은 숫자는 반드시 2개만 나온다는 점에서 생각해 볼 수 있음 <br/>
1) mid지점의 값과 양쪽의 값이 다르면 mid지점의 값이 답 <br/>
2) mid지점과 같은 값이 있다면 양쪽 구역의 남은 배열의원소 개수를 구해서 홀수인쪽으로 이동 (홀수라는 것은 2개가 아닌 값이 껴있다는 뜻이므로) <br/>
