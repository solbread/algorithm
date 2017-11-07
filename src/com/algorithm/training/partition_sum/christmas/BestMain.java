package com.algorithm.training.partition_sum.christmas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BestMain {
    public static final int MOD_VALUE = 20091101;
    static int[] pDollNumbers;
    static int childNumber;
	public static void main(String[] args) {
	    BestMain main = new BestMain();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/partition_sum/christmas/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
		    pDollNumbers = new int[scanner.nextInt()+1];
		    childNumber = scanner.nextInt();
		    int[] pDollCounter = new int[childNumber];
		    pDollCounter[0] = 1;
		    for(int i = 1; i < pDollNumbers.length; i++) {
		        pDollNumbers[i] = (pDollNumbers[i-1] + scanner.nextInt()) % childNumber;
		        pDollCounter[pDollNumbers[i]]++;
		    }
		    int singleOrderCount = 0;
		    for(int i = 0; i < pDollCounter.length; i++) {
		        if(pDollCounter[i] >= 2) {
		        	singleOrderCount = (singleOrderCount + (pDollCounter[i] * (pDollCounter[i] - 1) / 2)) % MOD_VALUE;
		        }
		    }
		    int maxOrderCount = main.getMultiMaxOrderCount();
		    System.out.println(singleOrderCount + " " + maxOrderCount);
		}
	}
	public int getMultiMaxOrderCount() {
		int ret[] = new int[pDollNumbers.length];
	    int prevPDoll[] = new int[childNumber];
	    Arrays.fill(prevPDoll, -1);
	    for(int i = 0; i < pDollNumbers.length; i++) {
	    	ret[i] = (i==0) ? 0 : ret[i-1];
	    	if(prevPDoll[pDollNumbers[i]] != -1) {
	    		ret[i] = Math.max(ret[i], 1 + ret[prevPDoll[pDollNumbers[i]]]);
	    	}
	    	prevPDoll[pDollNumbers[i]] = i;
	    }
	    return ret[ret.length-1];
	}
}
