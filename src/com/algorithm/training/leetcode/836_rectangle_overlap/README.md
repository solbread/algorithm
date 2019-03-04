## 836. Rectangle Overlap

**Difficulty:** Easy

https://leetcode.com/problems/rectangle-overlap/description/

A rectangle is represented as a list `[x1, y1, x2, y2]`, where `(x1, y1)` are the coordinates of its bottom-left corner, and `(x2, y2)` are the coordinates of its top-right corner.

Two rectangles overlap if the area of their intersection is positive.  
To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two (axis-aligned) rectangles, return whether they overlap.



**Note** <br/>

1. Both rectangles `rec1` and `rec2` are lists of 4 integers.
2. All coordinates in rectangles will be between `-10^9 `and` 10^9`.

**Show tag:** \#math

```
Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
```

-------------------------------------------

**Solution** <br/>
좌표를 이용하여 겹치는지를 판단하는 솔루션이다  
rec1과 rec2가 겹치지 않는 방법은 총 4가지 이다.  
1. rec1의 오른쪽 모서리보다 rec2의 왼쪽 모서리가 크거나 같은 경우 : rec1\[2\] <= rec2\[0\]
2. rec1의 왼족 모서리보다 rec2의 오른쪽 모서리가 작거나 같은 경우 : rec1\[0\] >= rec2\[2\]
3. rec1의 아래쪽 모서리보다 rec2의 위쪽 모서리가 작거나 같은 경우 : rec1\[1\] >= rec2\[3\]
4. rec1의 위쪽 모서리보다 rec2의 아래쪽 모서리가 크거나 같은 경우 : rec1\[3\] <= rec2\[1\]
위의 4가지경우에 모두 해당이 되지 않으면 두 사각형은 겹친다.



**Solution2**  
넓이를 이용하여 겹치는지를 판단하는 솔루션이다.  
두개의 사각형의 겹치는 부분의 넓이를 구하여서 이것이 0보다 크면 두 사각형이 겹치는것으로 판단하는 방식이다.  
두개의 사각형의 겹치는 부분의
1. 가로 : Math.max(rec1\[0\], rec2\[0\]) - Math.min(rec1\[2\], rec2\[2\])
2. 세로 : Math.max(rec1\[1\], rec2\[1\]) - Math.min(rec1\[3\], rec2\[3\])
위의 방식으로 구한 가로와 세로가 0보다 큰지를 판단하면 된다.
