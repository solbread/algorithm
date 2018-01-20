package com.algorithm.training.binary_search.arctic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BestMain {
	static double stations[][], distance[][];
	public static void main(String[] args) {
		BestMain main = new BestMain();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/com/algorithm/training/binary_search/arctic/test"))));
			int cases = Integer.parseInt(bufferedReader.readLine());
			while (cases-- > 0) {
				stations = new double[Integer.parseInt(bufferedReader.readLine())][2];
				distance = new double[stations.length][stations.length];
				for(int i = 0; i < stations.length; i++) {
					StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
					stations[i][0] = Double.parseDouble(tokenizer.nextToken());
					stations[i][1] = Double.parseDouble(tokenizer.nextToken());
				}
				for(int i = 0; i < distance.length; i++) {
					for(int j = 0; j < distance[i].length; j++) {
						distance[i][j] = main.getDistance(i, j);
					}
				}
				System.out.println(String.format("%.2f", main.getMinRadius()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public double getDistance(int i, int j) {
		double x1 = stations[i][0];
		double y1 = stations[i][1];
		double x2 = stations[j][0];
		double y2 = stations[j][1];
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1- y2, 2));
	}
	
	public double getMinRadius() {
		double lo = 0.0, hi = 1416.00;
		for(int i = 0; i < 100; i++) {
			double mid = (hi - lo) /2 + lo;
			if(canCommunication(mid)) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		return hi;
	}
	
	private boolean canCommunication(double radius) {
		boolean visit[] = new boolean[stations.length];
		visit[0] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		int linkCount = 0;
		while(!queue.isEmpty()) {
			int index = queue.poll();
			linkCount++;
			for(int i = 0; i < stations.length; i++) {
				if(!visit[i] && distance[index][i] <= radius) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}
		return linkCount == stations.length;
	}
}
