package com.algorithm.training.sort.selection_sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/com/algorithm/training/sort/selection_sort/test"))));
        int length = Integer.parseInt(bufferedReader.readLine());
        int nums[] = new int[length];
        for(int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Main.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
