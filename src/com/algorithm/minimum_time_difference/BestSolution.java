package com.algorithm.minimum_time_difference;

import java.util.Arrays;
import java.util.List;

public class BestSolution {
	//Time complexity : O(n)
	public int findMinDifference(List<String> timePoints) {
		boolean checkTime[] = new boolean[24*60];
		for(String timePoint : timePoints) {
			String[] time = timePoint.split(":");
			int minutes = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
			if(checkTime[minutes]) return 0;
			checkTime[minutes] = true;
		}
		
		int minDifference = Integer.MAX_VALUE;
		int firstMinutes = 0, prevMinutes = -1;
		for(int i = 0; i < checkTime.length; i++) {
			if(checkTime[i]) {
				if(prevMinutes != -1) {
					minDifference = Math.min(minDifference, (i-prevMinutes) > 720 ? (1440-i+prevMinutes) : (i-prevMinutes));
				} else {
					firstMinutes = i;
				}
				prevMinutes = i;
			}
		}
		minDifference = Math.min(minDifference, (prevMinutes-firstMinutes) > 720 ? (1440-prevMinutes+firstMinutes) : (prevMinutes-firstMinutes));
		return minDifference;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] timePoints = { "11:30", "02:00", "10:30", "21:00" };
		System.out.println(solution.findMinDifference(Arrays.asList(timePoints)));
	}
}
