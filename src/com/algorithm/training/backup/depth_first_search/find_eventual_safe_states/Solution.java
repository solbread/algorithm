package com.algorithm.training.depth_first_search.find_eventual_safe_states;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[][] graph;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        int[] visitied = new int[graph.length];
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
            if(isSafe(i, visitied)) safeNodes.add(i);
        }
        return safeNodes;
    }
    
    private boolean isSafe(int visitNodeNumber, int[] visited) {
        if(visited[visitNodeNumber] != 0) return visited[visitNodeNumber] == 1;
        boolean isSafe = true;
        visited[visitNodeNumber] = 2;
        for(int i = 0; isSafe && i < graph[visitNodeNumber].length; i++) {
             isSafe = isSafe(graph[visitNodeNumber][i], visited);
        }
        visited[visitNodeNumber] = isSafe ? 1 : 2;
        return isSafe;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}})); //{2,4,5,6}
        System.out.println(solution.eventualSafeNodes(new int[][]{{},{0,2,3,4},{3},{4},{}})); //0,1,2,3,4
    }
}
