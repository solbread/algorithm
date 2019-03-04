package com.algorithm.training.sort.bucket_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	public float[] sort(float[] numbers) {
		@SuppressWarnings("unchecked")
		List<Float> count[] = new List[numbers.length+1];
		for(float number : numbers) {
			if(count[(int)(number*10)] == null) count[(int)(number*10)] = new ArrayList<>();
			count[(int)(number*10)].add(number);
		}
		for(int i = 0; i < count.length; i++) {
			if(count[i] != null) {
				Collections.sort(count[i]);
			}
		}
		float[] sortedNumber = new float[numbers.length];
		int index = 0;
		for(int i = 0; i < count.length; i++) {
			if(count[i] != null) {
				for(int j = 0; j < count[i].size(); j++) {
					sortedNumber[index++] = count[i].get(j);
				}
			}
		}
		return sortedNumber;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.sort(new float[] {0.1f, 0.3f, 0.2f, 0.4f})));
	}
}
