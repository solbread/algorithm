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
시간복잡도 : O(n^2) <br/>
매우 단순한 방법으로 두개의 for loop로 발생할 수 있는 모든 구매,판매 를 살펴보면서 max값을 찾음 <br/>
그러나 time limit exceed로 더 빠른 방법을 찾을 필요가 있음