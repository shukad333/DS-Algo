package com.general.geeks.misc;

/**
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 * 
 * Example 1:
 * 
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"] Output: 16 Explanation: The
 * two words can be "abcw", "xtfn". Example 2:
 * 
 * Input: ["a","ab","abc","d","cd","bcd","abcd"] Output: 4 Explanation: The two
 * words can be "ab", "cd". Example 3:
 * 
 * Input: ["a","aa","aaa","aaaa"] Output: 0 Explanation: No such pair of words.
 * 
 * @author skadavath
 *
 */
public class MaximumProductOfWodLengths {
	
	public static void main(String[] args) {
		System.out.println(new MaximumProductOfWodLengths().maxProduct(new String[] {"a","ab","abc","d","cd","bcd","abcd"}));
	}

	public int maxProduct(String[] words) {
		
		int[] wordBit = new int[words.length];
		int maxCount = 0;
		
		for(int i=0;i<words.length;i++) {
			
			for(int j=0;j<words[i].length();j++) {
				wordBit[i] |= 1<<(words[i].charAt(j)-'a');
			}
		}
		
		for(int i=0;i<wordBit.length;i++) {
			for(int j=i+1;j<wordBit.length;j++) {
				if((wordBit[i]&wordBit[j])==0 && (maxCount<words[i].length()*words[j].length())) {
					maxCount = words[i].length()*words[j].length();
				}
			}
		}
		
		return maxCount; 

	}

}
