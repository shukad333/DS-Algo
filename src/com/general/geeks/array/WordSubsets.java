package com.general.geeks.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * We are given two arrays A and B of words. Each word is a string of lowercase
 * letters.
 * 
 * Now, say that word b is a subset of word a if every letter in b occurs in a,
 * including multiplicity. For example, "wrr" is a subset of "warrior", but is
 * not a subset of "world".
 * 
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 * 
 * Return a list of all universal words in A. You can return the words in any
 * order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"] Example 2:
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * Output: ["apple","google","leetcode"] Example 3:
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * Output: ["facebook","google"] Example 4:
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * Output: ["google","leetcode"] Example 5:
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B =
 * ["ec","oc","ceo"] Output: ["facebook","leetcode"]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length, B.length <= 10000 1 <= A[i].length, B[i].length <= 10 A[i] and
 * B[i] consist only of lowercase letters. All words in A[i] are unique: there
 * isn't i != j with A[i] == A[j].
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class WordSubsets {

	public static void main(String[] args) {

		System.out.println(new WordSubsets().wordSubsets(
				new String[] { "amazon", "apple", "facebook", "google", "leetcode" }, new String[] { "lo", "eo" }));

	}

	public List<String> wordSubsets(String[] A, String[] B) {

		List<String> resp = new ArrayList<>();

		int[] countsB = new int[26];
		
		for(int i=0;i<B.length;i++) {
			int[] curr = getCountsArr(B[i]);
			for(int j=0;j<26;j++)
				countsB[j] = Math.max(countsB[j], curr[j]);
		}

		for (String s : A) {
			if (isUniversal(s, countsB))
				resp.add(s);
		}

		return resp;

	}

	private boolean isUniversal(String s, int[] countsB) {

		int[] countsA = new int[26];
		for (char c : s.toCharArray())
			countsA[c - 'a']++;

		for (int i = 0; i < 26; i++) {

			if (countsB[i] != 0 && countsB[i] > countsA[i])
				return false;
		}
		return true;
	}
	
	private int[] getCountsArr(String s) {
		int[] counts = new int[26];
		for(char c : s.toCharArray())
			counts[c-'a']++;
		
		return counts;
	}

}
