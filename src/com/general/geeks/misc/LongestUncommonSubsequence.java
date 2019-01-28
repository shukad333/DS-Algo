package com.general.geeks.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings, you need to find the longest uncommon subsequence
 * among them. The longest uncommon subsequence is defined as the longest
 * subsequence of one of these strings and this subsequence should not be any
 * subsequence of the other strings.
 * 
 * A subsequence is a sequence that can be derived from one sequence by deleting
 * some characters without changing the order of the remaining elements.
 * Trivially, any string is a subsequence of itself and an empty string is a
 * subsequence of any string.
 * 
 * The input will be a list of strings, and the output needs to be the length of
 * the longest uncommon subsequence. If the longest uncommon subsequence doesn't
 * exist, return -1.
 * 
 * Example 1: Input: "aba", "cdc", "eae" Output: 3 Note:
 * 
 * All the given strings' lengths will not exceed 10. The length of the given
 * list will be in the range of [2, 50].
 * 
 * @author skadavath
 *
 */
public class LongestUncommonSubsequence {
	
	public static void main(String[] args) {
		System.out.println(new LongestUncommonSubsequence().findLUSlength(new String[] {"abcdef","abc","defg","abcdef","abc"}));
	}

	public int findLUSlength(String[] strs) {
		
		//sort in descending order
		Arrays.sort(strs,(a,b)->b.length()-a.length());
		Set<String> dups = duplicates(strs);
		for(int i=0;i<strs.length;i++) {
			
			if(!dups.contains(strs[i])) {
				
				if(i==0)return strs[i].length();
				for(int j=0;j<i;j++) {
					if(isSubstr(strs[j], strs[i]))break;
					return strs[i].length();
				}
			}
			
		}
		return -1;

	}
	
	private boolean isSubstr(String s1,String s2) {
		int i=0,j=0;
		while(i<s1.length()&&j<s2.length()) {
			if(s1.charAt(i)==s2.charAt(j))j++;
			i++;
		}
		return j==s2.length();
	}
	private Set<String> duplicates(String[] str) {
		Set<String> dups = new HashSet<>();
		Set<String> resp = new HashSet<>();
		for(int i=0;i<str.length;i++) {
			
			if(dups.contains(str[i]))
				resp.add(str[i]);
			dups.add(str[i]);
		}
		
		return resp;
	}

}
