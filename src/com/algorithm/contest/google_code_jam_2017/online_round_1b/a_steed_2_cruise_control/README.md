## Problem A. Steed 2: Cruise Control

https://code.google.com/codejam/contest/8294486/dashboard#s=p0

Annie is a bus driver with a high-stress job. <br/>
She tried to unwind by going on a Caribbean cruise, but that also turned out to be stressful, so she has recently taken up horseback riding.

Today, Annie is riding her horse to the east along a long and narrow one-way road that runs west to east. <br/>
She is currently at kilometer 0 of the road, and her destination is at kilometer D; kilometers along the road are numbered from west to east.

There are N other horses traveling east on the same road; all of them will go on traveling forever, and all of them are currently between Annie's horse and her destination. <br/>
The i-th of these horses is initially at kilometer Ki and is traveling at its maximum speed of Si kilometers per hour.

Horses are very polite, and a horse H1 will not pass (move ahead of) another horse H2 that started off ahead of H1. <br/>
(Two or more horses can share the same position for any amount of time; you may consider the horses to be single points.) <br/>
Horses (other than Annie's) travel at their maximum speeds, except that whenever a horse H1 catches up to another slower horse H2, H1 reduces its speed to match the speed of H2.

Annie's horse, on the other hand, does not have a maximum speed and can travel at any speed that Annie chooses, as long as it does not pass another horse. <br/>
To ensure a smooth ride for her and her horse, Annie wants to choose a single constant "cruise control" speed for her horse for the entire trip, from her current position to the destination, such that her horse will not pass any other horses. <br/>
What is the maximum such speed that she can choose?

**문제 한글 해석** <br/>
애니는 스트레스를 풀기 위해 승마를 시작하였는데, 서쪽에서 동쪽방향으로 말을 타고 움직인다. <br/>
현재 0km 지점에 있으며 말을 타고 D km까지 움직일 것이다. <br/>
그런데 같은 길의 루트로 여행하는 N마리의 말이 존재하며 이 말들을 끝없이 여행할 예정이다. <br/>
이 N마리의 말들은 각 말마다 처음 위치인 킬로미터단위의 K와 최대속도 S를 가지고 있다. <br/>
말과 말은 서로를 넘을 수 없으며 (단 같은 위치를 공유할 순 있다.) 다른 말을 따라 잡기 전까지는 말은 최대속도로 이동한다. <br/>
애니는 현재 위치에서 목적지 위치까지 cruise control을 하여 다른 말을 넘지 않으면서 일정한 속도로 이동하여 목적지에 도착하고자 한다. <br/>
이때 애니가 고를 수 있는 최대 속도를 구하는것이 목표이다.

입력은 첫줄에는 애니의 목적지(km단위)와 다른 말들의 마리수(N)가 주어진다. </br>
다음줄부터 N개의 줄에는 각 말들의 초기 위치와 속도가 주어진다.<br/>

```
Input
3
2525 1
2400 5
300 2
120 60
60 90
100 2
80 100
70 10


Output
Case #1: 101.000000
Case #2: 100.000000
Case #3: 33.333333

In sample case #1, there is one other (very slow!) horse on the road; it will reach Annie's destination after 25 hours. <br/>
Anything faster than 101 kilometers per hour would cause Annie to pass the horse before reaching the destination.

In sample case #2, there are two other horses on the road. <br/>
The faster horse will catch up to the slower horse at kilometer 240 after 2 hours. <br/>
Both horses will then go at the slower horse's speed for 1 more hour, until the horses reach Annie's destination at kilometer 300. <br/>
The maximum speed that Annie can choose without passing another horse is 100 kilometers per hour.
```

**Solution** <br/>
존재하는 다른 말들 중에 애니의 목적지에 가장 늦게 도착하는 말이 걸리는 시간을 구한다. <br/>
애니의 말은 해당 시간만에 목적지에 도착하도록 여행하면 cruise control의 최대값이된다. <br/>
따라서 존재하는 다른말들을 루프를 이용해 순회하여 (d-init)/speed를 이용하여 목적지까지 걸리는 시간을 구하여 maxTime을 얻어서 d/maxTime으로 애니의 말의 속도를 구하면 된다. <br/>