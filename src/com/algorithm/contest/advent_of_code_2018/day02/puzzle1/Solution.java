package com.algorithm.contest.advent_of_code_2018.day02.puzzle1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day02/puzzle1/input");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            int twoLetterCnt = 0, threeLetterCnt = 0;
            while((line = bufferedReader.readLine())!= null) {
                Map<Character, Integer> charCount = new HashMap<>();
                for (int i = 0; i < line.length(); i++) {
                    charCount.put(line.charAt(i), charCount.getOrDefault(line.charAt(i),0) + 1);
                }
                boolean existTwoLetter = false, existThreeLetter= false;
                for(int count : charCount.values()) {
                    if(!existTwoLetter && count == 2) {
                        twoLetterCnt++;
                        existTwoLetter = true;
                    } else if (!existThreeLetter && count == 3) {
                        threeLetterCnt++;
                        existThreeLetter = true;
                    }
                }
            }
            System.out.print(twoLetterCnt * threeLetterCnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
