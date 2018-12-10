package com.algorithm.contest.advent_of_code_2018.day03.puzzle2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day03/puzzle2/input");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int maxWeight = 0, maxHeight = 0;
            Pattern pattern = Pattern.compile("^#(\\d+)\\s@\\s(\\d+),(\\d+):\\s(\\d+)x(\\d+)");
            while((line = bufferedReader.readLine())!= null) {
                //#1 @ 56,249: 24x16
                Matcher matcher = pattern.matcher(line);
                matcher.find();
                maxWeight = Math.max(maxWeight, Integer.parseInt(matcher.group(3)) + Integer.parseInt(matcher.group(5)));
                maxHeight = Math.max(maxHeight, Integer.parseInt(matcher.group(2)) + Integer.parseInt(matcher.group(4)));
            }

            int[][] check = new int[maxHeight+1][maxWeight+1];
            fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day03/puzzle2/input");
            bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine())!= null) {
                Matcher matcher = pattern.matcher(line);
                matcher.find();
                for(int i = Integer.parseInt(matcher.group(3)); i < Integer.parseInt(matcher.group(3)) + Integer.parseInt(matcher.group(5)); i++) {
                    for(int j = Integer.parseInt(matcher.group(2)); j <  Integer.parseInt(matcher.group(2)) + Integer.parseInt(matcher.group(4)); j++) {
                        check[i][j]++;
                    }
                }
            }

            fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day03/puzzle2/input");
            bufferedReader = new BufferedReader(fileReader);
            boolean found = false;
            while(!found && (line = bufferedReader.readLine())!= null) {
                Matcher matcher = pattern.matcher(line);
                matcher.find();
                boolean hasOverlap = false;
                for(int i = Integer.parseInt(matcher.group(3)); !hasOverlap && i < Integer.parseInt(matcher.group(3)) + Integer.parseInt(matcher.group(5)); i++) {
                    for(int j = Integer.parseInt(matcher.group(2)); !hasOverlap && j <  Integer.parseInt(matcher.group(2)) + Integer.parseInt(matcher.group(4)); j++) {
                        hasOverlap = check[i][j] != 1;
                    }
                }
                if(!hasOverlap) {
                    found = true;
                    System.out.println(matcher.group(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
