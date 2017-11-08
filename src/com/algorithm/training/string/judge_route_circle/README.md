## 657. Judge Route Circle

**Difficulty:** Easy

https://leetcode.com/problems/judge-route-circle/description/

Initially, there is a Robot at position (0, 0). <br/>
Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place. <br/>

The move sequence is represented by a string. <br/>
And each move is represent by a character. <br/>
The valid robot moves are R (Right), L (Left), U (Up) and D (down). <br/>
The output should be true or false representing whether the robot makes a circle.

```
Input: "UD"
Output: true

Input: "LL"
Output: false
```

**Show tag:** \#string

----------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(1) (n=문자열의길이) <br/>
input을 받아 주어진대로 이동하고 나서의 x좌표와 y좌표가 0,0이면 true를 아니면 false를 반환한다.

