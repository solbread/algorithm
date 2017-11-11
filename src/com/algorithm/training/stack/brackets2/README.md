## BRACKETS2

**Difficulty:** Easy

https://algospot.com/judge/problem/read/BRACKETS2

Best White is a mathematics graduate student at T1 University. Recently, he finished writing a paper and he decided to polish it. <br/>
As he started to read it from the beginning, he realized that some of the formulas have problems: some of the brackets are mismatched! <br/>
Since there are so many formulas in his paper, he decided to check their validity with a computer program. <br/>

The following kinds of brackets are included in Best White’s paper. <br/>

* Round brackets are opened by a ( and closed by a ).
* Curly brackets are opened by a { and closed by a }.
* Square brackets are opened by a [ and closed by a ].

A formula is said well-matched when the following conditions are met: <br/>
1. Every bracket has a corresponding pair. ( corresponds to ), [ corresponds to ], et cetera.
2. Every bracket pair is opened first, and closed later.
3. No two pairs "*cross*" each other. For example, [(]) is not well-matched.

Write a program to help Best White by checking if each of his formulas is well-matched. To make the problem easier, everything other than brackets are removed from the formulas. <br/>

입력 <br/>
The first line of the input will contain the number of test cases C (1≤C≤100). Each test is given in a single line as a character string. The strings will only include characters in "[](){}" (quotes for clarity). The length of the string will not exceed 10,000.

출력 <br/>
For each test case, print a single line "YES" when the formula is well-matched; print "NO" otherwise. (quotes for clarity)

```
Input:
3
()()
({[}])
({}[(){}])

Output: 
YES
NO
YES
```

**Note:**

**Show tag:** \#dynamic\_programming

------------------------------------

**Main** <br/>
시간복잡도 : O(2^n * n) 공간복잡도 : O(2^n) (n=board의 크기인 25) <br/>
_시간복잡도 정확하게 모르겠다_ <br/>
_해당 코드는 여러번 제출할 경우 가끔씩 TLE가 발생하기도 한다. 매우 느리다._ <br/>

boardState에는 25bit에 5x5보드의 상태를 저장해둔다. <br/>
isWin(int boardState)메소드를 현재 보드 상태가 주어질 때 이번판 플레이어가 이길 수 있는지를 반환하도록 정의한다. <br/>
해당 함수에서는 5x5 보드를 순회하면서 비어있는 지점이 있다면 setBlock() 메소드를 호출하여 block을 놓아서 이길 수 있는지를 확인한다. <br/>

setBlock(int boardState, int cX, int cY)메소드는 보드의 상태가 주어지고 현재위치가 (cX,cY)일 때 block을 놓아서 이길 수 있는지를 확인한다. <br/>
블럭은 총 6가지가 있으므로 해당 경우들을 모두 만들어보면서, <br/>
해당 블럭이 보드판을 벗어나지 않고, 놓고자 하는 위치가 비어있다면 해당 블록을 놓고 보드상태를 변경하여 재귀호출한다. <br/>
이를 반복하여 이길 수 있는 경우가 단 한번이라도 있는지를 확인하여 결과값으로 사용한다. <br/>

이 문제를 풀면서 제출했을 때 런타임에러를 굉장히 많이 만났는데 아래와 같은 이유였다. <br/>
1. 이번 문제에서는 캐시가 재활용이 가능하다. 그러므로 캐시는 한번만 선언 및 초기화 하면 된다.
2. 캐시의 자료형을 int로 하면 메모리가 초과되며, 캐시안에는 -1,0,1만 저장되므로 byte로 선언한다.
3. 매 경기마다 플레이어는 최선을 다하므로 재귀호출을 할 때 이길 수 있는 경우가 한번이라도 발생하면 탐색을 중단한다.

**Best Main** <br/>
시간복잡도 : O(2^n * n) 공간복잡도 : O(2^n) (n=board의 크기인 25) <br/>
isWin()함수는 2^n번 호출되며 내부에서 n만큼의 반복을 수행하므로 시간복잡도는 2^n * n 이다. <br/>
n이 25이므로 시간복잡도가 꽤 크다고 생각될 수 있지만, 두가지 형태의 블록을 놓아서 만들 수 있는 게임판의 상태는 2^n보다 훨씬 적기 때문에 충분하다. (실제로 약160만개정도) <br/>

이 솔루션의 핵심은 각 블록이 차지하는 비트들을 모든 위치와 방향의 조합에 대해 미리 계산해두고, <br/>
이 비트와 현재 게임판의 상태를 비트 AND 연산하는 것으로 블록을 이 위치에 놓을 수 있는지를 판단하는 방식으로 답을 찾는것이다. <br/>

getBlockCases() 메소드는 블록들이 놓일 수 있는 모든 위치의 조합을 저장해두는 list이다. 이는 n에 비례한 크기를 가진다. <br/>
블록이 놓일 수 있는 모든 조합을 저장해 두었으므로 보드상태가 주어질 때 이길 수 있는지 반환하는 isWin() 메소드에서는 list를 순회하며 둘 수 있는 블록을 두면서 모든 경우에 대해 재귀호출 하면 된다. <br/>
 