## KAKURO2

**Difficulty:** Medium

https://algospot.com/judge/problem/read/KAKURO2

Having written a input file generator in Kakuro I, we can now set problems to solve Kakuro puzzles. <br/>

Write a program to solve kakuro puzzles. For Kakuro rules, refer to Kakuro I. <br/>

--------------------------------
KAKURO1 <br/>
https://algospot.com/judge/problem/read/KAKURO1 <br/>

(그림생략) <br/>

카쿠로는 흔히 십자말풀이 수학 버전이라고 불리는 논리 퍼즐이다. <br/>
카쿠로는 위와 같이 생긴 정사각형의 게임판을 가지고 하는 퍼즐로, 이 게임판의 각 칸은 흰 칸이거나, 검은 칸이거나, 힌트 칸이다. (힌트 칸은, 대각선으로 갈라져 있고 숫자가 씌여 있는 칸을 말한다) <br/>
모든 흰 칸에 적절히 숫자를 채워 넣어 규칙을 만족시키는 것이 이 게임의 목표이다.

카쿠로의 규칙은 다음과 같다. <br/>
* 모든 흰 칸에는 1 부터 9 까지의 정수를 써넣어야 한다.
* 세로로 연속한 흰 칸들의 수를 모두 더하면, 그 칸들의 바로 위에 있는 힌트 칸의 왼쪽 아래에 씌인 숫자가 나와야 한다.
* 가로로 연속한 흰 칸들의 수를 모두 더하면, 그 칸들의 바로 왼쪽에 있는 힌트 칸의 오른쪽 위에 씌인 숫자가 나와야 한다.
* 이 때 한 줄을 이루는 연속된 흰 칸들에는 같은 수를 두 번 넣을 수 없다. 예를 들어, 두 개의 흰 칸의 숫자를 더해서 4가 나와야 한다고 하면, 1+3=4 이거나 3+1=4 만이 가능하고, 2+2=4 는 불가능하다.

알고스팟 멤버들은 모의고사를 준비하면서 카쿠로를 푸는 프로그램을 작성하는 문제를 내려고 하는데, 입력 파일 만들기가 너무 힘들어서 입력 파일을 만드는 문제부터 먼저 내기로 했다. <br/>

카쿠로 퍼즐의 답이 주어질 때, Kakuro II의 입력 양식에 맞춘 입력 파일을 작성하는 프로그램을 작성하라. <br/>

입력<br/>
입력의 첫 줄에 테스트 케이스의 수 T 가 주어진다. <br/>
각 테스트 케이스의 첫 줄에는 카쿠로 게임판의 크기 N (N <= 20) 이 주어진다. 카쿠로 게임판은 언제나 정사각형이다. 그 후 N줄에, 각 N개의 정수로 카쿠로 퍼즐의 해답이 주어진다. 힌트 칸이나 검은 칸은 0 으로 주어지고, 흰 칸은 해당 칸에 들어갈 숫자로 주어진다. <br/>

출력<br/>
프로그램의 출력 양식은 Kakuro II 문제의 입력 양식과 정확히 일치해야 한다. 다음은 Kakuro II 문제의 입력 양식이다. <br/>

The first line of input file has the number of test cases T. <br/>
In the first line of each test case, the size of the game board N (<= 20) is given. The next N lines will give a description of the board, from top to bottom. These lines will have N numbers, where 0 denote black/hint cells, and 1 denote white cells. In the next line, the number of hint Q is given. The following Q lines give the hints on the board, each described with four integers: y, x, direction, and sum. sum is the value of the clue (1 <= sum <= 45), and (y, x) is the 1-based coordinate of the hint cell. direction is 0 if hint clue is a horizontal sum, 1 if the clue is a vertical sum. <br/>

단, 이 문제에서는 채점의 편의를 위해 힌트를 정렬된 순서로 출력하기로 한다. 가로 힌트를 세로 힌트보다 먼저 출력해야 하며, 같은 종류의 힌트는 맨 윗 행부터 아래쪽으로, 같은 행 내에서는 왼쪽에서 오른쪽으로 먼저 있는 것 부터 출력해야 한다. <br/>

```
Input:
1
8
0 0 0 0 0 0 0 0
0 9 7 0 0 8 7 9
0 8 9 0 8 9 5 7
0 6 8 5 9 7 0 0
0 0 6 1 0 2 6 0
0 0 0 4 6 1 3 2
0 8 9 3 1 0 1 4
0 3 1 2 0 0 2 1

Output:
1
8
0 0 0 0 0 0 0 0
0 1 1 0 0 1 1 1
0 1 1 0 1 1 1 1
0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0
0 0 0 1 1 1 1 1
0 1 1 1 1 0 1 1
0 1 1 1 0 0 1 1
24
2 1 0 16
2 5 0 24
3 1 0 17
3 4 0 29
4 1 0 35
5 2 0 7
5 5 0 8
6 3 0 16
7 1 0 21
7 6 0 5
8 1 0 6
8 6 0 3
1 2 1 23
1 3 1 30
1 6 1 27
1 7 1 12
1 8 1 16
2 5 1 17
3 4 1 15
4 7 1 12
5 5 1 7
5 8 1 7
6 2 1 11
6 3 1 10
```

