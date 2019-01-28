package com.general.geeks.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
 * @author skadavath
 *
 */
public class PartitionLabels {
	
	public static void main(String[] args) {
		System.out.println(new PartitionLabels().partitionLabels("abcacd"));
	}

	public List<Integer> partitionLabels(String S) {
		
		if(S.isEmpty())
			return null;
		
		//just count the max of last occurence of each letter
		//in string and add the number to list
		
		List<Integer> resp = new ArrayList<>();
		int[] pos = new int[26];
		for(int i=0;i<S.length();i++) {
			pos[S.charAt(i)-'a'] = i;
		}
		
		int start = 0;
		int last = 0;
		for(int i=0;i<S.length();i++) {
			last = Math.max(last, pos[S.charAt(i)-'a']);
			if(i==last) {
				resp.add(i-start+1);
				start = i+1;
			}
		}
		return resp;

	}
}
