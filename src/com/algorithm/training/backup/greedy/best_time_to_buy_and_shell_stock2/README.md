## 122. Best Time to Buy and Sell Stock II

**Difficulty:** Easy

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/#/description

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. <br/>
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). <br/>
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

**Show tag:** \#arrya \#greedy

-----------------------------

**Solution** <br/>
greedy algorithm을 적용해서 prices의 원소를 돌면서 현재 인덱스까지의 최소 가격을 currentMin에 저장하며, 현재 currentMin에 대한 최대 수익을 currentMax에 저장해서 <br/>
maxProfit을 구하는 방식이다. <br/>
처음에는 currentMin에다가 현재 currentMin보다 작은값이 나올때만 값을 변경해줬는데 이 문제는 여러번의 거래가 가능하므로 이는 잘못된 판단이었다 <br/>
예를들면 input이 \[6,1,3,2,4,7\]일 때 위의 로직대로 하면 currentMin은 1에서 for loop을 다 돌 동안 변하지 않으며 currentMax가 7이 되어 7-1 = 6이 결과가 된다. <br/>
그러나 실제로는 (3-1)+(7-2)=7이 올바른 정답이다. <br/>
따라서 price의 상승이 멈추고 하강하게 되면 이 때 주식을 팔고 다시 구매하는 것이 수익을 최대화 하는 방법이다.<br/>
(이렇게 하는것에 대한 이유는 표현할 수 없지만 직관적으로 알 수 있다.) <br/>
즉, i번째 price에서 i+1번째 price가 될 때 price가 하강하게 되면 이때는 i번째를 기준으로 해당 currentMin과 currentMax와 거래를 하고 i번째 price를 새로운 currentMin으로 두는것이 맞다.<br/>
처음에 생각했던 솔루션에서 currentMin을 바꾸는 부분의 조건식만 변경하면 된다. <br/>
위와 같은 방법으로 greedy알고리즘을 이용하여 최대 수익값을 찾아냈다.