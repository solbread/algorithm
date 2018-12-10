package com.algorithm.contest.advent_of_code_2018.day03.puzzle1;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day03/puzzle1/input");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int maxWeight = 0, maxHeight = 0;
            Pattern pattern = Pattern.compile("^#\\d+\\s@\\s(\\d+),(\\d+):\\s(\\d+)x(\\d+)");
            while((line = bufferedReader.readLine())!= null) {
                //#1 @ 56,249: 24x16
                Matcher matcher = pattern.matcher(line);
                matcher.find();
                maxWeight = Math.max(maxWeight, Integer.parseInt(matcher.group(2)) + Integer.parseInt(matcher.group(4)));
                maxHeight = Math.max(maxHeight, Integer.parseInt(matcher.group(1)) + Integer.parseInt(matcher.group(3)));
            }

            int[][] check = new int[maxHeight+1][maxWeight+1];
            fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day03/puzzle1/input");
            bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine())!= null) {
                Matcher matcher = pattern.matcher(line);
                matcher.find();
                for(int i = Integer.parseInt(matcher.group(2)); i < Integer.parseInt(matcher.group(2)) + Integer.parseInt(matcher.group(4)); i++) {
                    for(int j = Integer.parseInt(matcher.group(1)); j <  Integer.parseInt(matcher.group(1)) + Integer.parseInt(matcher.group(3)); j++) {
                        check[i][j]++;
                    }
                }
            }
            int overlapCnt = 0;
            for(int i = 0; i < check.length; i++) {
                for(int j = 0; j < check[i].length; j++) {
                    if(check[i][j] > 1) {
                        overlapCnt++;
                    }
                }
            }
            System.out.println(overlapCnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
