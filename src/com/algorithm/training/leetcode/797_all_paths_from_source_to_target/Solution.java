package com.algorithm.training.depth_first_search.all_paths_from_source_to_target;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<List<Integer>> allPathList = new ArrayList<>();
	int[][] graph;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    	this.graph = graph;
    	if(graph != null && graph.length > 0 && graph.length-1 >= 0) {
    		dfs(0, new ArrayList<>());
    	}
    	return this.allPathList;
    }
    
    public void dfs(int node, List<Integer> pathList) {
    	pathList.add(node);
    	if(node == graph.length-1) {
    		allPathList.add(new ArrayList<>(pathList));
    	} else {
    		for(int edge : graph[node]) {
    			dfs(edge, pathList);
    		}
    	}
    	pathList.remove(pathList.size()-1);
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] graph = { {1,2}, {3}, {3}, {} };
		List<List<Integer>> allPathList = solution.allPathsSourceTarget(graph); // {{0,1,3},{0,2,3}}
		System.out.println(allPathList);
	}
}
