package com.algorithm.training.string.judge_route_circle;

public class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(char move : moves.toCharArray()) {
            switch (move) {
            case 'L':
                x--;
                break;
            case 'R':
                x++;
                break;
            case 'U':
                y++;
                break;
            case 'D':
                y--;
                break;
            default:
                break;
            }
        }
        return x==0 && y==0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeCircle("UD")); //true
        System.out.println(solution.judgeCircle("LL")); //false
    }
}
