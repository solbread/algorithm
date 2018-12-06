package com.algorithm.contest.advent_of_code_2018.day06.puzzle2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day05/puzzle2/input");
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            int length = Integer.MAX_VALUE;
            for(char c = 'a'; c <= 'z'; c++) {
                length = Math.min(length, calPolymerLength(line.replace(String.valueOf(c), "").replace(String.valueOf(c).toUpperCase(), "")));
            }
            System.out.println(length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static int calPolymerLength(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for(char c : str.toCharArray()) {
            boolean isRemoved = false;
            while(!deque.isEmpty() && Math.abs(deque.peekLast() - c) == 32) {
                deque.removeLast();
                if(!deque.isEmpty()) {
                    c = deque.removeLast();
                } else {
                    isRemoved = true;
                }
            }
            if(!isRemoved) {
                deque.add(c);
            }
        }
        return deque.size();
    }
}
