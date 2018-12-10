package com.algorithm.contest.advent_of_code_2018.day09.puzzle2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.algorithm.training.etc.TreeNode;

public class Solution {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("src/com/algorithm/contest/advent_of_code_2018/day09/puzzle2/input");
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            int playerNumer = Integer.parseInt(line.split(" ")[0]);
            int lastMarble = Integer.parseInt(line.split(" ")[6]);
            TreeNode currentNode = new TreeNode(1);
            TreeNode anotherNode = new TreeNode(0);
            currentNode.left = anotherNode;
            currentNode.right = anotherNode;
            anotherNode.left = currentNode;
            anotherNode.right = currentNode;
            int curMarbleNum = 1, currentElf = 1;
            long maxScore = 0;
            Map<Integer, Long> score = new HashMap<>();
            while(++curMarbleNum < lastMarble) {
                if(curMarbleNum % 23 == 0) {
                    currentNode = currentNode.left.left.left.left.left.left.left;
                    int removedMarbleNum = currentNode.val;
                    currentNode.left.right = currentNode.right;
                    currentNode.right.left = currentNode.left;
                    currentNode = currentNode.right;
                    long curElfScore = score.getOrDefault(currentElf, 0l) + curMarbleNum + removedMarbleNum;
                    maxScore = Long.max(maxScore, curElfScore);
                    score.put(currentElf, curElfScore);
                } else {
                    TreeNode newNode = new TreeNode(curMarbleNum);
                    newNode.left = currentNode.right;
                    newNode.right = currentNode.right.right;
                    currentNode.right.right.left = newNode;
                    currentNode.right.right = newNode;
                    currentNode = newNode;
                }
                currentElf = (currentElf + 1) % playerNumer;
            }
            System.out.println(maxScore);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
