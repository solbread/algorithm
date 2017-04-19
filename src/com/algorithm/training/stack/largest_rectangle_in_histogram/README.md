## 84. Largest Rectangle in Histogram

**Difficulty:** Hard

https://leetcode.com/problems/largest-rectangle-in-histogram/#/description

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

(picture) <br/>
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

(picture) <br/>
The largest rectangle is shown in the shaded area, which has area = 10 unit.

```
Given heights = [2,1,5,6,2,3]
return 10.
```

**Show tag:** \#array \#stack

--------------------------------------

**Solution : Unsolved solution** <br/>
**try1** <br/>
처음에는 start=0, end=array.length-1에서 시작해서 <br/>
사각형의 넓이는 height[start]와 height[end]중에 작은 값을 a라고 하면 a * (end-start+1)로 구하고 <br/>
index의 이동은 start index의 height와 end 인덱스의 height 중에 더 작은 방향을 한 칸 씩 옮기면 <br/>
max area를 찾을 수 있을 줄 알았다. <br/>
그런데 이 방법은 완전히 잘못된 방법이었다. 너비계산을 height[start], height[end]중에 작은 값을 높이로 잡으면 start와 end 사이에 더 작은 높이가 있을 수 있으므로 잘못된 area의 계산이었다. <br/>
**try2** <br/>
area 계산하는 방법을 바꿔서 힙을 하나 사용해서 현재 범위에서 가장 작은 높이를 얻을 수 있도록 하였다. <br/>
그래서 area를 계산할 때 heap.peek()*(end-start+1)로 변경하였다. <br/>
그런데 애초에 start=0, end=array.length-1에서 시작해서 안쪽으로 좁히는 방식이 잘못되었다는 것을 알게되었다. <br/>
height[start] < height[end]일 때, height[start+1], height[end]의 너비가 height[start], height[start+1]의 너비보다 항상 크다는 것이 보장이 되지 않기 때문이다. (이해를 위해 예시로 설명 ↓) <br/>
{5, 5, 1, 7, 1, 1, 5, 2, 7, 6} 예시에서 max area를 만드는 경우는 start=8, end=9인 경우로 max area는 12이다. <br/>
그런데 start가 0, end가 9에서 시작하여 안쪽으로 좁혀가다보면 start=3, end=9인 경우에 도달하고 이 때 height[start] > height[end]이므로 end가 한칸 좁혀져서 start=3, end=8이 되므로 start=8, end=9에 도달할 수 없게 된다. <br/>
**try3** <br/>
두번째 시도에서 인덱스의 접근이 잘못되었다는 것을 깨달았지만 이를 개선할 방법이 떠오르지 않았다. <br/>


**BestSolution**
관련 알고리즘 링크 : http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
height의 원소를 for문으로 순회하면서 <br/>
height가 증가하거나 유지될때는 stack에 index를 쌓으면서 <br/>
height가 감소하는 순간에는 stack에 쌓여있는 index의 area를 계산하여 maxArea를 찾는다. <br/>
이 때 height가 감소하는 순간의 index를 i라고 하면 stack에 쌓여있는 index들 중에서 height[i]보다 큰 height를 갖는 index들만 area를 계산한다.(이를 위해서 for문에서 height 감소하는 순간이 발견되면 i--를 통해 계속해서 큰 height를 갖는 index들을 발견하도록 조작해준다.) <br/>
height가 감소하는 순간의 index를 i라고 하고, stack.pop을 한 인덱스를 j라고 하고 한번 더 stack.peek를 한 인덱스를 k라고 하면 <br/>
i부터 j 사이에는 i보다 모두 큰 height만 있다는 것이 보장된다. 왜냐하면 계속 height가 증가할 때만 stack에 쌓았기 때문에 stack에는 작은 height의 index가 맨 아래에 있으며, 큰 height의 index가 위로 올라온다. <br/>
또한 k부터 j 사이에는 모두 j보다 큰 height만 있다는 것도 보장된다. 왜냐하면 height[k] < height[j]임에는 틀림없고 k와 j사이에 stack에 없는 index들은 j의 height보다 크기 때문에 area가 계산되고 stack에서 pop된 것이다. <br/>
그래서 i-1부터 k+1까지의 area를 구하면 이 범위에서 가장 작은 높이가 작은 값은 height[j] 이기 떄문에 height[j]*(i-1-k)가 된다. <br/>
