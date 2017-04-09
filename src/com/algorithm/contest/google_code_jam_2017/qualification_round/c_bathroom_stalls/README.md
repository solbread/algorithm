## Problem C. Bathroom Stalls

A certain bathroom has N + 2 stalls in a single row; the stalls on the left and right ends are permanently occupied by the bathroom guards. <br/>
The other N stalls are for users. <br/>

Whenever someone enters the bathroom, they try to choose a stall that is as far from other people as possible. To avoid confusion, they follow deterministic rules: For each empty stall S, they compute two values LS and RS, each of which is the number of empty stalls between S and the closest occupied stall to the left or right, respectively. <br/>
Then they consider the set of stalls with the farthest closest neighbor, that is, those S for which min(LS, RS) is maximal. <br/>
If there is only one such stall, they choose it; otherwise, they choose the one among those where max(LS, RS) is maximal. <br/>
If there are still multiple tied stalls, they choose the leftmost stall among those.

K people are about to enter the bathroom; each one will choose their stall before the next arrives. Nobody will ever leave.

When the last person chooses their stall S, what will the values of max(LS, RS) and min(LS, RS) be?

**문제 한글 해석**
목욕탕에 N+2개의 stall이 있으며 맨 왼쪽과 오른쪽엔 guards가 앉아있다. <br/>
K명의 손님이 들어올때 각각의 손님들은 사람들과 가장 멀리 떨어질 수 있는 의자에 앉는다 <br/>
앉아있는 stall에서 왼쪽에 비어있는 자리의 개수를 L\_s라 하고 오른쪽에 비어있는 자리를 R\_s라고 할 때 <br/>
K명의 손님이 들어오고 N개의 stroll이 있을때 마지막 손님이 앉은 stall에서 max(L\_s, R\_s)와 min(L\_s, R\_s)를 구하는것이 목표다.

```
5
4 2
5 2
6 2
1000 1000
1000 1

Case #1: 1 0
Case #2: 1 0
Case #3: 1 1
Case #4: 0 0
Case #5: 500 499

In Case #1, the first person occupies the leftmost of the middle two stalls, leaving the following configuration (O stands for an occupied stall and . for an empty one): O.O..O. Then, the second and last person occupies the stall immediately to the right, leaving 1 empty stall on one side and none on the other.

In Case #2, the first person occupies the middle stall, getting to O..O..O. Then, the second and last person occupies the leftmost stall.

In Case #3, the first person occupies the leftmost of the two middle stalls, leaving O..O...O. The second person then occupies the middle of the three consecutive empty stalls.

In Case #4, every stall is occupied at the end, no matter what the stall choices are.

In Case #5, the first and only person chooses the leftmost middle stall.
```

**Main(Unsolved : wrong answer)** <br/>
내가 접근한 방식은 주어진 n개의 stall이 있을 때 가장 사람들과 멀리 떨어지는 지점인 가운데지점에 앉고 왼쪽에남은 stall과 오른쪽에 남은 stall의 개수를 계산한다. <br/>
사람이 하나의 stall에 앉게 되면 양쪽으로 두개의 빈공간이 생기게 되므로 (왼쪽에남은stall, 오른쪽에남은stall), (오른쪽에남은stall, 왼쪽에남은stall) 이렇게 두개의 순서쌍을 배열로 만들어서 queue에 넣어준다. <br/>
해당 배열의 0index를 기준으로 우선순위큐를 사용하여 정렬한다. <br/>
그러면 큐에서 원소를 꺼내면 가장 남은 stall이 많은 지점이 반환되며 이지점이 사람이 앉기에 가장 좋은 곳이므로 이 지점의 가운데에 앉고 또 왼쪽과 오른쪽에 남은 stall을 큐에 넣어주는 방식으로 마지막 사람까지 반복하여 마지막 사람이 앉고 나서 남은 왼쪽 stall과 오른쪽 stall의 개수의 max와 min을 반환해준다. <br/>
