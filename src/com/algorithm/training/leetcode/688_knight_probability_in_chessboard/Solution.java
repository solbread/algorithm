package com.algorithm.training.dynamic_programming.knight_probability_in_chessboard;

public class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[] xDistance = {-1, -2, -1, -2, 1, 2, 1, 2};
        int[] yDistance = {-2, -1, 2, 1, -2, -1, 2, 1};
        int currentPossibleCount = 0;
        double totalProbability = 1.0;
        for(int i = 0; i < xDistance.length; i++) {
            int afterR = r + xDistance[i];
            int afterC = c + yDistance[i];
            if(afterR >= 0 && afterR < N && afterC >= 0 && afterC < N) {
                currentPossibleCount++;
                if(--K > 0) {
                    totalProbability *= knightProbability(N, K, afterR, afterC);
                }
            }
        }
        return totalProbability * currentPossibleCount / 8;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.knightProbability(3, 2, 0, 0)); //0.0625
        System.out.println(solution.knightProbability(8, 30, 6, 4));
    }
}
