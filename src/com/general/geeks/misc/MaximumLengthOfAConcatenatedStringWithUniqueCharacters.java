package com.general.geeks.misc;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.
 * 
 * @author skadavath
 *
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
	
	
	public static void main(String[] args) {
		
		System.out.println(new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().maxLength(Arrays.asList("cha","r","act","ers")));
		
	}
	
	 public int maxLength(List<String> arr) {
		 
		 dfs(arr, "", 0);
		 return max;
		 
	 }
	 
	 
	 int max = 0;
	 private void dfs(List<String> arr,String current,int index) {
		 
		 boolean isUni = isUnique(current);
		 if(isUni)
			 max = Math.max(max, current.length());
		 
		 if(index == arr.size() || !isUni)
			 return;
		 
		 for(int i=index;i<arr.size();i++)
			 dfs(arr, current+arr.get(i), i+1);
		 
		 
	 }
	 
	 private boolean isUnique(String s) {
		 int[] chars = new int[26];
		 for(char c : s.toCharArray())
			 chars[c-'a']++;
		 for(int i=0;i<26;i++)
			 if(chars[i]>1)
				 return false;
		 
		 return true;
	 }

}
