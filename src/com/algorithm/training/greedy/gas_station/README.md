## 134. Gas Station

**Difficulty:** Medium

https://leetcode.com/problems/gas-station/#/description

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). <br/>
You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

**Note** <br/>
The solution is guaranteed to be unique.

**Show tag:** \#greedy

------------------------------------

**Best Solution** <br/>
greedy 알고리즘을 적용하여 해결한 방법으로 아래의 아이디어에 기반해서 풀었다. <br/>

1. A에서 시작해서 B에 도달할 수 없다면 A와 B사이에 있는 어떤 역도 B에 도달할 수 없다. <br/>
2. total number of gas는 total number cost보다 커야한다. <br/>
즉 total number of gas가 total number of cost보다 크다면 여행을 마칠 수 있는 startIndex 지점이 반드시 존재한다.<br/>

gas와 cost배열을 순회하면서 전체 gas의 양을 누적하는 totalGas와 현재 startIdex지점부터 i인덱스까지의 gas 양인 currentGas를 사용했다. <br/>
currentGas가 0보다 작아지면 현재 startIndex에서 i로는 도달할 수 없다는 의미이므로 startIndex를 i+1로 바꿔주고, currentGas는 0으로 초기화 하였다. <br/>
totalGas에는 전체 gas의 양이 누적되므로 loop를 순회했을 때 totalGas의 값이 0 이상이라면 startIndex를 반환해주면 되고 <br/>
0보다 작다면 여행을 마칠 수 없다는 것이므로 -1을 반환하면 된다. <br/>

**Best Solution2 : 완벽하게 이해하지 못한 Solution** <br/>
start지점과 end지점을 두고 sum에 gas를 누적하면서 sum이 0이하이면 해당 지점에서 start가 불가능한것이므로 안쪽으로 옮기고, <br/>
sum이 0을 넘으면 end 지점을 옮기면서 한칸 더 움직인다.
그런데 왜 start 지점을 gas.length, end 지점을 0 에서 시작해야 하는지를 이해하지 못했다. <br/>
start 지점을 0, end 지점을 gas.length로 하면 문제가 풀리지 않는데 이것이 의문이다. <br/>

아래는 내가 참고한 Solution의 설명 원문 <br/>
출처 : https://discuss.leetcode.com/topic/1344/share-some-of-my-ideas/5 <br/>
Here is another way: The first part is similar. I guess the main difference here from the others is in the last part when sum<=0. <br/>
Keep track of the running sum of an increasing window from start to end. <br/>
If sum>0, can keep traveling further, add station at the end. <br/>
Otherwise, try starting at an earlier station, since starting inside the window doesn't help. <br/>
Note that sum from the start to the end station does not include the value at the end index, but include the value at the start index.
