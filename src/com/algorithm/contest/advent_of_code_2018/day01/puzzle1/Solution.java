package com.algorithm.contest.advent_of_code_2018.day01.puzzle1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day01/puzzle1/input");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int result = 0;
            while((line = bufferedReader.readLine())!= null) {
                result += Integer.parseInt(line);
            }
            System.out.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
