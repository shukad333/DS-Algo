package com.general.geeks.misc;

/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1; if version1 < version2 return -1;otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not "two and a
 * half" or "half way to version three", it is the fifth second-level revision
 * of the second first-level revision.
 * 
 * Example 1:
 * 
 * Input: version1 = "0.1", version2 = "1.1" Output: -1 Example 2:
 * 
 * Input: version1 = "1.0.1", version2 = "1" Output: 1 Example 3:
 * 
 * Input: version1 = "7.5.2.4", version2 = "7.5.3" Output: -1
 * 
 * @author skadavath
 *
 */
public class CompareVersionNumbers {
	
	public static void main(String[] args) {
		System.out.println(new CompareVersionNumbers().compareVersion("444444444444444444444444", "4444444444444444444444444"));
	}

	public int compareVersion(String version1, String version2) {
		
		double v1=0,v2=0;
		int i=0,j=0;
		while(i<version1.length() || j<version2.length()) {
			
			while(i<version1.length() && version1.charAt(i)!='.') {
				v1 = v1*10 + version1.charAt(i)-'0';
				i++;
			}
			
			while(j<version2.length() && version2.charAt(j)!='.') {
				v2 = v2*10 + version2.charAt(j)-'0';
				j++;
			}
			
			if(v1>v2)
				return 1;
			else if(v2>v1)
				return -1;
			
			i++;
			j++;
			v1=0;
			v2=0;
		}
		
		return 0;

	}

}
