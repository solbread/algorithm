package com.algorithm.the_skyline_problem;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        if(buildings.length==0) return result;
        int i = 0, currentX = buildings[0][0], currentMaxY = Integer.MIN_VALUE;
        Queue<Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b) -> (b.getValue()-a.getValue()));
        Queue<Entry<Integer, Integer>> queue2 = new PriorityQueue<>((a,b) -> (a.getKey() - b.getKey()));
        while(currentX <= buildings[buildings.length-1][0] || !queue.isEmpty()) {
            if(!queue2.isEmpty() && queue2.peek().getKey() == currentX) {
                Entry<Integer, Integer> removedBuilding = queue2.poll();
                queue.remove(removedBuilding);
            }
            if(i < buildings.length && buildings[i][0] == currentX) {
                Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(buildings[i][1], buildings[i][2]);
                queue.add(entry);
                queue2.add(entry);
                i++;
            }
            int tmpMaxValue = (queue.isEmpty()) ? 0 : queue.peek().getValue();
            if(tmpMaxValue != currentMaxY) {
                int[] newPoint = {currentX, tmpMaxValue};
                currentMaxY = tmpMaxValue;
                result.add(newPoint);
            }
            currentX = Math.min((i < buildings.length) ? buildings[i][0] : Integer.MAX_VALUE, (queue2.isEmpty()) ? Integer.MAX_VALUE : queue2.peek().getKey());
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] buildings = { {1, 2, 1}, {1, 2, 2}, {1, 2, 3} };
        List<int[]> result = solution.getSkyline(buildings);
        for(int[] subResult : result) {
            System.out.println(Arrays.toString(subResult));
        } //{1, 3}, {2, 0}
    }
}
