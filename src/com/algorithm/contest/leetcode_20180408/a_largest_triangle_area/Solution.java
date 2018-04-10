package com.algorithm.contest.leetcode_20180408.a_largest_triangle_area;

public class Solution {
    public double largestTriangleArea(int[][] points) {
    	Solution solution = new Solution();
    	double area = Double.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
        	for (int j = i+1; j < points.length; j++) {
        		for (int k = i+2; k < points.length; k++) {
        			int[] point1 = points[i];
        			int[] point2 = points[j];
        			int[] point3 = points[k];
        			double length1 = solution.getLength(point1, point2);
        			double length2 = solution.getLength(point1, point3);
        			double length3 = solution.getLength(point2, point3);
        			double curArea = getArea(length1, length2, length3);
        			if(!Double.isNaN(curArea) && curArea > area) {
        				area = curArea;
        			}
        		}
        	}
        }
        return area;
    }
    private double getLength(int[] point1, int[] point2) {
    	int x1 = point1[0];
    	int x2 = point2[0];
    	int y1 = point1[1];
    	int y2 = point2[1];
    	return Math.sqrt(Math.pow(y1-y2, 2) + Math.pow(x1-x2, 2));
    }
    //Heron's formula
    private double getArea(double length1, double length2, double length3) {
    	double s = (length1 + length2 + length3) / 2.0;
    	return Math.sqrt(s*(s-length1)*(s-length2)*(s-length3));
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.largestTriangleArea(new int[][]{{35,-23},{-12,-48},{-34,-40},{21,-25},{-35,-44},{24,1},{16,-9},{41,4},{-36,-49},{42,-49},{-37,-20},{-35,11},{-2,-36},{18,21},{18,8},{-24,14},{-23,-11},{-8,44},{-19,-3},{0,-10},{-21,-4},{23,18},{20,11},{-42,24},{6,-19}}));
    	System.out.println(solution.largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}));
	}
}
