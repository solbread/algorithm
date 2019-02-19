package com.algorithm.training.dynamic_programming.blockgame;

import java.io.File;
import java.io.FileNotFoundException;
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
		cache = new byte[(int)Math.pow(2,25)];
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
	public byte isWin(int boardState) { //-1이면 losing 1이면 winning
	    if(cache[boardState] != 0) return cache[boardState];
	    byte isWin = -1;
		for(int i = 0; i < 5 && isWin == -1; i++) {
		    for(int j = 0; j < 5 && isWin == -1; j++) {
		        if((boardState & (1 << (5*i+j))) == 0) {
		            if(setBlock(boardState, i, j) == 1) {
		                isWin = 1;
		            }
		        }
		    }
		}
		cache[boardState] = isWin;
		return isWin;
	}
	private byte setBlock(int boardState, int cX, int cY) {
	    byte isWin = -1;
        for(int k = 0; k < settingBlock.length && isWin == -1; k++) {
            boolean canSet = true;
            int[][] points =settingBlock[k];
            for(int i = 0; i < points.length; i++) {
                if(cX+points[i][0] < 0 || cX+points[i][0] >= 5 
                        || cY+points[i][1] < 0 || cY+points[i][1] >= 5) {
                    canSet = false;
                    break;
                }
            }
            if(canSet) {
                int nextBoardState = (1<<(5*cX+cY));
                for(int i = 0; i < points.length; i++) {
                    nextBoardState |= (1<<(5*(cX+points[i][0]) + cY + points[i][1]));
                }
                if((boardState & nextBoardState) == 0 && -isWin(boardState|nextBoardState) == 1) {
                    isWin = 1;
                }
            }
        }
		return isWin;
	}
}
