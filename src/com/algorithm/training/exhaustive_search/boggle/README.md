## BOGGLE

**Difficulty:** Easy

https://algospot.com/judge/problem/read/BOGGLE

보글(Boggle) 게임은 그림 (a)와 같은 5x5 크기의 알파벳 격자인 게임판의 한 글자에서 시작해서 펜을 움직이면서 만나는 글자를 그 순서대로 나열하여 만들어지는 영어 단어를 찾아내는 게임입니다. <br/>
펜은 상하좌우, 혹은 대각선으로 인접한 칸으로 이동할 수 있으며 글자를 건너뛸 수는 없습니다. <br/>
지나간 글자를 다시 지나가는 것은 가능하지만, 펜을 이동하지않고 같은 글자를 여러번 쓸 수는 없습니다. <br/>
보글 게임판과 알고 있는 단어들의 목록이 주어질 때, 보글 게임판에서 각 단어를 찾을 수 있는지 여부를 출력하는 프로그램을 작성하세요.

```
Input:
1
URLPM
XPRET
GIAET
XTNZY
XOQRS
6
PRETTY
GIRL
REPEAT
KARA
PANDORA
GIAZAPX

Output: 
PRETTY YES
GIRL YES
REPEAT YES
KARA NO
PANDORA NO
GIAZAPX YES
```

**Note:**

**Show tag:** \#dynamic\_programming

------------------------------------

**Solution** <br/>
시간복잡도 : O(m\*n), 공간복잡도(m\*n) m은 보드의 길이(5), n은 단어의 길이 <br/>
재귀함수 호출을 이용해서 board의 모든 점에서 출발하여 원하는 단어를 만들 수 있는지 확인하였다. <br/>
단, 중복해서 같은 재귀함수를 여러번 호출하므로 메모리제이션을 이용하여 속도향상을 하였다.
