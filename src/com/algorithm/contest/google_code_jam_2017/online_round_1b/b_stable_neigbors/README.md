## Problem B. Stable Neigh-bors

https://code.google.com/codejam/contest/8294486/dashboard#s=p1

You are lucky enough to own N pet unicorns. <br/>
Each of your unicorns has either one or two of the following kinds of hairs in its mane: red hairs, yellow hairs, and blue hairs. <br/>
The color of a mane depends on exactly which sorts of colored hairs it contains:

* A mane with only one color of hair appears to be that color. For example, a mane with only blue hairs is blue.
* A mane with red and yellow hairs appears orange.
* A mane with yellow and blue hairs appears green.
* A mane with red and blue hairs appears violet.

You have R, O, Y, G, B, and V unicorns with red, orange, yellow, green, blue, and violet manes, respectively.

You have just built a circular stable with N stalls, arranged in a ring such that each stall borders two other stalls. <br/>
You would like to put exactly one of your unicorns in each of these stalls. <br/>
However, unicorns need to feel rare and special, so no unicorn can be next to another unicorn that shares at least one of the hair colors in its mane. <br/>
For example, a unicorn with an orange mane cannot be next to a unicorn with a violet mane, since both of those manes have red hairs. <br/>
Similarly, a unicorn with a green mane cannot be next to a unicorn with a yellow mane, since both of those have yellow hairs.

Is it possible to place all of your unicorns? If so, provide any one arrangement.

**문제 한글 해석** <br/>
N마리의 애완용 유니콘을 데리고 있는데, 유니콘은 갈기의 색의 종류가 다양하다. <br/>
유니콘은 붉은 갈기, 노란 갈기, 파란 갈기 중 하나 혹은 두가지의 갈기를 갖는다. <br/>
* 갈기의 색이 단 하나이면 그 색으로 보인다.
* 빨간색과 노란색의 갈기가 있으면 주황색으로 보인다.
* 노란색과 파란색의 갈기가 있으면 초록색으로 보인다.
* 빨간색과 파란색의 갈기가 있으면 보라색으로 보인다.

원형의 마구간에 유니콘을 배치하려고 하는데 갈기의 색을 하나라도 공유하는 유니콘은 옆에 있을 수 없다. <br/>
모든 유니콘을 배치할 수 있다면 배치방법을 출력하고, 배치할 수 없다면 IMPOSSIBLE을 출력하는 것이 목표이다. <br/>

입력은 공백으로 7개의 정수가 입력되는데, N(유니콘의 마리수), R(붉은 갈기의 유니콘의 마리수), O(주황), Y(노랑), G(초록), B(파랑), V(보라)가 주어진다.

```
Input
4
6 2 0 2 0 2 0
3 1 0 2 0 0 0
6 2 0 1 1 2 0
4 0 0 2 0 0 2

Output
Case #1: RYBRBY
Case #2: IMPOSSIBLE
Case #3: YBRGRB
Case #4: YVYV

For sample case #1, there are many possible answers; for example, another is BYBRYR. <br/>
Note that BYRYRB would not be a valid answer; remember that the stalls form a ring, and the first touches the last!

In sample case #2, there are only three stalls, and each stall is a neighbor of the other two, so the two unicorns with yellow manes would have to be neighbors, which is not allowed.

For sample case #3, note that arranging the unicorns in the same color pattern as the Google logo (BRYBGR) would not be valid, <br/>
since a unicorn with a blue mane would be a neighbor of a unicorn with a green mane, and both of those manes share blue hairs.

In sample case #4, no two unicorns with yellow manes can be neighbors, and no two unicorns with violet manes can be neighbors.
```

----------------------------------------------------

**Solution : just idea** <br/>
1. R -> Y,G,B
2. O -> B
3. Y -> R, B, V
4. G -> R
5. B -> R, O, Y
6. V -> Y

위와 같이 해당 색일때 양옆에 올 수 있는 색을 표시해 보면 두 색의 혼합인 O, G, V일때는 하나의 색만 가능하다는 것을 알 수 있다. <br/>
그래서 각각의 색의 개수를 비교해서 O, G, V를 표시할 수 없을 때는 IMPOSSIBLE 이다. <br/>
그리고 O, G, V를 표시할 수 있다면 남은 R, G, B의 개수를 이용해서 IMPOSSIBLE인지 아닌지를 판단한 후 가능하다면 조합을 만들어 보는 방향으로 접근하려고 하였다. <br/>
그러나 개수를 이용해서 판단하는 IMPOSSIBLE인지 POSSIBLE인지 판단하는 부분부터 막혀서 구현하지 못하였다.