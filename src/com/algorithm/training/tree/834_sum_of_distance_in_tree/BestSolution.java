package com.algorithm.training.tree.sum_of_distance_in_tree;

import java.util.*;

public class BestSolution {
    List<Set<Integer>> linkedNodes;
    int[] countOfSubNodes, sumOfDistance;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        linkedNodes = new ArrayList<>();
        countOfSubNodes = new int[N];
        sumOfDistance = new int[N];
        for(int i = 0; i < N; i++) {
            linkedNodes.add(new HashSet<>());
        }
        for(int[] edge : edges) {
            linkedNodes.get(edge[0]).add(edge[1]);
            linkedNodes.get(edge[1]).add(edge[0]);
        }
        countSubNodes(0, new boolean[N]);
        sumDistance(0, new boolean[N]);
        return sumOfDistance;
    }

    private void countSubNodes(int root, boolean[] visit) {
        visit[root] = true;
        for(int linkedNodeNumber : linkedNodes.get(root)) {
            if(!visit[linkedNodeNumber]) {
                countSubNodes(linkedNodeNumber, visit);
                countOfSubNodes[root] += countOfSubNodes[linkedNodeNumber];
                sumOfDistance[root] += sumOfDistance[linkedNodeNumber] + countOfSubNodes[linkedNodeNumber];
            }
        }
        countOfSubNodes[root]++;
    }

    private void sumDistance(int root, boolean[] visit) {
        visit[root] = true;
        for(int linkedNodeNumber : linkedNodes.get(root)) {
            if(!visit[linkedNodeNumber]) {
                sumOfDistance[linkedNodeNumber] = sumOfDistance[root] - countOfSubNodes[linkedNodeNumber] + countOfSubNodes.length - countOfSubNodes[linkedNodeNumber];
                sumDistance(linkedNodeNumber, visit);
            }
        }
    }
    public static void main(String[] args) {
        BestSolution solution = new BestSolution();
        System.out.print(Arrays.toString(solution.sumOfDistancesInTree(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}})));
    }
}
