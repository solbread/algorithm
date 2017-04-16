## Problem A. Alphabet Cake

https://code.google.com/codejam/contest/5304486/dashboard

You are catering a party for some children, and you are serving them a cake in the shape of a grid with R rows and C columns. <br/>
Your assistant has started to decorate the cake by writing every child's initial in icing on exactly one cell of the cake. <br/>
Each cell contains at most one initial, and since no two children share the same initial, no initial appears more than once on the cake.

Each child wants a single rectangular (grid-aligned) piece of cake that has their initial and no other child's initial(s). <br/>
Can you find a way to assign every blank cell of the cake to one child, such that this goal is accomplished? <br/>
It is guaranteed that this is always possible. <br/>
There is no need to split the cake evenly among the children, and one or more of them may even get a 1-by-1 piece; this will be a valuable life lesson about unfairness.

**문제 한글 해석**
r행과 c열의 grid형태의 케이크가 있는데 한 cell에 한 아이의 initial을 써서 케이크에 장식을 했다. <br/>
각 셀에는 하나의 initial이 포함되며 아이들의 intial으 겹치지 않으므로 한 케이크에 한 initial이 두 번 이상 표시 되지 않는다. <br/>
이 grid 케이크를 어린이들에게 직사각형 모양으로 잘라서 주려고 하는데, 각 어린이들은 다른 어린이의 initial이 없는 직사각형의 cake를 원한다. <br/>
이 조건이 성립하도록 케이크를 나눠서 어린이들에게 나눠주는 방법을 찾는 것이 목적이다 <br/>
각 어린이는 1x1 이상의 케이크를 가지며, 모두 같은 크기의 케이크를 가질 필요는 없다. <br/>
또한 항상 가능하다는 보장이 있다.<br/>

```
input
3
3 3
G??
?C?
??J
3 4
CODE
????
?JAM
2 2
CA
KE

output
Case #1:
GGJ
CCJ
CCJ
Case #2:
CODE
COAE
JJAM
Case #3:
CA
KE

The sample output displays one set of answers to the sample cases. Other answers may be possible.
```
