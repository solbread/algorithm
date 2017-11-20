## 42. Trapping Rain Water

**Difficulty:** Hard

https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

```
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
(Omit picture)
```

**Note:**

**Show tag:** \#array \#two\_pointers \#stack

**Related Problem:** divide\_and\_conquer.fence

-------------------------------------

**Best Solution : Using Two Pointers** <br/>
시간복잡도 : O(n) 공간복잡도 : O(1) <br/>
0에서 출발하는 left와 height 배열의 끝점에서 출발하는 right의 두개의 포인터를 가지며 left 이하의 점에서의 현재까지 최대 높이를 maxLeft, right 이상의 점에서의 현재까지의 최대 높이를 maxRight에 저장하며 문제를 해결한다.<br/>
매 반복마다 height[left]와 height[right]의 값을 비교해서 각각의 경우에 다른 액션을 취해준다. <br/>
물웅덩이가 만들어질 경우 웅덩이의 넓이는 해당 웅덩이를 만드는 가장 왼쪽 지점의 높이와 가장 오른쪽 지점의 높이 중에서 낮은 높이를 기준으로 범위 안에 있는 높이와의 차를 구해서 넓이에 더해주면 된다. (예를 들어 4,2,1,3로 웅덩이가 만들어졌으면 가장왼쪽높이는 4이고 가장 오른쪽 높이는 3이므로 더 낮은 높이인 3가 기준이되며, 웅덩이의 넓이는 ( (3-2) + (3-1) = 3 ) 이 된다.) <br/>
height[left]와 height[right] 중 더 낮은 높이의 포인터를 옮겨주면서 넓이를 구해나가면 된다. <br/>
1. height[left] < height[right]
	* 아래의 액션을 취하고 left의 값을 +1 해준다.
	1. height[left]의 값이 left 이하 점들에서의 현재까지 최대 높이인 maxLeft보다 크면 새로운 웅덩이가 시작되는 것이므로 maxLeft를 갱신해줌
	2. height[left]의 값이 maxLeft보다 작으면 maxLeft로 만드는 웅덩이에 포함되는 것이므로 넓이를 계산하여 더해준다.
	3. height[left]의 값이 maxLeft와 같으면 아무런 행동도 안하면 된다. (어차피 넓이가 0으로 계산되므로 2번 조건에 포함시켜도 상관없다.)
2. height[left] > height[right]
	* 아래의 액션을 취하고 right의 값을 +1 해준다.
	1. height[right]의 값이 right 이하 점들에서의 현재까지 최대 높이인 maxRight보다 크면 새로운 웅덩이가 시작되는 것이므로 maxLeft를 갱신해줌
	2. height[right]의 값이 maxLeft보다 작으면 maxRight로 만드는 웅덩이에 포함되는 것이므로 넓이를 계산하여 더해준다.
	3. height[right]의 값이 maxRight와 같으면 아무런 행동도 안하면 된다. (어차피 넓이가 0으로 계산되므로 2번 조건에 포함시켜도 상관없다.)
3. height[left] == height[right]
	* 해당 웅덩이의 왼쪽 높이와 오른쪽 높이가 같은 것이므로 1번 혹은 2번 어떤 방식으로 동작하여도 상관없다.
	
**Best Solution : Using Stack** <br/>
시간복잡도 : O(n) 공간복잡도 : O(n) <br/>
height 배열의 index를 옮겨가면서 stack에 index를 넣고 뺌으로써 최대 넓이를 구한다. <br/>
index i에 대해 아래와 같은 액션을 취한다. <br/>
1. 스택이 비어있는 경우
	* 새로운 웅덩이를 만드는 것이므로 stack에 넣는다.
2. 현재 높이(height\[i\])가 stack에 가장 최근에 들어간 높이보다 작은 경우
	* 웅덩이가 만들어 지고 있는 것이기 때문에 stack에 넣는다.
3. 현재 높이(height\[i\])가 stack에 가장 최근에 들어간 높이보다 큰 경우
	* 웅덩이가 만들어 진것이므로 현재높이보다 stack에 위에있는 값이 커질때까지 stack에서 제거하면서 넓이를 계산해서 누적한다.
	* 웅덩이의 넓기 예산
		* 가로
			* 스택에는 바닥에서부터 탑까지 점점 더 작은 높이들만 누적되도록 들어있기 떄문에, stack에서 제거(pop)하여 얻은 index의 웅덩이의 오른쪽은 i지점이며 왼쪽은 stack에서 해당 index 바로 밑에 있는 지점이다.
			* 따라서 가로 길이는 i - stack.peek() -1이 된다. (stack.pop()으로 가장 위의 값을 제거했다는 가정하에 peek())
		* 세로
			* 웅덩이의 넓이를 계산할 때 기준 높이는 웅덩이의 가장 왼쪽 높이와 가장 오른쪽 높이 중 작은 값이 되는데, 가장 왼쪽 높이는 height\[stack.peek()\]이며 가장 오른쪽 높이는 height\[i\]이다.
			* stack.peek()지점의 높이와 i지점의 높이 중에 더 작은 값에서 stack에서 제거한 지점의 높이를 빼주면 된다.
4. 현재 높이(height\[i\]가 stack에 가장 최근에 들어간 높이와 같을 경우)
	* stack에 가장 최근에 들어간 높이는 현재 높이에 포함되므로 stack에서 제거하면 된다.
	* 3번과 동일하게 행동해도 넓이가 0이 계산되기 때문에 무관하다.