package com.algorithm.training.stack.baseball_game;

import java.util.Stack;

public class Solution {
    public int calPoints(String[] ops) {
    	Stack<Integer> points = new Stack<>();
    	int score = 0;
        for(String op :ops) {
        	int currentScore = 0;
        	switch (op) {
			case "+":
				int lastNumber = points.pop();
				currentScore = lastNumber + points.peek();
				points.push(lastNumber);
				break;
			case "D":
				currentScore = points.peek() * 2;
				break;
			case "C":
				currentScore = points.pop() * -1;
				break;
			default:
				currentScore = Integer.parseInt(op);
				break;
			}
        	score += currentScore;
        	if(!op.equals("C")) points.push(currentScore);
        }
        return score;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		String ops[] = {"5","2","C","D","+"};
//		String ops[] = {"5","-2","4","C","D","9","+","+"};
		System.out.println(solution.calPoints(ops));
	}
}
