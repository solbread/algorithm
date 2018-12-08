package com.algorithm.contest.advent_of_code_2018.day04.puzzle2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day04/puzzle2/input");
        		BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = null;
            List<String> records = new ArrayList<>();
            while((line = bufferedReader.readLine())!= null) {
            	records.add(line);
            }
            Collections.sort(records);
            int currentGuardId = 0;
            Map<Integer, int[]> cache = new HashMap<>();
            for(int i = 0; i < records.size(); i++) { 
            	if(records.get(i).contains("Guard")) {
            		currentGuardId = Integer.parseInt(records.get(i).split(" ")[3].substring(1));
            		if(!cache.containsKey(currentGuardId)) {
            			cache.put(currentGuardId, new int[60]);
            		}
            	} else {
            	    int asleepTime = Integer.parseInt(records.get(i++).substring(15, 17));
                    int wakeupTime = Integer.parseInt(records.get(i).substring(15, 17));
            	    for(int j = asleepTime; j < wakeupTime; j++) {
            	        cache.get(currentGuardId)[j]++;
            	    }
            	}
            }
            int mostSleepInSameGuardId = 0, mostSleepInSameCount = 0, mostSleepInSameTime = 0;
            for(int guardId : cache.keySet()) {
                int[] sleepTable = cache.get(guardId);
                for(int i = 0; i < 60; i ++) { 
                    if(mostSleepInSameCount < sleepTable[i]) {
                        mostSleepInSameCount = sleepTable[i];
                        mostSleepInSameGuardId = guardId;
                        mostSleepInSameTime = i;
                    }
                }
            }
            System.out.println(mostSleepInSameGuardId * mostSleepInSameTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
