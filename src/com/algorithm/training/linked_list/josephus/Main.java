package com.algorithm.training.linked_list.josephus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/linked_list/josephus/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
		    int peopleNumber = scanner.nextInt();
		    int skipCount = scanner.nextInt()-1;
		    List<Integer> check = new LinkedList<>();
		    int index = 0;
		    for(int i = 0; i < peopleNumber; i++) {
		        check.add(i);
		    }
		    while(check.size() > 2) {  
		        check.remove(index);
		        index = (index+skipCount) % check.size();
		    }
		    System.out.println((check.get(0)+1) + " " + (check.get(1)+1));
		}
	}
}
