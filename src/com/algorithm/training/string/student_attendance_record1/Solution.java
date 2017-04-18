package com.algorithm.training.string.student_attendance_record1;

public class Solution {
    public boolean checkRecord(String s) {
        return !s.matches(".*A.*A.*|.*LLL.*");
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.checkRecord("PPALLP")); //output:true
	}
}
