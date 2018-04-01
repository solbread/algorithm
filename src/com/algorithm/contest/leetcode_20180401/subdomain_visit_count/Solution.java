package com.algorithm.contest.leetcode_20180401.subdomain_visit_count;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
    	List<String> subdomainVisits = new ArrayList<>();
    	Map<String, Integer> counter = new HashMap<>();
        for(String cpDomain : cpdomains) {
        	String[] splitedCpDomain = cpDomain.split(" ");
        	String[] subDomains = splitedCpDomain[1].split("\\.");
        	for(int i = subDomains.length-1; i >= 0; i--) {
        		String domain = String.join(".", Arrays.copyOfRange(subDomains, i, subDomains.length));
        		counter.put(domain, counter.getOrDefault(domain, 0) + Integer.parseInt(splitedCpDomain[0]));
        	}
        }
        
        for(Entry<String, Integer> counterEntry : counter.entrySet()) {
        	subdomainVisits.add(counterEntry.getValue() + " " + counterEntry.getKey());
        }
        return subdomainVisits;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.subdomainVisits(new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
		// "901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"
	}
}
