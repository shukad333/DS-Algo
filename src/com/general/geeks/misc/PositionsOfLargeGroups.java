package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of
 * the same character.
 * 
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx",
 * "z" and "yy".
 * 
 * Call a group large if it has 3 or more characters. We would like the starting
 * and ending positions of every large group.
 * 
 * The final answer should be in lexicographic order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "abbxxxxzzy" Output: [[3,6]] Explanation: "xxxx" is the single large
 * group with starting 3 and ending positions 6. Example 2:
 * 
 * Input: "abc" Output: [] Explanation: We have "a","b" and "c" but no large
 * group. Example 3:
 * 
 * Input: "abcdddeeeeaabbbcd" Output: [[3,5],[6,9],[12,14]]
 * 
 * 
 * Note: 1 <= S.length <= 1000
 * 
 * @author skadavath
 *
 */
public class PositionsOfLargeGroups {

	public static void main(String[] args) {
		List<List<Integer>> resp = new PositionsOfLargeGroups().largeGroupPositions("abcdddeeeeaabbbcd");
		for(List<Integer> l : resp) {
			for(int i : l) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> resp = new ArrayList<>();
		int i = 0, j = 0;
		while (i < S.length()) {
			while(j<S.length() && S.charAt(i)==S.charAt(j)) j++;
			if(j-i>=3) resp.add(Arrays.asList(i,j-1));
			i = j;
		}
		return resp;

	}
}
