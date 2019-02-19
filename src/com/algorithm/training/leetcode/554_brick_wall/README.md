## 554. Brick Wall

**Difficulty:** Medium

https://leetcode.com/problems/brick-wall/#/description

There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. <br/>
The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. <br/>
Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. <br/>
You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

**Note**
1. The width sum of bricks in different rows are the same and won't exceed INT_MAX.
2. The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.

**Show tag:** \#hash\_table

```
Input: 
[[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
 
Output: 2

(picture omit)
```

---------------------------------------------------

**Solution** <br/>
벽의 양 모서리를 제외하고 수직선을 그어서 가장 적게 벽돌을 교차하여 그려지는 선을 찾아 교차하는 벽돌의 개수를 반환하는 것이 목표이다. <br/>
가장 많은 벽돌을 교차해서 그어지는 선은 row의 개수만큼의 벽돌을 지나게 되기 때문에 leastBricks의 최대값은 row의 개수이며, 이를 초기값으로 사용하였다. <br/>
모든 벽돌의 모서리 지점을 구하여 HashMap에 <지점,개수>를 저장하였다. <br/>
선분을 그을 때 모서리인 벽돌의 개수가 많을 수록 교차하는 벽돌의 개수가 적어지며, 해당 지점이 모서리인 벽돌의 개수가 n이라면 선분이 교차하는 벽돌의 개수는 row개수-n 이 된다. <br/>
이를 이용하여 map에서 모서리가 가장 많은 지점을 얻어 가장 적게 벽돌을 교차하여 그려지는 선의 벽돌의 개수를 구할 수 있다.