package com.algorithm.training.greedy.best_time_to_buy_and_shell_stock2;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, currentMax = 0, currentMin = Integer.MAX_VALUE;
        for (int price : prices) {
            if(price < currentMin) {
                currentMin = price;
                currentMax = 0;
            } else if(price-currentMin > currentMax) {
                maxProfit += (price-currentMin - currentMax);
                currentMax = price-currentMin;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices = {6,1,3,2,4,7};
		System.out.println(solution.maxProfit(prices));
	}
}
