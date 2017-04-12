## 121. Best Time to Buy and Sell Stock

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction <br/>
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

```
Example1
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

Example2
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
```

**Show tag:** \#array \#dynamic\_programming

---------------------------------------

**Solution : Time Limit exceed** <br/>
시간복잡도 : O(n^2), 공간복잡도 : O(1) <br/>
매우 단순한 방법으로 두개의 for loop로 발생할 수 있는 모든 구매,판매 를 살펴보면서 max값을 찾는다. <br/>
그러나 time limit exceed로 더 빠른 방법을 찾을 필요가 있다.

**Best Solution** <br/>
시간복잡도 : O(n), 공간복잡도 : O(1)
참고 링크 : https://leetcode.com/articles/best-time-buy-and-sell-stock/ <br/>
현재까지 최소 가격을 저장하는 currentMin과 수익의 최대값을 저장하는 maxProfit 변수를 사용하여 한번의 for loop 만에  해결한다. <br/>
currentMin에는 prices에서 현재 지점까지 중에 가장 최소비용이 들어간다. <br/>
prices의 원소를 순회하면서 현재 index에 해당하는 원소랑 currentMin를 비교해서
1. 현재 원소가 currentMin보다 작으면 currentMin을 현재 원소로 바꿔준다.
2. 현재 원소가 currentMin보다 크면 (현재원소-currentMin)을 계산해서 이 값이 maxProfit보다 크면 maxProfit에 값을 set해준다.

배열은 시간순으로 변하는 가격들이고 딱 한번의 사고, 팔기의 거래가 가능하므로 위와 같은 방법으로 최대 수익을 찾을 수 있다.

