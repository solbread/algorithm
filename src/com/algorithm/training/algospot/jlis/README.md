## JLIS

**Difficulty:** Easy

https://algospot.com/judge/problem/read/JLIS

어떤 수열에서 0개 이상의 숫자를 지운 결과를 원 수열의 부분 수열이라고 부릅니다. <br/>
예를 들어 '4 7 6'은 '4 3 7 6 9'의 부분 수열입니다. <br/>
중복된 숫자가 없고 오름 차순으로 정렬되어 있는 부분 수열들을 가리켜 증가 부분 수열이라고 부르지요. <br/>
예를 들어 '3 6 9'는 앞의 수열의 증가 부분 수열입니다. <br/>

두 개의 정수 수열 A 와 B 에서 각각 증가 부분 수열을 얻은 뒤 이들을 크기 순서대로 합친 것을 합친 증가 부분 수열이라고 부르기로 합시다. <br/>
이 중 가장 긴 수열을 합친 LIS(JLIS, Joined Longest Increasing Subsequence)이라고 부릅시다. <br/>
예를 들어 '1 3 4 7 9' 은 '1 9 4' 와 '3 4 7' 의 JLIS입니다. <br/>
'1 9' 와 '3 4 7' 을 합쳐 '1 3 4 7 9'를 얻을 수 있기 때문이지요. <br/>

A 와 B 가 주어질 때, JLIS의 길이를 계산하는 프로그램을 작성하세요. <br/>

입력 <br/>
입력의 첫 줄에는 테스트 케이스의 수 c ( 1 <= c <= 50 ) 가 주어집니다. 각 테스트 케이스의 첫 줄에는 A 와 B 의 길이 n 과 m 이 주어집니다 (1 <= n,m <= 100). 다음 줄에는 n 개의 정수로 A 의 원소들이, 그 다음 줄에는 m 개의 정수로 B 의 원소들이 주어집니다. 모든 원소들은 32비트 부호 있는 정수에 저장할 수 있습니다.

출력 <br/>
각 테스트 케이스마다 한 줄에, JLIS 의 길이를 출력합니다.

```
Input:
3
3 3
1 2 4
3 4 7
3 3
1 2 3
4 5 6
5 3
10 20 30 1 2
10 20 30

Output: 
5
6
5
```

**Note:**

**Show tag:** \#dynamic\_programming

------------------------------------

**Main** <br/>
시간복잡도 : O(nm(n+m)) 공간복잡도 O(nm) <br/>
책의 해답을 보고 풀었다. <br/>
getJLISLength(int start1, int start2)를 numbers1[start1], numbers2[start2]에서 시작하는 합친 증가 부분 수열을 구하는 함수로 정의한다. <br/>
기본적으로 numbers1[start1], numbers2[start2]의 2개의 원소를 가지므로 jlisLength의 초기값은 2이다. <br/>
둘 중 작은 원소를 min, 큰 원소를 max라고 할 때 start1~start2 구간에서의 증가부분 수열은 min, max, ... 로 시작하게 되므로 <br/>
start1+1 ~ numbers1.length, start2 + 1 ~ numbers2.length를 보면서 max값보다 크면 해당 증가부분 수열에 들어갈 수 있다는 것이므로 재귀호출을 하여 구한다. <br/>
참고로 getJLISLength(i,j)인데 numbers1[i]와 numbers2[j]가 같은 경우가 호출되는 경우가 없으므로 위와 같이 해도 상관없다. <br/>