package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".

We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.


 */
public class SubDomainVisitCount {
	
	public static void main(String[] args) {
		
		String[] arr = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		new SubDomainVisitCount().subdomainVisits(arr);
	}

	public List<String> subdomainVisits(String[] cpdomains) {
		
		Map<String,Integer> map = new TreeMap<>();
		for(String dom : cpdomains) {
			String[] d = dom.split(" ");
			String[] sub = d[1].split("\\.");
			String sb = null;
			for(int i=sub.length-1;i>=0;i--) {
				if(null == sb) {
					sb = sub[i];
				
				}
				else {
					String temp = sub[i];
					temp = temp+"."+sb;
					sb = temp;
				}
				
				
				if(!map.containsKey(sb.toString())) {
					map.put(sb.toString(), Integer.valueOf(d[0]));
				}
				else {
					map.put(sb.toString(), Integer.valueOf(d[0])+map.get(sb.toString()));
				}
			}
		}
		
		List<String> list = new ArrayList();
		for(Entry<String, Integer> entry : map.entrySet()) {
			
			list.add(entry.getKey()+" "+entry.getValue());
			//System.out.println(entry.getKey()+"  "+entry.getValue());
		}
		return list;
	}
}
