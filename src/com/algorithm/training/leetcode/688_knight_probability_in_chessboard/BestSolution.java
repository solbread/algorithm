package com.algorithm.training.dynamic_programming.knight_probability_in_chessboard;

import java.util.Arrays;

public class BestSolution {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] moves = { {-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {1, 2}, {2, 1} };
        double dp[][] = new double[N][N];
        for(double[] subDp : dp) Arrays.fill(subDp, 1);
        for(int k = 0; k < K; k++) {
        	double tmpDp[][] = new double[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    for(int[] move : moves) {
                        int afterR = i + move[0];
                        int afterC = j + move[1];
                        if(afterR >= 0 && afterR < N && afterC >= 0 && afterC < N) tmpDp[i][j] += dp[afterR][afterC];
                    }
                }
            }
            dp = tmpDp;
        }
        return dp[r][c] / Math.pow(8, K);
    }
    public static void main(String[] args) {
    	BestSolution solution = new BestSolution();
    	System.out.println(solution.knightProbability(3, 2, 0, 0)); //0.0625
        System.out.println(solution.knightProbability(8, 30, 6, 4)); //1.9052566298333648E-4
    }
}
