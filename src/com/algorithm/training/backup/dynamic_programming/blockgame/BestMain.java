package com.algorithm.training.dynamic_programming.blockgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BestMain {
    static Set<Integer> blockCases;
	static byte[] cache;
	public static void main(String[] args) {
	    BestMain main = new BestMain();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/blockgame/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		cache = new byte[(int)Math.pow(2,25)];
		blockCases = main.getblockCases();
		while(cases-- > 0) {
		    int boardState = 0;
			for(int i = 0; i < 5; i++) {
			    char[] c = scanner.next().toCharArray();
			    for(int j = 0; j < 5; j ++) {
			        if(c[j] == '#') boardState |= (1 << (5*i + j));
			    }
			}
			System.out.println(main.isWin(boardState) == 1 ? "WINNING" : "LOSING");
		}
	}
	public Set<Integer> getblockCases() {
	    Set<Integer> blockCases = new HashSet<>();
	    for(int i = 0; i < 4; i++) {
	        for(int j = 0; j < 4; j++) {
	            int[] point = new int[4];
	            int sumPoint = 0;
	            for(int x = 0; x < 2; x++) {
	                for(int y = 0; y < 2; y++) {
	                    point[2*x+y] = 1 << (5*(i+x)+j+y);
	                    sumPoint+=point[2*x+y];
	                }
	            }
	            for(int k = 0; k < point.length; k++) {
	                blockCases.add(sumPoint-point[k]);
	            }
	        }
	    }
	    for(int i = 0; i < 5; i++) {
	        for(int j = 0; j < 5; j++) {
	            if(j!=4) blockCases.add( (1<<(5*i+j)) + (1<<(5*i+j+1)) );
	            if(i!=4) blockCases.add( (1<<(5*i+j)) + (1<<(5*(i+1)+j)) );
	        }
	    }
	    return blockCases;
	}
	public byte isWin(int boardState) { //-1이면 losing 1이면 winning
	    if(cache[boardState] != 0) return cache[boardState];
	    byte isWin = -1;
	    for(Integer blockCase : blockCases) {
	        if((boardState & blockCase) == 0 && -isWin(boardState | blockCase) == 1) {
	            isWin = 1;
	            break;
	        }
	    }
		cache[boardState] = isWin;
		return isWin;
	}
}
