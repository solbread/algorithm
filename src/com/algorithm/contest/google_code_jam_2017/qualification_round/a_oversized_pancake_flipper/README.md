##Problem A. Oversized Pancake Flipper

https://code.google.com/codejam/contest/3264486/dashboard#s=p0

Last year, the Infinite House of Pancakes introduced a new kind of pancake. <br/>
It has a happy face made of chocolate chips on one side (the "happy side"), and nothing on the other side (the "blank side").

You are the head cook on duty. <br/>
The pancakes are cooked in a single row over a hot surface. <br/>
As part of its infinite efforts to maximize efficiency, the House has recently given you an oversized pancake flipper that flips exactly K consecutive pancakes. <br/>
That is, in that range of K pancakes, it changes every happy-side pancake to a blank-side pancake, and vice versa; it does not change the left-to-right order of those pancakes.

You cannot flip fewer than K pancakes at a time with the flipper, even at the ends of the row (since there are raised borders on both sides of the cooking surface). <br/>
For example, you can flip the first K pancakes, but not the first K - 1 pancakes.

Your apprentice cook, who is still learning the job, just used the old-fashioned single-pancake flipper to flip some individual pancakes and then ran to the restroom with it, right before the time when customers come to visit the kitchen. <br/>
You only have the oversized pancake flipper left, and you need to use it quickly to leave all the cooking pancakes happy side up, so that the customers leave feeling happy with their visit.

Given the current state of the pancakes, calculate the minimum number of uses of the oversized pancake flipper needed to leave all pancakes happy side up, or state that there is no way to do it.

**문제 한글 해석**
팬케이크가있는데 한쪽면은 웃는얼굴(happy-side), 한쪽면은 비어있는면(blank-side)이다. <br/>
팬케이크는 일렬로 나열되어 있으며, K개의 팬케이크씩 뒤집을 수 있는 K range의 flipper가 있다. <br/>
웃는 얼굴을 +, 비어있는 면을 -로 나타낼 때 K flipper를 이용해서 K개의 팬케이크씩 뒤집어서 팬케이크를 모두 웃는얼굴면이 보이도록 만드는 것이 목적이다. <br/>
팬케이크를 모두 웃는얼굴이 보이도록 만들 수 있는 뒤집는 횟수의 최소값을 찾아야 한다.

```
3
---+-++- 3
+++++ 4
-+-+- 4

Case #1: 3
Case #2: 0
Case #3: IMPOSSIBLE

In Case #1, you can get all the pancakes happy side up by first flipping the leftmost 3 pancakes, <br/>
getting to ++++-++-, then the rightmost 3, getting to ++++---+, and finally the 3 pancakes that remain blank side up. <br/>
There are other ways to do it with 3 flips or more, but none with fewer than 3 flips.

In Case #2, all of the pancakes are already happy side up, so there is no need to flip any of them.

In Case #3, there is no way to make the second and third pancakes from the left have the same side up, <br/>
because any flip flips them both. Therefore, there is no way to make all of the pancakes happy side up.
```

**Solution**
시간복잡도 O(nk) <br/>
욕심쟁이 알고리즘을 적용하였다. <br/>
어차피 -로 되어있는 팬케이크가 +가 되기위해서는 뒤집어져야 하므로 맨 왼쪽의 팬케이크부터 순회하면서 -인 팬케이크가 나오면 그 팬케이크부터 오른쪽으로 k개의 팬케이크를 뒤집어줬다. <br/>
이렇게 length-(k-1) (0-indexed기준)번째 팬케이크까지 k개씩 뒤집기를 하고 나서 <br/>
length-(k-1)까지의 pancake는 웃는얼굴이 올라와있는것이 확정이니까, length-k 부터 length-1까지의 팬 케이크들이 웃는얼굴인지 확인한다. <br/>
모두 웃는얼굴이라면 뒤집은 횟수를 반환, 아니라면 IMPOSSIBLE을 반환하였다.