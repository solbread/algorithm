package com.algorithm.training.sort.merge_sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/com/algorithm/training/sort/merge_sort/test"))));
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
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int startIdx, int endIdx) {
        if(startIdx != endIdx) {
            int mid = (endIdx - startIdx) / 2 + startIdx;
            mergeSort(arr, startIdx, mid);
            mergeSort(arr, mid+1, endIdx);
            merge(arr, startIdx, mid, endIdx);
        }
    }

    private static void merge(int[] arr, int startIdx, int midIdx, int endIdx) {
        int tmp[] = new int[endIdx - startIdx + 1];
        int left = startIdx, right = midIdx + 1, tmpIdx = 0;
        while(left <= midIdx || right <= endIdx) {
            tmp[tmpIdx++] = left <= midIdx && (right > endIdx || arr[left] < arr[right]) ? arr[left++] : arr[right++];
        }
        tmpIdx = 0;
        for(int i = startIdx; i <= endIdx; i++) {
            arr[i] = tmp[tmpIdx++];
        }
     }
}