-------------------------------

입력 <br/>
The first line of input file has the number of test cases T. <br/>
In the first line of each test case, the size of the game board N (<= 20) is given. The next N lines will give a description of the board, from top to bottom. These lines will have N numbers, where 0 denote black/hint cells, and 1 denote white cells. In the next line, the number of hint Q is given. The following Q lines give the hints on the board, each described with four integers: y, x, direction, and sum. sum is the value of the clue (1 <= sum <= 45), and (y, x) is the 1-based coordinate of the hint cell. direction is 0 if hint clue is a horizontal sum, 1 if the clue is a vertical sum. <br/>
You can assume for all test cases, there will be a unique valid solution. <br/>

출력 <br/>
For each test case, print out the solved Kakuro board in N lines each with N numbers. Print 0 for black or hint cells, and print the filled number for white cells.

```
Input:
1
8
0 0 0 0 0 0 0 0
0 1 1 0 0 1 1 1
0 1 1 0 1 1 1 1
0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0
0 0 0 1 1 1 1 1
0 1 1 1 1 0 1 1
0 1 1 1 0 0 1 1
24
2 1 0 16
2 5 0 24
3 1 0 17
3 4 0 29
4 1 0 35
5 2 0 7
5 5 0 8
6 3 0 16
7 1 0 21
7 6 0 5
8 1 0 6
8 6 0 3
1 2 1 23
1 3 1 30
1 6 1 27
1 7 1 12
1 8 1 16
2 5 1 17
3 4 1 15
4 7 1 12
5 5 1 7
5 8 1 7
6 2 1 11
6 3 1 10

Output: 
0 0 0 0 0 0 0 0
0 9 7 0 0 8 7 9
0 8 9 0 8 9 5 7
0 6 8 5 9 7 0 0
0 0 6 1 0 2 6 0
0 0 0 4 6 1 3 2
0 8 9 3 1 0 1 4
0 3 1 2 0 0 2 1
```

**Note:**

**Show tag:** \#combinatorial\_search

------------------------------------

**Main** <br/>
시간복잡도 : n^4 공간복잡도 : O(n\*n) (n=보드 한변의 크기) <br/>
_시간복잡도 확실하지 않다_ <br/>
fillBoard 함수가 최대 n^2만큼 호출 될 수 있으며, fillBoard 함수 내에서 후보의 수가 가장 적은 칸을 찾는 부분에서 n^2 만큼 소요되기때문에 시간복잡도는 n^4이다. <br/>

알고리즘 문제해결 전략 책의 솔루션을 보고 풀었다. <br/>
굉장히 많은 배열을 선언하였는데 각 배열들의 의미는 아래와 같다. <br/>
* board : n\*n의 배열로 각 칸이 흰색인지(0), 검은칸이거나 힌트칸인지(1)를 저장하는 배열
* solution : n\*n의 카쿠로의 조건을 만족하도록 흰칸에 숫자로 채운 최종 결과 배열 
* hint : n\*n\*2의 배열로 각 칸에 해당하는 두개의 힌트 번호를 저장하는 배열
* length : 힌트칸에 해당하는 흰칸의 수 (n\*n\*2의 배열로 힌트번호를 index로 가짐)
* sum : 힌트칸에 쓰인 숫자 (n\*n\*2의 배열로 힌트번호를 index로 가짐)
* filled : 힌트칸에 해당하는 흰 칸에 쓰인 숫자들의 집합 (n\*n\*2의 배열로 힌트번호를 index로 가짐)
* candidates : 10\*46\*1024 크기의 3차원 배열로 각 index는 \[len\]\[sum\]\[filled\]를 의미하며, len개의 흰칸의 합이 sum이며 현재까지 채워진 숫자가 filled일 때 남은 흰칸에 들어 갈 수 있는 숫자들의 집합을 저장한다.
	* 카쿠로는 힌트칸을 기준으로 1부터 9까지의 정수를 넣을 수 있으므로 length의 크기는 10(0 index는 사용하지 않는다.)
	* 카쿠로의 힌트칸에 쓰인 숫자의 최대값은 1+2+...+9=45 이므로 sum의 크기는 46(0 index는 사용하지 않는다.)
	* 카쿠로의 힌트칸에 해당하는 흰 칸에 쓰인 숫자들은 비트마스크로 나타내면, 최대값은 1부터 9까지가 모두 쓰인 경우로 1023이므로 filled의 최대값은 1024(0은 사용하지 않는다.)

