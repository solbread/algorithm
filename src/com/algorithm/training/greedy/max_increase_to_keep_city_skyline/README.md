## 807. Max Increase to Keep City Skyline

**Difficulty:** Medium

https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/

In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there.  
We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings).  
Height 0 is considered to be a building as well.  

At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid.  
A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.

What is the maximum total sum that the height of the buildings can be increased?  

```
Example:
Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
Output: 35
Explanation: 
The grid is:
[ [3, 0, 8, 4], 
  [2, 4, 5, 7],
  [9, 2, 6, 3],
  [0, 3, 1, 0] ]

The skyline viewed from top or bottom is: [9, 4, 8, 7]
The skyline viewed from left or right is: [8, 7, 9, 3]

The grid after increasing the height of buildings without affecting skylines is:

gridNew = [ [8, 4, 8, 7],
            [7, 4, 7, 7],
            [9, 4, 8, 7],
            [3, 3, 3, 3] ]

```

**Note**
* 1 < grid.length = grid\[0\].length <= 50.
* All heights grid\[i\]\[j\] are in the range \[0, 100\].
* All buildings in grid\[i\]\[j\] occupy the entire grid cell: that is, they are a 1 x 1 x grid\[i\]\[j\] rectangular prism.

**Show tag:** None

-----------------------------

**Solution** <br/>
시간복잡도 : O(n\*n) 공간복잡도 : O(n) n = 행 또는 열의 길이
행마다 가장 큰 높이의 빌딩을 저장하는 배열과, 열마다 가장 큰 높이의 빌딩을 저장하는 배열을 만들어서  
O(n\*n) 시간을 이용하여 해당 배열에 값을 채운다  
그 후 (i, j)의 빌딩의 높이는 i열에서 가장 큰 높이의 빌딩과 j열에서 가장 큰높이의 빌딩 중 작은 빌딩의 높이까지 늘어날 수 있으므로  
둘 중의 최소값에서 현재 빌딩의 높이를 빼 준 것만큼 늘려준다.  	