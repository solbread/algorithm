package com.algorithm.training.sort.bubble_sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/com/algorithm/training/sort/bubble_sort/test"))));
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
        for(int i = arr.length-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
