package com.algorithm.training.greedy.best_time_to_buy_and_shell_stock2;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, currentMax = 0, currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(i==0 || prices[i] < prices[i-1]) {
                currentMin = prices[i];
                currentMax = 0;
            } else if(prices[i]-currentMin > currentMax) {
                maxProfit += (prices[i]-currentMin - currentMax);
                currentMax = prices[i]-currentMin;
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
