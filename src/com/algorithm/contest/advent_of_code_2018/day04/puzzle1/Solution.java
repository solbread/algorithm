package com.algorithm.contest.advent_of_code_2018.day04.puzzle1;

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
        try(FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day04/puzzle1/input");
        		BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = null;
            List<String> records = new ArrayList<>();
            while((line = bufferedReader.readLine())!= null) {
            	records.add(line);
            }
            Collections.sort(records);
            int currentGuardId = 0;
            int maxSleepTime = 0, maxSleepGuardId = 0;
            Map<Integer, int[]> cache = new HashMap<>();
            for(int i = 0; i < records.size(); i++) { 
            	if(records.get(i).contains("Guard")) {
            		currentGuardId = Integer.parseInt(records.get(i).split(" ")[3].substring(1));
            		if(!cache.containsKey(currentGuardId)) {
            			cache.put(currentGuardId, new int[61]);
            		}
            	} else {
            	    int asleepTime = Integer.parseInt(records.get(i++).substring(15, 17));
                    int wakeupTime = Integer.parseInt(records.get(i).substring(15, 17));
            	    for(int j = asleepTime; j < wakeupTime; j++) {
            	        cache.get(currentGuardId)[j]++;
            	    }
            	    cache.get(currentGuardId)[60] += wakeupTime - asleepTime;
            	    if(maxSleepTime < cache.get(currentGuardId)[60]) {
            	        maxSleepTime = cache.get(currentGuardId)[60];
            	        maxSleepGuardId = currentGuardId;
            	    }
            	}
            }
            
            int[] sleepTable = cache.get(maxSleepGuardId);
            int mostSleepCout = 0, mostSleepTime = 0;
            for(int i = 0; i < 60; i++) {
                if (mostSleepCout < sleepTable[i]) {
                    mostSleepCout = sleepTable[i];
                    mostSleepTime = i;
                }
            }
            System.out.println(maxSleepGuardId * mostSleepTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
