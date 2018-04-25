package com.algorithm.training.sort.insertion_sort;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = 0;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/com/algorithm/training/sort/insertion_sort/test"))));
//            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            length = Integer.parseInt(bufferedReader.readLine());
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        int nums[] = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Main.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j = i-1, targetNum = arr[i];
            while(j >= 0 && arr[j] > targetNum) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = targetNum;
        }
    }
}