package com.algorithm.training.dynamic_programming.blockgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][][] settingBlock = {{{-1,0},{-1,-1}}, {{-1,0},{-1,1}}, {{1,0},{1,-1}}, {{1,0},{1,1}}, {{0,1}}, {{1,0}}};
	static byte[] cache;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/blockgame/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
		    cache = new byte[(int)Math.pow(2,25)];
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
	public int isWin(int boardState) { //-1이면 losing 1이면 winning
	    if(cache[boardState] != 0) return cache[boardState];
	    byte isWin = -1;
		for(int i = 0; i < 5; i++) {
		    for(int j = 0; j < 5; j++) {
		        if((boardState & (1 << (5*i+j))) == 0) {
		            if(setBlock(boardState, i, j) == 1) isWin = 1;;
		        }
		    }
		}
		cache[boardState] = isWin;
		return isWin;
	}
	private int setBlock(int boardState, int cX, int cY) {
	    System.out.println(boardState + " " + cX + " " + cY);
	    int isWin = -1;
        for(int k = 0; k < settingBlock.length; k++) {
            boolean canSet = true;
            int[][] points =settingBlock[k];
            for(int i = 0; i < points.length; i++) {
                if(cX+points[i][0] < 0 || cX+points[i][0] >= 5 
                        || cY+points[i][1] < 0 || cY+points[i][1] >= 5
                        || (boardState & (1 << (5*(cX+points[i][0])+cY+points[i][1]))) > 0) {
                    canSet = false;
                    break;
                }
            }
            if(canSet) {
                int nextBoardState = boardState | (1<<(5*cX+cY));
                for(int i = 0; i < points.length; i++) {
                    nextBoardState |= (1<<(5*(cX+points[i][0]) + cY + points[i][1]));
                }
                if(-isWin(nextBoardState) == 1) {
                    isWin = 1; break;
                }
            }
        }
		return isWin;
	}
}
