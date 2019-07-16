package com.algorithm.training.tree.redundant_connection2;

public class BestSolution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parents = new int[edges.length+1];
        int[][] twoParentEdges = new int[2][];
        for(int[] edge : edges) {
        	int parent1 = parents[edge[1]];
        	if(parent1 != 0) {
        		twoParentEdges[0] = new int[]{parent1, edge[1]};
        		twoParentEdges[1] = new int[]{edge[0], edge[1]};
        		edge[1] = 0;
        	} else {
        		parents[edge[1]] = edge[0];
        	}
        }
        for(int i = 0; i < parents.length; i++) {
        	parents[i] = i;
        }
        for(int[] edge :edges) {
        	if(edge[1] == 0) continue;
        	int parent0 = find(parents, parents[edge[0]]);
        	int parent1 = find(parents, parents[edge[1]]);
        	if(parent0 == parent1) {
        		if(twoParentEdges[0] != null) {
        			return twoParentEdges[0];
        		} else {
        			return edge;
        		}
        	} else {
        		parents[edge[1]] = edge[0];
        	}
        }
        return twoParentEdges[1];
    }
    
    public int find(int[] parents, int point) {
        if(parents[point] == point) return point;
        return find(parents, parents[point]);
    }
    
    public static void main(String[] args) {
    	BestSolution solution = new BestSolution();
        int[] result = solution.findRedundantDirectedConnection(new int[][]{{1,2},{1,3},{2,3}}); //2,3
//        result = solution.findRedundantDirectedConnection(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}}); //1,4
        result = solution.findRedundantDirectedConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}}); //2,1
        System.out.println(result[0] + ", " + result[1]);
    }
}
