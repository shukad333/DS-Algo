package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Two strings X and Y are similar if we can swap two letters (in different
 * positions) of X, so that it equals Y.
 * 
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2),
 * and "rats" and "arts" are similar, but "star" is not similar to "tars",
 * "rats", or "arts".
 * 
 * Together, these form two connected groups by similarity: {"tars", "rats",
 * "arts"} and {"star"}. Notice that "tars" and "arts" are in the same group
 * even though they are not similar. Formally, each group is such that a word is
 * in the group if and only if it is similar to at least one other word in the
 * group.
 * 
 * We are given a list A of strings. Every string in A is an anagram of every
 * other string in A. How many groups are there?
 * 
 * Example 1:
 * 
 * Input: ["tars","rats","arts","star"] Output: 2 Note:
 * 
 * A.length <= 2000 A[i].length <= 1000 A.length * A[i].length <= 20000 All
 * words in A consist of lowercase letters only. All words in A have the same
 * length and are anagrams of each other. The judging time limit has been
 * increased for this question.
 * 
 * @author skadavath
 *
 */
public class SimilarGroupString {

	public static void main(String[] args) {

		System.out.println(new SimilarGroupString().numSimilarGroups(new String[] { "tars", "rats", "arts", "star" }));

	}

	public int numSimilarGroups(String[] A) {

		int groups = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == null)
				continue;
			String s = A[i];
			A[i] = null;
			dfs(A, s);
			groups++;
		}

		return groups;
	}

	// Check if target can be buddy of any other String
	private void dfs(String[] A, String target) {

		for (int i = 0; i < A.length; i++) {
			if (A[i] == null)
				continue;
			if (iSBuddy(A[i], target)) {
				String s = A[i];
				A[i] = null;
				dfs(A, s);
			}
		}

	}

	// Check the diff and see if its 2. Need to check for equality of String as well

	private boolean iSBuddy(String A, String B) {

		int diff = 0;
		for (int i = 0; i < A.length() && diff <= 2; i++) {
			if (A.charAt(i) != B.charAt(i)) {
				diff++;
			}
		}
		return diff == 2;

	}

}
