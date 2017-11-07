package com.algorithm.training.partition_sum.christmas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.DoubleToLongFunction;

public class Main {
    public static final int MOD_VALUE = 20091101;
    static int[] pDollNumbers, cache;
	public static void main(String[] args) {
	    Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/partition_sum/christmas/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
		    pDollNumbers = new int[scanner.nextInt()];
		    int[] pDollCounter = new int[scanner.nextInt()];
		    cache = new int[(int)Math.pow(2, pDollNumbers.length)];
		    Arrays.fill(cache, -1);
		    pDollCounter[0]  = 1;
		    for(int i = 0; i < pDollNumbers.length; i++) {
		        pDollNumbers[i] = ((i==0 ? 0 : pDollNumbers[i-1]) + scanner.nextInt()) % pDollCounter.length;
		        pDollCounter[pDollNumbers[i]]++;
		    }
		    int singleOrderCount = 0;
		    for(int i = 0; i < pDollCounter.length; i++) {
		        if(pDollCounter[i] >= 2) {
		            singleOrderCount += (pDollCounter[i] * (pDollCounter[i] - 1)/2)%MOD_VALUE;
		        }
		    }
		    int maxOrderCount = main.getMultiMaxOrderCount(0);
		    System.out.println(singleOrderCount + " " + maxOrderCount);
		}
	}
	public int getMultiMaxOrderCount(int order) {
	    if(cache[order] != -1) return cache[order];
	    int maxOrderCount = 0;
	    for(int currentBox = 0; currentBox < pDollNumbers.length; currentBox++) {
	        for(int i = currentBox-1; i >= 0; i--) {
	            int nextOrder = (order | ( ((1<<(currentBox+1))-1) & ~(((1<<(i+1))-1)) ));
	            if((order & nextOrder) == 0) {
	                if(pDollNumbers[currentBox]==pDollNumbers[i]) {
	                    maxOrderCount = Math.max(maxOrderCount, 1 + getMultiMaxOrderCount(nextOrder));
	                }
	            }
	        }
	    }
	    cache[order] = maxOrderCount;
	    return maxOrderCount;
	}
}
