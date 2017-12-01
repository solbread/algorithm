## 735. Asteroid Collision

**Difficulty:** Medium

https://leetcode.com/problems/asteroid-collision/description/

We are given an array asteroids of integers representing asteroids in a row. <br/>

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). <br/>
Each asteroid moves at the same speed. <br/>

Find out the state of the asteroids after all collisions. <br/>
If two asteroids meet, the smaller one will explode. <br/>
If both are the same size, both will explode. <br/>
Two asteroids moving in the same direction will never meet. <br/>

```
Example 1:
Input: 
asteroids = [5, 10, -5]
Output: [5, 10]
Explanation: 
The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.\

Example 2:
Input: 
asteroids = [8, -8]
Output: []
Explanation: 
The 8 and -8 collide exploding each other.

Example 3:
Input: 
asteroids = [10, 2, -5]
Output: [10]
Explanation: 
The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.

Example 4:
Input: 
asteroids = [-2, -1, 1, 2]
Output: [-2, -1, 1, 2]
Explanation: 
The -2 and -1 are moving left, while the 1 and 2 are moving right.
Asteroids moving the same direction never meet, so no asteroids will meet each other.

```

**Note:** 
* The length of asteroids will be at most 10000.
* Each asteroid will be a non-zero integer in the range [-1000, 1000].

**Show tag:** \#stack

--------------------------------------

**Solution** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
행성이 파괴되는 경우는 오른쪽으로 가던 행성과 왼쪽으로 가던 행성이 만났을 때 이다. <br/>
따라서 배열은 순회하면서 해당 행성이 오른쪽으로 가면 스택에 넣으면 되며, <br/>
왼쪽으로 갈 경우 스택에 들어있는 행성을 하나하나씩 꺼내보면서 꺼낸 행성이 오른쪽방향으로 가고있었으면 두 행성이 부딪히는 것이므로 더 작은 행성을 제거하며, 해당 행성이 제거될떄까지 스택에서 꺼낸다. <br/>
해당 행성보다 작은 오른쪽으로 가는 행성들을 스택에서 다 제거하였으면, <br/>
스택에 남아있는 마지막 행성이 오른쪽으로 가고있으며 해당 행성과 크기가 같을경우 둘다 제거하고 끝내며, <br/>
스택이 비어있거나 스택에 남아있는 마지막 행성이 왼쪽으로 가고있으면 해당 행성을 스택에 넣는다. <br/>
이를 n번 반복하면 최종적으로 스택에 남아있는 행성들이 생존한 행성들이다.

**Solution2 (refactoring Solution1)** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
Solution1과 로직은 같으나 stack의 구현방식의 차이가 있다. <br/>
Solution1은 java에서 제공하는 stack을 사용했다면 int배열과 index변수를 이용하여 스택을 구현하였다. <br/>