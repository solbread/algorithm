package com.algorithm.training.binary_search.arctic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double stations[][];
	static boolean isPossible[], visit[];
	public static void main(String[] args) {
		Main main = new Main();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/com/algorithm/training/binary_search/arctic/test"))));
			int cases = Integer.parseInt(bufferedReader.readLine());
			while (cases-- > 0) {
				stations = new double[Integer.parseInt(bufferedReader.readLine())][2];
				double maxDistance = Double.MIN_VALUE;
				for(int i = 0; i < stations.length; i++) {
					StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
					stations[i][0] = Double.parseDouble(tokenizer.nextToken());
					stations[i][1] = Double.parseDouble(tokenizer.nextToken());
					maxDistance = Math.max(maxDistance, main.getDistance(stations[0][0], stations[0][1], stations[i][0], stations[i][1]));
				}
				System.out.println(String.format("%.2f", main.getMinRadius(maxDistance)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1- y2, 2));
	}
	
	public double getMinRadius(double maxDistance) {
		double lo = 0.0, hi = maxDistance, mid;
		for(int i = 0;  i < 100; i++) {
			mid = (hi - lo) /2 + lo;
			isPossible = new boolean[stations.length];
			visit = new boolean[stations.length];
			if(linkStation(0, mid)) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		return lo;
	}
	
	private boolean linkStation(int centerIdx, double radius) {
		double[] centerPoint = stations[centerIdx];
		visit[centerIdx] = true;
		isPossible[centerIdx] = true;
		for(int i = 0; i < stations.length; i++) {
			if(!visit[i] && !isPossible[i]) {
				double distance = getDistance(centerPoint[0], centerPoint[1], stations[i][0], stations[i][1]);
				if(distance <= radius && linkStation(i, radius)) {
					return true;
				}
			}
		}
		visit[centerIdx] = false;
		return canCommunication();
	}
	
	private boolean canCommunication() {
		for(int i = 0; i < stations.length; i++) {
			if(!isPossible[i]) return false;
		}
		return true;
	}
}
