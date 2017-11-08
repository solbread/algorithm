package com.algorithm.training.depth_first_search.pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int[][] matrix;
    static boolean[][] visit;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> points = new ArrayList<>();
        if(matrix.length == 0) return points;
        this.matrix = matrix;
        visit = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(canFlow(i, j) == 3) {
                    points.add(new int[]{i, j});
                }
            }
        }
        return points;
    }
    private int canFlow(int i, int j) {
        int path = 0;
        if(i == 0 || j == 0) path |= (1<<0);
        if(i == matrix.length-1 || j == matrix[i].length-1) path |= (1<<1);
        visit[i][j] = true;
        if(i < matrix.length-1 && !visit[i+1][j] && matrix[i][j] >= matrix[i+1][j]) { //아래
            path |= canFlow(i+1, j);
        }
        if(i > 0 && !visit[i-1][j] && matrix[i][j] >= matrix[i-1][j]) { //위
            path |= canFlow(i-1, j);
        }
        if(j < matrix.length-1 && !visit[i][j+1] && matrix[i][j] >= matrix[i][j+1]) { //오른쪽
            path |= canFlow(i, j+1);
        }
        if(j > 0 && !visit[i][j-1] && matrix[i][j] >= matrix[i][j-1]) { //왼쪽
            path |= canFlow(i, j-1);
        }
        visit[i][j] = false;
        return path;
    }
    
//    private boolean canFlow(int i, int j) {
//        if(cache[i][j] != -1) return cache[i][j] == 1;
//        boolean canFlow = false;
//        canFlow = canFlow || (i < matrix.length-1 && matrix[i][j] >= matrix[i+1][j] && canFlow(i+1, j));
//        canFlow = canFlow || (i > 0 && matrix[i][j] >= matrix[i-1][j] && canFlow(i-1, j));
//        canFlow = canFlow || (j < matrix.length-1 && matrix[i][j] >= matrix[i][j+1] && canFlow(i, j+1));
//        canFlow = canFlow || (j > 0 && matrix[i][j] >= matrix[i][j-1] && canFlow(i, j-1));
//        
//        cache[i][j] = canFlow ? 1 : 0;
//        return canFlow;
//    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<int[]> points = solution.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        for(int[] point : points) {
            System.out.print("[" + point[0] + ", " + point[1] + "] ");
        }
    }
}
