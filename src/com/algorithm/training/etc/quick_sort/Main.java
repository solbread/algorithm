package com.algorithm.training.sort.quick_sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/com/algorithm/training/sort/quick_sort/test"))));
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
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start < end) {
            int partition = partition(arr, start, end);
            quickSort(arr, start, partition-1);
            quickSort(arr, partition+1, end);
        }
    }

        private static int partition(int arr[], int left, int right) {
        int pivot = (right - left) / 2 + left;
//        int pivot = left;
//        int pivot = right;
        while(left < right) {
            if(arr[pivot] > arr[left]) { //equals없는 조건이 앞에와야 함
                left++;
            } else if(arr[pivot] <= arr[right]) {
                right--;
            } else {
                swap(arr, left, right);
            }
        }
        swap(arr, pivot, left);
        return left;
    }

    private static int partition2(int arr[], int left, int right) {
        int pivot = (right - left) / 2 + left;
        while(left < right) {
            while (arr[pivot] > arr[left] && left < right) {
                left++;
            }

            while (arr[pivot] < arr[right] && left < right) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
            }
        }
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
