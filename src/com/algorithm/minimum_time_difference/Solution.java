package com.algorithm.minimum_time_difference;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int minDifference = Integer.MAX_VALUE;
        Comparator<String> timeComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] time1 = o1.split(":");
                String[] time2 = o2.split(":");
                if(Integer.parseInt(time1[0]) == Integer.parseInt(time2[0])) {
                    return Integer.parseInt(time1[1]) < Integer.parseInt(time2[1]) ? -1 : 1;
                } else {
                    return Integer.parseInt(time1[0]) < Integer.parseInt(time2[0]) ? -1 : 1;
                }
            }
        };
        Collections.sort(timePoints, timeComparator);
        for(int i = 0; i < timePoints.size(); i ++) {
            int timeDifference;
            if(i==timePoints.size()-1) timeDifference = calTimeDifference(timePoints.get(0), timePoints.get(i));
            else timeDifference = calTimeDifference(timePoints.get(i), timePoints.get(i+1));
            minDifference = Math.min(minDifference, timeDifference);
        }
        return minDifference;
    }
 
    private int calTimeDifference(String time1, String time2) {
        int time[][] = new int[2][2];
        time[0][0] = Integer.parseInt(time1.split(":")[0]);
        time[0][1] = Integer.parseInt(time1.split(":")[1]);
        time[1][0] = Integer.parseInt(time2.split(":")[0]);
        time[1][1] = Integer.parseInt(time2.split(":")[1]);
        if(time[0][1] > time[1][1]) {
            time[1][1]+=60;
            time[1][0]-=1;
        }
        int timeDifference = (time[1][1]-time[0][1]) + ((time[1][0]-time[0][0])*60);
        return (timeDifference > 720)? (1440-timeDifference) : timeDifference;
    }
 
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] timePoints = {"11:30", "02:00", "10:30", "21:00"};
        System.out.println(solution.findMinDifference(Arrays.asList(timePoints)));
    }
}
