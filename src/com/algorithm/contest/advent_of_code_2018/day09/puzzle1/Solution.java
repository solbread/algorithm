package com.algorithm.contest.advent_of_code_2018.day09.puzzle1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day09/puzzle1/input");
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            int playerNumer = Integer.parseInt(line.split(" ")[0]);
            int lastMarble = Integer.parseInt(line.split(" ")[6]);
            List<Integer> board = new LinkedList<>();
            board.add(0);
            int currentElf = 0, curMarbleNum = 0, curMarblePointer = 0;
            int maxScore = 0;
            Map<Integer, Integer> score = new HashMap<>();
            while(++curMarbleNum < lastMarble) {
                if(curMarbleNum % 23 == 0) {
                    curMarblePointer-=7;
                    while(curMarblePointer < 0) {
                        curMarblePointer+=board.size();
                    }
                    int removedMarbleNum = board.remove(curMarblePointer);
                    int curElfScore = score.getOrDefault(currentElf, 0) + curMarbleNum + removedMarbleNum;
                    maxScore = Integer.max(maxScore, curElfScore);
                    score.put(currentElf, curElfScore);
                    
                } else {
                    curMarblePointer+=2;
                    while(curMarblePointer > board.size()) {
                        curMarblePointer-=board.size();
                    }
                    board.add(curMarblePointer, curMarbleNum);
                }
                currentElf = (currentElf + 1) % playerNumer;
            }
            System.out.println(maxScore);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
