package com.algorithm.contest.advent_of_code_2018.day05.puzzle1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day05/puzzle1/input");
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            Deque<Character> deque = new ArrayDeque<>();
            for(char c : line.toCharArray()) {
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
            System.out.print(deque.size());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
