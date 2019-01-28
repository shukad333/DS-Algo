package com.general.geeks.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * You are given an integer array sorted in ascending order (may contain
 * duplicates), you need to split them into several subsequences, where each
 * subsequences consist of at least 3 consecutive integers. Return whether you
 * can make such a split.
 * 
 * Example 1: Input: [1,2,3,3,4,5] Output: True Explanation: You can split them
 * into two consecutive subsequences : 1, 2, 3 3, 4, 5 Example 2: Input:
 * [1,2,3,3,4,4,5,5] Output: True Explanation: You can split them into two
 * consecutive subsequences : 1, 2, 3, 4, 5 3, 4, 5 Example 3: Input:
 * [1,2,3,4,4,5] Output: False Note: The length of the input is in range of [1,
 * 10000]
 * 
 * 
 * @author skadavath
 *
 */
public class SplitArrayIntoConsecutiveSubsequences {

	public static void main(String[] args) {

		System.out.println(new SplitArrayIntoConsecutiveSubsequences().isPossible(new int[] { 1, 2, 3, 4, 5 }));
		
		
		
	}

	public boolean isPossible(int[] nums) {

		Map<Integer, Integer> originalFreq = new HashMap<>();
		Map<Integer, Integer> sequences = new HashMap<>();
		for (int i : nums)
			originalFreq.put(i, originalFreq.getOrDefault(i, 0) + 1);

		for (int i : nums) {

			if (originalFreq.get(i) == 0)
				continue;
			if (sequences.getOrDefault(i, 0) > 0) {

				sequences.put(i, sequences.get(i) - 1);
				sequences.put(i + 1, sequences.getOrDefault(i + 1, 0) + 1);

			}

			else if (originalFreq.getOrDefault(i + 1, 0) > 0 && originalFreq.getOrDefault(i + 2, 0) > 0) {
				originalFreq.put(i + 1, originalFreq.get(i + 1) - 1);
				originalFreq.put(i + 2, originalFreq.get(i + 2) - 1);
				sequences.put(i + 3, sequences.getOrDefault(i + 3, 0) + 1);
			}

			else
				return false;

			originalFreq.put(i, originalFreq.get(i) - 1);

		}

		return true;

	}

}
