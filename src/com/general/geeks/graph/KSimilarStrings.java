package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Strings A and B are K-similar (for some non-negative integer K) if we can
 * swap the positions of two letters in A exactly K times so that the resulting
 * string equals B.
 * 
 * Given two anagrams A and B, return the smallest K for which A and B are
 * K-similar.
 * 
 * Example 1:
 * 
 * Input: A = "ab", B = "ba" Output: 1 Example 2:
 * 
 * Input: A = "abc", B = "bca" Output: 2 Example 3:
 * 
 * Input: A = "abac", B = "baca" Output: 2 Example 4:
 * 
 * Input: A = "aabc", B = "abca" Output: 2 Note:
 * 
 * 1 <= A.length == B.length <= 20 A and B contain only lowercase letters from
 * the set {'a', 'b', 'c', 'd', 'e', 'f'}
 * 
 * @author skadavath
 *
 */
public class KSimilarStrings {
	
	public static void main(String[] args) {
		
		System.out.println(new KSimilarStrings().kSimilarity("ab", "ba"));
		
	}

	public int kSimilarity(String A, String B) {
		
		if(A.equals(B))
			return 0;
		
		Queue<String> queue = new LinkedList<>();
		queue.add(A);
		
		int resp = 0;
		Set<String> visited = new HashSet<>();
		while(!queue.isEmpty()) {
			resp++;
			int size = queue.size();
			for(int k=0;k<size;k++) {
				String s = queue.poll();
				int i=0;
				while(s.charAt(i)==B.charAt(i))i++;
				for(int j=i+1;j<A.length();j++) {
					if(s.charAt(j)==B.charAt(j) || s.charAt(j)!=B.charAt(i))
						continue;
					String swapped = swap(s, i, j);
					if(swapped.equals(B)) return resp;
					if(visited.add(swapped))queue.add(swapped);
					
				}
				
			}
			
		}
		
		
		
		return resp;

	}
	
	private String swap(String str,int i,int j) {
		char[] s = str.toCharArray();
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
		return new String(s);
	}

}
