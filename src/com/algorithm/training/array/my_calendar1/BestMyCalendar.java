package com.algorithm.training.array.my_calendar1		;

import java.util.TreeMap;

public class BestMyCalendar {
	
	private final TreeMap<Integer, Integer> calendar;
	
    public BestMyCalendar() {
    	this.calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floorKey = this.calendar.floorKey(start);
        Integer ceilKey = this.calendar.ceilingKey(start);
        if((floorKey != null && this.calendar.get(floorKey) > start) 
        		|| (ceilKey != null && ceilKey < end)) return false;
        this.calendar.put(start, end);
        return true;
    }
    
    public static void main(String[] args) {
    	BestMyCalendar myCalendar = new BestMyCalendar();
        System.out.println(myCalendar.book(10, 20)); //true
        System.out.println(myCalendar.book(15, 25)); //false
        System.out.println(myCalendar.book(20, 30)); //true
    }
}
