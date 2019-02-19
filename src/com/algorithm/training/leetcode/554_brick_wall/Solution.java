package com.algorithm.training.hash_table.brick_wall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
    	int leastBricks = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> rows : wall) {
        	int width = 0;
        	for(int i = 0; i < rows.size()-1; i++) {
        		width += rows.get(i);
        		if(map.get(width) != null) {
        			map.put(width, map.get(width)+1);
        		} else {
        			map.put(width, 1);
        		}
        	}
        }
		Iterator<Integer> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			leastBricks = Math.min(leastBricks, wall.size() - (map.get(iterator.next())));
		}
		return leastBricks;
    }
    
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> wall = new ArrayList<>();
		wall.add(Arrays.asList(new Integer[]{1, 2, 2, 1}));
		wall.add(Arrays.asList(new Integer[]{3, 1, 2}));
		wall.add(Arrays.asList(new Integer[]{1, 3, 2}));
		wall.add(Arrays.asList(new Integer[]{2, 4}));
		wall.add(Arrays.asList(new Integer[]{3, 1, 2}));
		wall.add(Arrays.asList(new Integer[]{1, 3, 1, 1}));
		System.out.println(solution.leastBricks(wall));
	}
}
