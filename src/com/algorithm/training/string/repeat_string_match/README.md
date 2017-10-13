## 686. Repeated String Match

**Difficulty:** Medium

https://leetcode.com/problems/repeated-string-match/description/

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. <br/>
If no such solution, return -1. <br/>

For example, with A = "abcd" and B = "cdabcdab". <br/>

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd"). <br/>

```
Input: abcd
Output: cdabcdab
```

**Note:** The length of A and B will be between 1 and 10000.

**Show tag:** \#string

----------------------------------------

**Solution** <br/>
시간복잡도 : O(max(n,m)) 공간복잡도 O(n) (n=A의길이 m=B의길이) <br/>
_(시간복잡도랑 공간복잡도를 맞게 계산한건지 모르겠다. A의 길이에 상수배를 곱한것과 B의 길이중에 더 큰 값만큼 반복된다고 생각해서 위와 같이 정의하였다)_ <br/>
처음에는 문제이해를 잘못했다. A를 n번 반복해서 만든 string이 B의 substring이 되어야 하므로,중간에 일치가 끊키면 안된다. <br/>
A를 n번 반복해서 B를 만들수 있는지 없는지에 대한 판단은 처음에는 Set을 사용해서 aIndex가 끝났을 때 남은 B를 Set에 넣어 이미 들어있는 B가 또 나오면 만들 수 없다고 판단하려고 했으나, 메모리초과가 발생했다. <br/>
그래서 A가 최대로 반복될 수 있는 횟수를 구해서 이 횟수만큼 A를 반복한 string을 만들어 준 다음에 B가 포함되어 있는지를 확인한 후 포함되어 있다면 반복횟수를 찾는 방법으로 변경하여 해결하였다. <br/>
(A가 최대로 반복될 수 있는 횟수는 가장 길이가 길게 만들어지는 경우인데, A의 마지막 index가 B의 첫번째 글자랑 일치하는 경우이기 때문에 B.length에서 1을 빼준 다음에 이를 A.length로 나눠준값 만큼 A를 append 해준다.)
그 후 최소 반복횟수를 찾을 때 만들어진 repeatedA를 이용하여 찾도록 리펙토링하여 코드를 간결하게 하였다.

**Best Solution** <br/>
시간복잡도 : O(nm) 공간복잡도 O(n) (n=A의길이 m=B의길이) <br/>
_(시간복잡도랑 공간복잡도를 맞게 계산한건지 모르겠다. contains함수의 내부로직에서 A의길이를 상수배한 string과 B의길이의 string을 순회하므로 nm이라고 생각하였다.)_ <br/>
A를 상수배하여 B륾 만들어야 하므로 A는 최소한 B의 길이보다는 길어야 한다. <br/>
따라서 A의 길이가 B길이보다 같거나 커질때까지 A를 반복한 다음에 contains 함수로 B의 substring인지 판단한다. <br/>
위의 경우로 substring이 아니라고 할 경우, 그런데 A의 길이가 B길이보다 같거나 커졌다고 하더라도 매칭할때 A의 뒷부분 문자부터 매칭될경우도 있는 케이스가 있으므로 <br/>
한번 더 A를 반복해준다음에 contains 함수로 B의 substring인지 판단한다. <br/> 