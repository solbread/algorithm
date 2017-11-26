package com.algorithm.training.math.super_ugly_number;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
    	List<Integer> uglyNumbers = new ArrayList<>();
    	uglyNumbers.add(1);
        Queue<Entry<Integer, Integer>> candidate = new PriorityQueue<>( //prime, index
        		(a,b) -> (a.getKey() * uglyNumbers.get(a.getValue())) - (b.getKey() * uglyNumbers.get(b.getValue()))); 
        for(int i = 0; i < primes.length; i++) {
        	candidate.add(new AbstractMap.SimpleEntry<>(primes[i], 0));
        }
        for(int i = 1; i < n; i++) {
        	Entry<Integer, Integer> uglyNumber = candidate.peek();
        	int uglyNumberValue = uglyNumber.getKey() * uglyNumbers.get(uglyNumber.getValue());
        	uglyNumbers.add(uglyNumberValue);
        	while(candidate.peek().getKey() * uglyNumbers.get(candidate.peek().getValue()) == uglyNumberValue) {
        		Entry<Integer, Integer> samllUglyNumber = candidate.poll();
        		candidate.add(new AbstractMap.SimpleEntry<>(samllUglyNumber.getKey(), samllUglyNumber.getValue()+1));
        	}
        }
        return uglyNumbers.get(uglyNumbers.size()-1);
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.nthSuperUglyNumber(12, new int[] {2,7,13,19})); //32
	}
}
