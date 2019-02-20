package com.algorithm.training.greedy.gas_station;

public class BestSolution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startIndex = 0, totalGas = 0, currentGas = 0;
        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i]-cost[i];
            currentGas += (gas[i]-cost[i]);
            if(currentGas < 0) {
                startIndex = i+1;
                currentGas = 0;
            }
        }
        return (totalGas >= 0) ? startIndex : -1;
    }
    public static void main(String[] args) {
    	BestSolution solution = new BestSolution();
        int gas[] = {1, 2, 3, 4, 5};
        int cost[] = {3, 4, 5, 1, 2}; // output : 3
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}
