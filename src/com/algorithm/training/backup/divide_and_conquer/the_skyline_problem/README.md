## 218. The Skyline Problem

**Difficulty:** Hard

https://leetcode.com/problems/the-skyline-problem/#/description

**Show tag:** \#binary_indexed_tree \#segment_tree \#heap \#divide_and_conquer

------------------------------------

**Solution** <br/>
빌딩의 높이를 기준으로 정렬하는 힙1, 빌딩의 끝나는 x좌표지점을 기준으로 정렬하는 힙2를 사용 <br/>
currentX에 현재 기준 x좌표값이 들어가며, 가장 먼저 있는 빌딩의 x좌표값에서 시작 <br/>
다음 currentX는 남아있는 빌딩중에 가장 먼저 시작하는 지점과 힙2에서 가장 앞에있는(가장 먼저 끝나는 빌딩)지점 중에 작은 값을 다음 currentX값으로 함 <br/>
currentX값에 따라 힙1과 힙2에 빌딩을 넣고 빼면서 높이가 변할때마다 리스트에 넣어줌 
