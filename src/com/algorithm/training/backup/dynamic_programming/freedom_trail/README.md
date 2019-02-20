## 514. Freedom Trail

**Difficulty:** Hard

https://leetcode.com/problems/freedom-trail/description/

n the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring", and use the dial to spell a specific keyword in order to open the door. <br/>

Given a string ring, which represents the code engraved on the outer ring and another string key, which represents the keyword needs to be spelled. <br/>
You need to find the minimum number of steps in order to spell all the characters in the keyword.

Initially, the first character of the ring is aligned at 12:00 direction. <br/>
You need to spell all the characters in the string key one by one by rotating the ring clockwise or anticlockwise to make each character of the string key aligned at 12:00 direction and then by pressing the center button. <br/>

At the stage of rotating the ring to spell the key character key\[i\]: <br/>
1. You can rotate the ring clockwise or anticlockwise one place, which counts as 1 step. The final purpose of the rotation is to align one of the string ring's characters at the 12:00 direction, where this character must equal to the character key\[i\].
2. If the character key[i] has been aligned at the 12:00 direction, you need to press the center button to spell, which also counts as 1 step. After the pressing, you could begin to spell the next character in the key (next stage), otherwise, you've finished all the spelling.

```
(Omit Picture)
Input: ring = "godding", key = "gd"
Output: 4
Explanation:
 For the first key character 'g', since it is already in place, we just need 1 step to spell this character. 
 For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
 Also, we need 1 more step for spelling.
 So the final output is 4.
```

**Show tag:** \#divide\_and\_conquer \#dynamic\_programming \#depth\_first\_search

**Note:**
* Length of both ring and key will be in range 1 to 100.
* There are only lowercase letters in both strings and might be some duplcate characters in both strings.
* It's guaranteed that string key could always be spelled by rotating the string ring.

------------------------------------

**Solution** <br/>
시간복잡도 : O(r\*k) 공간복잡도 : O(r\*k) (r=ring의 길이, k=key의 길이) <br/>
getMinStepCount(int keyIdx, int ringIdx, int direction)메소드를 찾을 key의 index가 keyIdx이고, 현재 ring을 가리키는 index가 ringIdx이며, 방향의 상태가 direction에 주어질 때의 key를 완성하기 위한 가장 작은 단계를 구하는 것이다. <br/>
direction은 0일때는 시계/반시계 어느쪽으로도 움직일 수 있는 상태, 1일때는 시계방향으로 움직여야만 하는 상태, 2일때는 반시계방향으로만 움직여야하는 상태로 정의하였다. <br/>
메소드 내부에서는, <br/>
1. ring\[ringIdx\] != key\[keyIdx\]
	* 두개의 문자가 다르므로 다음번 재귀호출에서도 keyIdx를 그대로 넘겨준다.
	* 이 경우 재귀호출을 할 때 만약 ringIdx를 시계 / 반시계로 둘다 돌릴 경우 사이클이 발생할 수 있다.
		* ringIdx가 1일때 시계로 돌려서 2를 호출했는데 2에서도 key 문자와 다르다면 다시 또 재귀호출로 시계/반시계 방향으로 돌리므로 다시 ringIdx가 1인 경우를 호출하게 되므로 이럴떄 사이클이 발생해서 재귀호출이 무한으로 들어가게 된다.
	* 따라서 direction이라는 파라메터를 통해서 이전에 돌렸던 방향을 기억해서 이전에 돌렸던 방향이 시계라면 시계로만, 반시계라면 반시계로만 돌리게 하였다.
	* 만약 direction이 0이라면 아직 시계랑 반시계 그어떤 방향으로도 돌리지 않은 것이기 때문에 양쪽 다 돌리는 것으로 재귀호출 하였다.
2. ring\[ringIdx\] == key\[keyIdx\]
	* 두개의 문자가 같으므로 다음번 재귀호출에서는 keyIdx+1을 해준다.
	* 다음 key 문자가 현재 ring의 문자와 같을 수도 있으므로 ring은 돌리지 않고 재귀호출한다.
	* 하나의 key를 spell해으므로 사이클이 생길 염려가 없으므로, 다음 호출 메소드에서 ring을 돌리는 방향은 시계가 되어도 반시계가 되어도 상관없으므로 direction은 0으로 호출해준다.
	* key를 spell하는데도 하나의 step이 소요되므로 step은 2를 더해준다. 