문제 해결 방식은 아래와 같다. <br/>
1. 문제에서 주어지는 board의 color를 board 배열에 저장한다.
2. 문제에서 주어지는 hint정보를 받아서 이를 이용하여 hint, length, sum 배열을 채운다.
	* hint 칸의 y좌표와 x좌표를 기준으로 해당 힌트의 방향을 따라서 흰색칸들을 쭉 따라간다.
	* hint 배열에 해당 흰색칸에 hintNumber를 넣어놓는다.
		* hintNumber는 y\*boardSize + x로 구하는데, 방향이 세로방향, 가로방향 두가지이므로 세로방향은 y\*boardSize로 하고 가로방향은 boardSize\*boardSize를 더한값을 hintNumber로 한다.
	* 해당 hintNumber의 정보를 sum, length 배열에 저장한다.
		* sum에는 해당 hintNumber의 힌트 칸에 쓰인 숫자를, length에는 힌트칸에 해당하는 흰칸의 숫자를 넣는다.
3. candidates 배열을 만들어준다.
	* 특정 칸에 들어 갈 수 있는 숫자 후보들을 구할 때 매번 구하지 않고, 미리 모든 경우의 수에 대해 candidates 배열에 저장해두어 수행시간을 단축하는 것이다.
	* 해당 배열은 1~9의 부분집합(즉 모든 짝수)을 모두 생성하여 해당 후보숫자집합의 length와 sum을 구하고, filled에 들어 갈 수있는 숫자들은 해당 후보숫자집합의 부분집합 이기 때문에 해당 후보숫자집합의 모든 부분집합을 구해서 candidates 값을 채워준다. 
4. fillBoard : solution board에 카쿠로 조건을 만족하는 숫자들로 흰칸을 채우는 함수이다.
	1. 아직 숫자를 쓰지 않은 흰 칸 중의 해당 칸에 들어갈 수 있는 후보의 수가 최소인 칸을 찾는다.
		* getCandidate(int y, int x)는 (y,x)의 흰칸에 들어갈 수 있는 후보숫자들의 집합을 반환한다.
			* hint 배열에서 가로 hintNumber와 세로 hintNumber를 받아온 후에 해당 hintNumber를 이용하여 length, sum, filled 배열에 저장되어있는 해당 힌트칸의 length와 sum과 filled를 받아온다.
			* length와 sum과 filled를 이용해서 해당 조건일때 흰 칸에 들어갈 수 있는 후보숫자들의 집합인 candidates\[len\]\[sum\]\[filled\]를 얻는다.
	2. 함수가 종료되는 경우에는 카쿠로퍼즐을 완성했으면 true를 완성하지 못했으면 false를 return
		* 1에서 찾은 최소인 칸의 후보의 수가 0이라면, 즉 칸에 들어갈 수 있는 숫자가 없다면 카쿠로조건을 만족시키지 못한것이므로 false를 return
		* 모든 칸이 채워졌다면 현재 solution 배열을 print하고 true를 return
	3. 함수가 종료되는 경우가 아니라면 해당 흰 칸에 올 수 있는 후보 숫자들을 모두 채워보고 fillBoard 함수를 재귀호출 하며 카쿠로 조건을 만족시키도록 완성한다.
		* 후보 숫자들을 채울때는 filled 배열에다가 해당 숫자를 채웠다고 표시해둔다.
		* 후보 숫자들을 지울때는 filled 배열에다가 해당 숫자를 지웠다고 표시해둔다.	
		

**제약전파** <br/>
코드에서 명시적으로 구현되고는 있지 않지만 칸(y,x)에 어떤 숫자를 채우면 filled 배열이 갱신되면서 다른 칸에 들어갈 수 있는 후보의 수가 자동적으로 바뀌게 된다. <br/>
만약 한 숫자를 채움으로 인해 다른 자리에 들어갈 숫자가 유일해진다면 자연스럽게 다음 단계에서 그 숫자를 선택하게 된다. <br/>
반면 한 숫자를 채움으로 인해 다른 자리에 들어갈 수 있는 숫자가 존재하지 않게 된다면 자연스럽게 채운 숫자가 잘못되었음을 알게 된다. <br/>
따라서 제약 전파가 자연스럽게 일어난다고 볼 수 있다.
		
**더 최적화하기 (TODO)** <br/>
fillBoard()에서 후보의 수가 가장 적은 칸을 찾기 위해 함수가 호출될 때마다 2중 반복문을 수행해야 한다. <br/>
각 칸의 후보의 수는 해당 칸과 같은 힌트에 속해 있는 칸에 숫자가 쓰일 때만 변경되고, 항상 1에서 9 사이의 값이기 때문에 신경써서 자료구조를 설계하면 이 부분에 드는 부하도 제거할 수 있을 것이다.