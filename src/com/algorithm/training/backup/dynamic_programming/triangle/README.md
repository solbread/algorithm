## 120. Triangle

**Difficulty:** Medium

https://leetcode.com/problems/triangle/description/

Given a triangle, find the minimum path sum from top to bottom. <br/>
Each step you may move to adjacent numbers on the row below.
```
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
```

**Note:** <br/>
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

**Shot tag:** \#dynamic\_programming \#array

**Related Problem:** dynamic\_programming.trianglepath

------------------------------------

**Solution** <br/>
시간복잡도 : O(n^2) 공간복잡도 : O(n) <br/>
_dynamic\_programming.trianglepath랑 최대경로합/최소경로합을 구한다는 차이를 제외하고는 동일하다. trianglepath문제를 먼저 풀었어서 trianglepath설명이 더 자세하다_

아래에서부터 시작하여 위로 올라가면서 최소경로를 구해준다. <br/>
dp\[i\]\[j\] = max(dp\[i+1\]\[j\], dp\[i+1\]\[j+1\]) + triangle\[i\]\[j\]로 점화식을 정의할 수 있다. <br/>
dp\[i\]\[\]의 값은 dp\[i+1\]\[\]에만 영향을 받으므로, <br/>
슬라이딩 윈도 기법을 이용하여 2*n 배열을 선언하여, 행을 번갈아가면서 사용한다. <br/>
