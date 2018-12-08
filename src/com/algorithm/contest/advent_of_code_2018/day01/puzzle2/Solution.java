package com.algorithm.contest.advent_of_code_2018.day01.puzzle2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class    Solution {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day01/puzzle2/input");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Set<Integer> set = new HashSet<>();
            String line = null;
            boolean foundDuplicateFrequency = false;
            int result = 0;
            while(!foundDuplicateFrequency) {
                if(line == null) {
                    fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day01/puzzle2/input");
                    bufferedReader = new BufferedReader(fileReader);
                    line = bufferedReader.readLine();
                }
                result += Integer.parseInt(line);
                foundDuplicateFrequency = !set.add(result);
                line    = bufferedReader.readLine();
            }
            System.out.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
