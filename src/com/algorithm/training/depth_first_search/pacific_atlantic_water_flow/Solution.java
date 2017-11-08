package com.algorithm.training.depth_first_search.pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static int[][] matrix, cache;
    static boolean[][] visit;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> points = new ArrayList<>();
        if(matrix.length == 0) return points;
        this.matrix = matrix;
        cache = new int[matrix.length][matrix[0].length];
        for(int[] subCache : cache) Arrays.fill(subCache, -1);
        visit = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(canFlow(i, j) == 3) {
                    points.add(new int[]{i, j});
                }
            }
        }
        return points;
    }
    private int canFlow(int i, int j) {
        if(cache[i][j] != -1) return cache[i][j];
        int path = 0;
        if(i == 0 || j == 0) path |= (1<<0);
        if(i == matrix.length-1 || j == matrix[i].length-1) path |= (1<<1);
        
        visit[i][j] = true;
        if(path < 3 && i < matrix.length-1 && !visit[i+1][j] && matrix[i][j] >= matrix[i+1][j]) { //아래
            path |= canFlow(i+1, j);
        }
        if(path < 3 && i > 0 && !visit[i-1][j] && matrix[i][j] >= matrix[i-1][j]) { //위
            path |= canFlow(i-1, j);
        }
        if(path < 3 && j < matrix[0].length-1 && !visit[i][j+1] && matrix[i][j] >= matrix[i][j+1]) { //오른쪽
            path |= canFlow(i, j+1);
        }
        if(path < 3 && j > 0 && !visit[i][j-1] && matrix[i][j] >= matrix[i][j-1]) { //왼쪽
            path |= canFlow(i, j-1);
        }
        visit[i][j] = false;
        cache[i][j] = path;
        return cache[i][j];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<int[]> points = solution.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        for(int[] point : points) {
            System.out.print("[" + point[0] + ", " + point[1] + "] ");
        }
        System.out.println();
        points = solution.pacificAtlantic(new int[][]{{1,1},{1,1},{1,1}});
        for(int[] point : points) {
            System.out.print("[" + point[0] + ", " + point[1] + "] ");
        }
    }
}
