package com.algorithm.training.depth_first_search.find_eventual_safe_states;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[][] graph;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
            if(isSafe(i, new boolean[graph.length])) safeNodes.add(i);
        }
        return safeNodes;
    }
    
    private boolean isSafe(int visitNodeNumber, boolean[] visited) {
        if(visited[visitNodeNumber]) return false;
        boolean isSafe = true;
        visited[visitNodeNumber] = true;
        for(int i = 0; isSafe && i < graph[visitNodeNumber].length; i++) {
             isSafe = isSafe(graph[visitNodeNumber][i], visited);
        }
        visited[visitNodeNumber] = false;
        return isSafe;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}})); //{2,4,5,6}
        System.out.println(solution.eventualSafeNodes(new int[][]{{},{0,2,3,4},{3},{4},{}})); //0,1,2,3,4
    }
}
