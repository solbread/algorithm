package com.algorithm.training.array.my_calendar1		;

import java.util.ArrayList;
import java.util.List;

public class BestMyCalendar3 {
	
	private List<int[]> calendar;
	
    public BestMyCalendar3() {
    	this.calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
    	for(int[] schedule : this.calendar) {
    		if(Math.max(schedule[0], start) < Math.min(schedule[1], end)) return false;
    	}
    	this.calendar.add(new int[] {start, end});
    	return true;
    }
    
    public static void main(String[] args) {
    	BestMyCalendar3 myCalendar = new BestMyCalendar3();
        System.out.println(myCalendar.book(10, 20)); //true
        System.out.println(myCalendar.book(15, 25)); //false
        System.out.println(myCalendar.book(20, 30)); //true
    }
}
