package com.algorithm.training.partition_sum.fishing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/partition_sum/fishing/test"));
			int[][] profit = new int[5][5];
			int[][] partialSum = new int[5][5];
			for(int i =0 ; i < profit.length; i++) {
				for(int j = 0; j < profit[i].length; j++) {
					profit[i][j] = scanner.nextInt();
					partialSum[i][j] += (profit[i][j] 
							+ ( i > 0 ? partialSum[i-1][j] : 0)
							+ ( j > 0 ? partialSum[i][j-1] : 0)
							- ( i > 0 && j > 0 ? partialSum[i-1][j-1] : 0));
				}
			}
			int maxPoint[][] = new int[2][2];
			int maxProfit = Integer.MIN_VALUE;
			for(int x1 = 0; x1 < profit.length; x1++) {
				for(int y1 = 0; y1 < profit[x1].length; y1++) {
					for(int x2 = x1; x2 < profit.length; x2++) {
						for(int y2 = y1; y2 < profit[x1].length; y2++) {
							int curentProfit = partialSum[x2][y2]
									- (x1 > 0 ? partialSum[x1-1][y2] : 0)
									- (y1 > 0 ? partialSum[x2][y1-1] : 0)
									+ (x1 > 0 && y1 > 0 ? partialSum[x1-1][y1-1] : 0);
							if(curentProfit > maxProfit) {
								maxPoint[0][0] = x1+1;
								maxPoint[0][1] = y1+1;
								maxPoint[1][0] = x2+1;
								maxPoint[1][1] = y2+1;
								maxProfit = curentProfit;
							}
						}
					}
				}
			}
			System.out.println(maxProfit);
			for(int i = 0; i < maxPoint.length; i++) {
				for(int j = 0; j < maxPoint[i].length; j++) {
					System.out.print((i==0 && j==0 ? "" : " ") + maxPoint[i][j]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
