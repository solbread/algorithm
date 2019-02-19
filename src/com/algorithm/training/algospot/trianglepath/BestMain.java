package com.algorithm.training.dynamic_programming.trianglepath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/trianglepath/test"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int cases = scanner.nextInt();
        while(cases-- > 0) {
            int[][] triangle = new int[scanner.nextInt()][];
            int dp[][] = new int[2][triangle.length];
            for(int i = 0; i < triangle.length; i++) {
                triangle[i] = new int[i+1];
                for(int j = 0; j < triangle[i] .length; j++) {
                    triangle[i][j] = scanner.nextInt();
                }
            }
            int maxPathSum = 0;
            dp[0][0] = triangle[0][0];
            for(int i = 1; i < triangle.length; i++) {
                for(int j = 0; j < triangle[i].length; j++) {
                    dp[i%2][j] = Math.max((j==0) ? 0 : dp[(i+1)%2][j-1], dp[(i+1)%2][j]) + triangle[i][j];
                    maxPathSum = Math.max(maxPathSum, dp[i%2][j]);
                }
            }
            System.out.println(maxPathSum);
        }
    }
}
