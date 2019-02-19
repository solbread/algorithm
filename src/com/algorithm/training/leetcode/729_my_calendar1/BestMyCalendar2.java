package com.algorithm.training.array.my_calendar1		;

import java.util.TreeSet;

public class BestMyCalendar2 {
	
	private final TreeSet<int[]> calendar;
	
    public BestMyCalendar2() {
    	this.calendar = new TreeSet<>((a,b) -> a[0] - b[0]);
    }
    
    public boolean book(int start, int end) {
    	int[] schedule = {start, end};
        int[] floorSchedule = this.calendar.floor(schedule);
        int[] ceilSchedule = this.calendar.ceiling(schedule);
        if((floorSchedule != null && floorSchedule[1] > start) 
        		|| (ceilSchedule != null && ceilSchedule[0] < end)) return false;
        this.calendar.add(schedule);
        return true;
    }
    
    public static void main(String[] args) {
    	BestMyCalendar2 myCalendar = new BestMyCalendar2();
        System.out.println(myCalendar.book(10, 20)); //true
        System.out.println(myCalendar.book(15, 25)); //false
        System.out.println(myCalendar.book(20, 30)); //true
    }
}
