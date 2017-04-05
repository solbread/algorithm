package com.algorithm.dynamic_programming.coin_change2;

import java.util.Arrays;

public class Solution {
    public int[][] cache;
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        if(coins.length==0) return 0;
        cache = new int[amount + 1][coins.length + 1];
        for(int i = 0; i < cache.length; i ++) {
            for(int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        Arrays.sort(coins);
        return dp(amount, coins, coins.length-1);
    }
    
    public int dp(int amount, int[] coins, int startIndex) {
        if(cache[amount][startIndex] != -1) return cache[amount][startIndex];
        
        int result = 0;
        for(int i = startIndex; i >=0; i--) {
            if(amount-coins[i]==0) result++;
            else if(amount-coins[i]>0) result += dp(amount-coins[i], coins, i);
        }       
        cache[amount][startIndex] = result;
        return cache[amount][startIndex];
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] coins = {1, 2, 5};
		System.out.println(solution.change(5, coins));
	}
}
