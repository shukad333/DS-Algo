package com.general.geeks.misc;

import java.util.Arrays;

/**
 * 
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

 

Example 1:

Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
Example 2:

Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 

Constraints:

1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] are English lowercase letters.
 * 
 * @author skadavath
 *
 */
public class CompareStringsbyFrequencyoftheSmallestCharacter {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new CompareStringsbyFrequencyoftheSmallestCharacter().numSmallerByFrequency(new String[] {"bbb","cc"}, new String[] {"a","aa","aaa","aaaa"})));
	}

	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		
		int[] queryCounts = new int[queries.length];
		int[] wordCounts = new int[words.length];
		
		int i=0;
		for(String q : queries) {
			queryCounts[i++] = getLowestCount(q);
		}
		i=0;
		for(String w : words) {
			wordCounts[i++] = getLowestCount(w);
		}
		
		Arrays.sort(wordCounts);
		int[] resp = new int[queryCounts.length];
		
		for(i=0;i<queryCounts.length;i++) {
			
			int left = 0,right=wordCounts.length-1;
			while(left<=right) {
				
				int mid = (left+right)>>1;
				if(wordCounts[mid]<=queryCounts[i])
					left = mid+1;
				else
					right=mid-1;
				
			}
			resp[i] = wordCounts.length-left;
		}
		
		return resp;

	}
	
	private int getLowestCount(String word) {
		int[] counts = new int[26];
		for(char c : word.toCharArray()) {
			counts[c-'a']++;
		}
		for(int i=0;i<26;i++)
			if(counts[i]!=0)
				return counts[i];
		return 0;
	}

}
