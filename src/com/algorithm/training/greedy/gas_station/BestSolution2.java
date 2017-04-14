package com.algorithm.training.greedy.gas_station;

public class BestSolution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum =0, start = gas.length, end = 0;
        do {
            if(sum <= 0) {
                start--;
                sum += (gas[start]-cost[start]);
            } else {
                sum += (gas[end]-cost[end]);
                end++;                
            }
        } while (start!=end);
        return (sum >= 0) ? start : -1;
    }
    public static void main(String[] args) {
    	BestSolution2 solution = new BestSolution2();
//        int gas[] = {1, 2, 3, 4, 5};
//        int cost[] = {3, 4, 5, 1, 2}; // output : 3
        int gas[] = {4, 5, 1, 2, 3};
        int cost[] = {1, 2, 3, 4, 5}; // output : 0
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}
