package com.algorithm.zero_one_matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BestSolution {
	public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < matrix.size(); i ++) {
			for(int j = 0; j < matrix.get(0).size(); j++) {
				if(matrix.get(i).get(j)==0) queue.add(new int[] {i, j});
				else matrix.get(i).set(j, Integer.MAX_VALUE);
			}
		}
		int[][] directs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		while(!queue.isEmpty()) {
			int[] element = queue.poll();
			for(int[] direct : directs) {
				int a = element[0] + direct[0];
				int b = element[1] + direct[1];
				if(a < 0 || a >= matrix.size() || b < 0 || b >= matrix.get(0).size() 
						|| (matrix.get(element[0]).get(element[1]) + 1) >= matrix.get(a).get(b)) {
					continue;
				}
				matrix.get(a).set(b, (matrix.get(element[0]).get(element[1]) + 1));
				queue.add(new int[] {a, b});
			}
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		BestSolution solution = new BestSolution();
		List<List<Integer>> matrix = new ArrayList<>();
		List<Integer> subMatrix1 = new ArrayList<>();
		List<Integer> subMatrix2 = new ArrayList<>();
		subMatrix1.add(1); subMatrix1.add(0); subMatrix1.add(0);
		subMatrix2.add(1); subMatrix2.add(0); subMatrix2.add(0);
		matrix.add(subMatrix1);
		matrix.add(subMatrix2);
		for(List<Integer> subMatrix : solution.updateMatrix(matrix)) {
			for(int value : subMatrix) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	} 
	
}
