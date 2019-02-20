package com.algorithm.training.dynamic_programming.best_time_to_buy_and_sell_stock;

//Time Limit Exceed 발생 코드
@Deprecated
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length-1; i++) {
        	for (int j = i+1; j < prices.length; j++) {
        		if(prices[j]-prices[i] > maxProfit) {
        			maxProfit = prices[j]-prices[i];
        		}
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
