package com.algorithm.contest.advent_of_code_2018.day02.puzzle2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day02/puzzle2/input");
                BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line = null;
            List<String> input = new ArrayList<>();
            while((line = bufferedReader.readLine())!= null) {
                input.add(line);
            }
            boolean found = false;
            for(int i = 0; !found && i < input.size(); i++) {
                for(int j = i+1; !found && j < input.size(); j++) {
                    int diff = 0, diffIdx = 0;
                    for(int k = 0; k < input.get(i).length(); k++) {
                        if(input.get(i).charAt(k) != input.get(j).charAt(k)) {
                            diff++;
                            diffIdx = k;
                        }
                        if(diff > 2) break;
                    }
                    if(diff == 1) {
                        System.out.print(input.get(i).substring(0, diffIdx) + input.get(i).substring(diffIdx+1, input.get(i).length()));
                        found = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
