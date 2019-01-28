package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * @author skadavath
 *
 */
public class RestoreIPAddresses {
	
	public static void main(String[] args) {
		
		System.out.println(new RestoreIPAddresses().restoreIpAddresses("2352551113"));
		
	}

	public List<String> restoreIpAddresses(String s) {
		
		List<String> resp = new ArrayList<>();
		
		int len = s.length();
		//4?? coz max length is 4 including '.'
		for(int i=1;i<len-2 && i<4;i++) {
			for(int j=i+1;j<i+4 && j<len-1;j++) {
				for(int k=j+1;k<len && k<j+4;k++) {
					String ip0 = s.substring(0, i);
					String ip1 = s.substring(i,j);
					String ip2 = s.substring(j,k);
					String ip3 = s.substring(k, len);
					
					if(isValidIP(ip0) && isValidIP(ip1) && isValidIP(ip2) && isValidIP(ip3))
						resp.add(ip0+"."+ip1+"."+ip2+"."+ip3);
				}
			}
		}
		
		return resp;
	}
	
	
	private boolean isValidIP(String ip) {
		
		if(ip.length()<1 || ip.length()>3 || ip.startsWith("0") || Integer.parseInt(ip)>255)
			return false;
		
		return true;
	}

}
