package com.algorithm.contest.advent_of_code_2018.day06.puzzle1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day06/puzzle1/input");
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            List<int[]> points = new ArrayList<int[]>();
            int maxX = 0, maxY = 0;
            while((line = bufferedReader.readLine()) != null) {
                int y = Integer.parseInt(line.split(", ")[0]);
                int x = Integer.parseInt(line.split(", ")[1]);
                points.add(new int[2]);
                points.get(points.size()-1)[0] = x;
                points.get(points.size()-1)[1] = y;
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
            int grid[][][] = new int[maxX+1][maxY+1][2];
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[i].length; j++) {
                    grid[i][j][1] = Integer.MAX_VALUE;
                }
            }
            for(int al = 0; al < points.size(); al++) {
                for(int i = 0; i < grid.length; i++) {
                    for(int j = 0; j < grid[i].length; j++) {
                        int curDistance = getDistance(points.get(al), new int[] {i,j});
                        if (grid[i][j][1] == curDistance) {
                            grid[i][j][0] = 100;
                        } else if(grid[i][j][1] > curDistance) {
                            grid[i][j][1] = curDistance;
                            grid[i][j][0] = al;
                        }
                    }
                }
            }
            int maxArea = 0;
            for(int i = 0; i < points.size(); i++) {
                boolean isInfinite = false;
                int currentArea = 0;
                for(int j = 0; !isInfinite && j < grid.length; j++) {
                    for(int k = 0; !isInfinite && k < grid[j].length; k++) {
                        if((k == 0 || k == grid[j].length -1  ||
                                j == 0 || j == grid.length - 1) && grid[j][k][0] == i) {
                            isInfinite = true;
                        } else if (grid[j][k][0] == i) {
                            currentArea++;
                        }
                    }
                }
                if(!isInfinite) {
                    maxArea = Math.max(maxArea, currentArea);
                }
                
            }
            System.out.println(maxArea);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static int getDistance (int[] point1, int[] point2) {
        return Math.abs(point1[0]-point2[0]) + Math.abs(point1[1]-point2[1]);
    }
}
