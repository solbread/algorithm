## 11. Container With Most Water

**Difficulty:** Medium

https://leetcode.com/problems/container-with-most-water/#/description

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). <br/>
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

**Note:** You may not slant the container and n is at least 2.

**show tag:** \#array \#two_pointers

-------------------------------

**Best Solution**
두개의 포인터 p와 q를 사용 <br/>
p는 0에서 q는 배열의 마지막에서 시작 <br/>
한칸씩 포인터를 옮겨가면서 maxArea를 찾는데, p랑 q중에 작은 값을 옮기면 됨

작은값을 옮기는 이유는?
p는 0에서 q는 배열의마지막에서 시작하므로 점점 x의 범위를 좁혀 나가는 것임 <br/>
따라서 더 작은값은 큰값에 포함이 되므로 작은값은 옮겨도 되는 것임
