package com.algorithm.training.two_pointers.container_with_most_water;

public class BestSolution {
	//Time complexity : O(n)
	public int maxArea(int[] height) {
		int p = 0, q = height.length - 1, maxArea = Integer.MIN_VALUE;
		while (p < q) {
			maxArea = Math.max(maxArea, (q - p) * Math.min(height[p], height[q]));
			if (height[p] < height[q]) p++;
			else q--;
		}
		return maxArea;
	}
	
    public static void main(String[] args) {
		BestSolution solution = new BestSolution();
		int height[] = {3, 4, 4, 3};
		System.out.println(solution.maxArea(height));
	}
}
