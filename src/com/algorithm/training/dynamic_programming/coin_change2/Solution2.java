package com.algorithm.training.dynamic_programming.coin_change2;

public class Solution2 {
    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        if(coins.length==0) return 0;
        int cache[][] = new int[amount+1][coins.length];
        for(int i = 0; i <= amount; i ++) {
            for(int j = 0; j < coins.length; j++) {
                if(i==0) cache[i][j] = 1;
                else {
                    int value = (i - coins[j]>=0) ? cache[i-coins[j]][j]: 0 ;
                    cache[i][j] = (j==0)? value : value+cache[i][j-1];
                }
            }
        }
        return cache[amount][coins.length-1];
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] coins = {5, 1, 2};
		System.out.println(solution.change(5, coins));
	}
}
