package com.algorithm.training.binary_search.darpa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double mast[];
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/com/algorithm/training/binary_search/darpa/test"))));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		int cases = Integer.parseInt(bufferedReader.readLine());
		while(cases-- > 0) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
			int cameraNumber = Integer.parseInt(stringTokenizer.nextToken());
			mast = new double[Integer.parseInt(stringTokenizer.nextToken())];
			stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
			for(int i = 0; i < mast.length; i++) {
				mast[i] = Double.parseDouble(stringTokenizer.nextToken());
			}
			System.out.printf("%.2f\n",main.getLargetDistance(cameraNumber));
		}
	}
	public double getLargetDistance(int cameraNumber) {
		double left = 0, right = mast[mast.length-1];
		for(int i = 0; i < 100; i++) {
			double mid = (right+left)/2.0;
			if(canSetDistance(mid, cameraNumber)) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return left;
	}
	
	private boolean canSetDistance(double distance, int cameraNumber) {
		double lastPosition = mast[0];
		cameraNumber--;
		for(int i = 1; i < mast.length && cameraNumber > 0; i++) {
			if(mast[i] - lastPosition >= distance) {
				cameraNumber--;
				lastPosition = mast[i];
			}
		}
		return cameraNumber == 0;
	}
}
