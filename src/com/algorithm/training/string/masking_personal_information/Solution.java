package com.algorithm.training.string.masking_personal_information;

public class Solution {
    public String maskPII(String S) {
        if(S.contains("@")) {
            return (S.charAt(0) + "*****" + S.charAt(S.indexOf('@')-1) + "@" + S.split("@")[1]).toLowerCase();
        } else {
            S = S.replaceAll("[^0-9]", "");
            String prefix = "";
            for(int i = 10; i < S.length(); i++) {
                prefix+="*";
            }
            return (prefix.length() > 0 ? "+"+prefix+"-" : "") + "***-***-"+ S.substring(S.length()-4, S.length());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maskPII("LeetCode@LeetCode.com")); //l*****e@leetcode.com
        System.out.println(solution.maskPII("AB@qq.com")); //a*****b@qq.com
        System.out.println(solution.maskPII("1(234)567-890")); //***-***-7890
        System.out.println(solution.maskPII("86-(10)12345678")); //+**-***-***-5678
        System.out.println(solution.maskPII("+(501321)-50-23431")); //+***-***-***-3431
    }
}
