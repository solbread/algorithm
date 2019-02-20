## PACKING

**Difficulty:** Medium

https://algospot.com/judge/problem/read/PACKING

여행을 떠나기 전날까지 절대 짐을 싸지 않는 버릇이 있는 재훈이는 오늘도 비행기 타기 전날에야 가방을 싸기 위해 자리에 앉았습니다. <br/>
비행기 규정상 재훈이는 캐리어를 하나만 가지고 갈 수 있는데, 아무래도 가져가고 싶은 물건들이 캐리어 안에 다 들어가지 않을 것 같습니다. <br/>
재훈이는 가져가고 싶은 각 물건들의 부피와 얼마나 필요한지를 나타내는 절박도를 조사해 다음과 같은 목록을 만들었습니다. <br/>

물건		노트북 컴퓨터	카메라	XBOX365	커피그라인더	아령	백과사전 <br/>
부피		4			2		6		4			2	10 <br/>
절박도	7			10		6		7			5	4 <br/>

캐리어의 용량이 정해져 있기 때문에 가져갈 수 있는 물건들의 부피 합은 캐리어의 용량 w 이하여야 합니다. <br/>
이때 절박도를 최대화할 수 있는 물건들의 목록을 계산하는 프로그램을 작성하세요. <br/>

입력 <br/>
입력의 첫 줄에는 테스트 케이스의 수 C (1≤C≤50)가 주어집니다. 각 테스트 케이스의 첫 줄에는 가져가고 싶은 물건의 수 N (1≤N≤100)과 캐리어의 용량 W (1≤W≤1000)가 주어집니다. 그 이후 N줄에 순서대로 각 물건의 정보가 주어집니다. 한 물건에 대한 정보는 물건의 이름, 부피, 절박도 순서대로 주어지며, 이름은 공백 없는 알파벳 대소문자 1글자 이상 20글자 이하의 문자열, 부피와 절박도는 1000 이하의 자연수입니다.

출력 <br/>
각 테스트 케이스별 출력의 첫 줄에는 가져갈 수 있는 물건들의 최대 절박도 합과 가져갈 물건들의 개수를 출력합니다. 이후 한 줄에 하나씩 각 물건들의 이름을 출력합니다. 만약 절박도를 최대화하는 물건들의 조합이 여럿일 경우 아무 것이나 출력해도 좋습니다.

**Note:**

**Show tag:** \#dynamic\_programming

**Related Problem:** dynamic_programming.sushi

```
Input:
2
6 10
laptop 4 7
camera 2 10
xbox 6 6
grinder 4 7
dumbell 2 5
encyclopedia 10 4
6 17
laptop 4 7
camera 2 10
xbox 6 6
grinder 4 7
dumbell 2 5
encyclopedia 10 4

Output: 
24 3
laptop
camera
grinder
30 4
laptop
camera
xbox
grinder
```

**Note:**

**Show tag:** \#dynamic\_programming \#knapsack

**Related Problem:** 

------------------------------------

**Main** <br/>
시간복잡도 : O(n\*w) 공간복잡도 : O(n\*w)
알고리즘 문제해결전략의 283p 풀이를 보고 구현하였다. <br/>
우선 남은 용량에 담을 수 있는 물건들의 절박도 최대합을 구한 후, 이를 이용하여 담은 물건을 역추적하는 방법으로 구현하였다. <br/>
우선 남은 용량에 담을 수 있는 물건들의 절박도를 구하는getMaxScore(int remainedWeight, int targetItem)를 정의한다. <br/>
해당 함수에서는 targetItem을 캐리어에 담을 수도 있고 담지 않을 수도 있으므로 각각의 경우에 대해 재귀호출하여 최대 절박도의합을 구한다. <br/>
위와 같은 방법으로 최대 절박도합을 구한 후 다음과 같은 방법으로 담은 물건들을 역추적한다. <br/>
(각 부분 문제에 선택지가 두 개 밖에 없기 때문에 따로 선택을 저장하지 않고도 답을 역추적할 수 있다.) <br/>
만약 getMaxScore(remainedWeight, targetItem)과 getMaxScore(remanedWeight, targetItem+1)의 값이 같다면 targetItem을 선택하지 않고도 최대절박도의합을 얻을 수 있다는 것이기 때문에 targetItem은 선택하지 않는다. <br/>
반대로 두개의 값이 다르다면 targetItem을 선택한다.