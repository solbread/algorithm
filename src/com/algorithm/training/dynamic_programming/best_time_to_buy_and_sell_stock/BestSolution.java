package com.algorithm.training.dynamic_programming.best_time_to_buy_and_sell_stock;

public class BestSolution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, currentMin = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
        	if(currentMin > prices[i]) {
        		currentMin = prices[i];
        	} else if (currentMin < prices[i]) {
        		maxProfit = Math.max(maxProfit, prices[i]-currentMin);
        	}
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(solution.maxProfit(prices));
	}
}
